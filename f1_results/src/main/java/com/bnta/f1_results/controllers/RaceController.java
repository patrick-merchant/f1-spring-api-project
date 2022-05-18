package com.bnta.f1_results.controllers;


import com.bnta.f1_results.models.Race;
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

    // INDEX
    @GetMapping
    public ResponseEntity<List<Race>> getRaces() {
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

    // todo: add delete.
    // DELETE

}
