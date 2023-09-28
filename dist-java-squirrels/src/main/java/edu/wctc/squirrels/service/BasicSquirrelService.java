package edu.wctc.squirrels.service;

import edu.wctc.squirrels.entity.Squirrel;
import edu.wctc.squirrels.repo.SquirrelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicSquirrelService implements SquirrelService {
    private final SquirrelRepository squirrelRepository;

    @Autowired
    public BasicSquirrelService(SquirrelRepository squirrelRepository) {
        this.squirrelRepository = squirrelRepository;
    }

    @Override
    public Squirrel getSquirrel(int squirrelId) {
        Optional<Squirrel> s = squirrelRepository.findById(squirrelId);
        return s.orElse(null);

    }

    @Override
    public List<Squirrel> getSquirrelList() {
        List<Squirrel> list = new ArrayList<>();
        squirrelRepository.findAll().forEach(list::add);
        return list;
    }
}
