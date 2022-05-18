package com.bnta.f1_results.controllers;

import com.bnta.f1_results.models.Team;
import com.bnta.f1_results.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Team>> getTeams() {
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Team>> getTeam(@PathVariable Long id) {
        var team = teamRepository.findById(id);
        // ternary operator: condition ? true statement : false statement
        return new ResponseEntity<>(team, team.isEmpty() ?  HttpStatus.NOT_FOUND : HttpStatus.OK);
        // todo: check this ternary operator is working correctly.

    }

    // POST
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team newTeam) {
        teamRepository.save(newTeam);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }

    // todo: add delete.
//     DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTeam (@PathVariable("id") Long id) {
        teamRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
