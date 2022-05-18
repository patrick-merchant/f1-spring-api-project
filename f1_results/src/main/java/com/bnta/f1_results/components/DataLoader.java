package com.bnta.f1_results.components;

import com.bnta.f1_results.models.Race;
import com.bnta.f1_results.repositories.DriverRepository;
import com.bnta.f1_results.repositories.RaceRepository;
import com.bnta.f1_results.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // todo: Add some races

        // todo: Add some drivers

        //todo: Add some teams

    }
}
