package com.bnta.f1_results.controllers;

import com.bnta.f1_results.models.Driver;
import com.bnta.f1_results.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("drivers")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping
    public ResponseEntity<List<Driver>> getDrivers() {
        return new ResponseEntity<>(driverRepository.findAll(), HttpStatus.OK);
    }

    // show mapping
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Driver>> getDriver(@PathVariable Long id) {
        var driver = driverRepository.findById(id);
        // ternary operator: condition ? true statement : false statement
        return new ResponseEntity<>(driver, driver.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // create/post
    @PostMapping
    public void createDriver(@RequestBody Driver driver) {
        driverRepository.save(driver);
    }

    // todo: add delete.
}

