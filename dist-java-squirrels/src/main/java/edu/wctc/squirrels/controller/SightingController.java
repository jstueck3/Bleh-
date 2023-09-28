package edu.wctc.squirrels.controller;

import edu.wctc.squirrels.entity.Sighting;
import edu.wctc.squirrels.service.LocationService;
import edu.wctc.squirrels.service.SightingService;
import edu.wctc.squirrels.service.SquirrelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SightingController {
    private final SquirrelService squirrelService;
    private final SightingService sightingService;
    private final LocationService locationService;

    @Autowired
    public SightingController(SquirrelService squirrelService,
                              SightingService sightingService,
                              LocationService locationService) {
        this.squirrelService = squirrelService;
        this.sightingService = sightingService;
        this.locationService = locationService;
    }

    @ModelAttribute
    public void locationList(Model model) {
        model.addAttribute("locationList", locationService.getLocationList());
    }

    @PostMapping("/save")
    public String processSighting(Model model,
                                  @Valid @ModelAttribute Sighting sighting,
                                  BindingResult bindingResult) {
        int squirrelId = sighting.getSquirrelId();

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
//            model.addAttribute("locationList", locationService.getLocationList());
            model.addAttribute("squirrel", squirrelService.getSquirrel(squirrelId));
            return "sighting-form";
        }

        sightingService.saveSighting(sighting);

        model.addAttribute("squirrel", squirrelService.getSquirrel(squirrelId));
        model.addAttribute("sightingList", sightingService.getSightingsForSquirrel(squirrelId));

        return "confirmation";
    }

    @RequestMapping("/sightings")
    public String showRecentSightings(Model model,
                                      @RequestParam("id") int squirrelId) {
        model.addAttribute("squirrel", squirrelService.getSquirrel(squirrelId));
        model.addAttribute("sightingList", sightingService.getSightingsForSquirrel(squirrelId));
        return "sightings";
    }

    @RequestMapping("/report")
    public String showSightingForm(Model model,
                                   @RequestParam("id") int squirrelId) {
//        model.addAttribute("locationList", locationService.getLocationList());
        model.addAttribute("squirrel", squirrelService.getSquirrel(squirrelId));

        Sighting si = new Sighting();
        si.setSquirrelId(squirrelId);
        model.addAttribute("sighting", si);

        return "sighting-form";
    }

    @RequestMapping("/list")
    public String showSquirrelList(Model model) {
        model.addAttribute("squirrelList", squirrelService.getSquirrelList());

        return "squirrel-list";
    }
}
