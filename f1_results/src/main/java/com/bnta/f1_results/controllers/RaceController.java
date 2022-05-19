package com.bnta.f1_results.controllers;


import com.bnta.f1_results.models.Driver;
import com.bnta.f1_results.models.Race;
import com.bnta.f1_results.repositories.DriverRepository;
import com.bnta.f1_results.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("races")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private DriverRepository driverRepository;

    // INDEX
//    @GetMapping
//    public ResponseEntity<List<Race>> getRaces() {
//        return new ResponseEntity<>(raceRepository.findAll(), HttpStatus.OK);
//    }

    // INDEX AND FILTERS
    // GET /races?year=2022
    @GetMapping
    public ResponseEntity<List<Race>> getAllDriversAndFilters(
            @RequestParam(required = false, name = "year") Integer year
    ){
        if(year != null){
            return new ResponseEntity<>(raceRepository.findRaceByYear(year), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(raceRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Race>> getRace(@PathVariable Long id) {
        var race = raceRepository.findById(id);
        // ternary operator: condition ? true statement : false statement
        return new ResponseEntity<>(race, race.isEmpty() ?  HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<Race> createRace(@RequestBody Race newRace) {
        raceRepository.save(newRace);
        return new ResponseEntity<>(newRace, HttpStatus.CREATED);

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteRace (@PathVariable("id") Long id) {
        raceRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
