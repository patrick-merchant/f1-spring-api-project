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

    @GetMapping
    public ResponseEntity<List<Team>> getTeams() {
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }

    // show mapping
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Team>> getTeam(@PathVariable Long id) {
        var team = teamRepository.findById(id);
        // ternary operator: condition ? true statement : false statement
        return new ResponseEntity<>(team, team.isEmpty() ?  HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // create/post
    @PostMapping
    public void createTeam(@RequestBody Team team) {
        teamRepository.save(team);
    }
    // todo: add delete.

}
