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

    // INDEX
    @GetMapping
    public ResponseEntity<List<Driver>> getDrivers() {
        return new ResponseEntity<>(driverRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Driver>> getDriver(@PathVariable Long id) {
        var driver = driverRepository.findById(id);
        // ternary operator: condition ? true statement : false statement
        return new ResponseEntity<>(driver, driver.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity createDriver(@RequestBody Driver newDriver) {
        driverRepository.save(newDriver);
        return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
    }

    // todo: add delete.
    // DELETE
}

