package edu.wctc.squirrels.service;

import edu.wctc.squirrels.entity.Location;
import edu.wctc.squirrels.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicLocationService implements LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public BasicLocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getLocationList() {
        return locationRepository.findAllByOrderByCountryAscName();
    }
}
