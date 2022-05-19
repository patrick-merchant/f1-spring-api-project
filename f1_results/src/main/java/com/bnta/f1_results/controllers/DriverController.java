package com.bnta.f1_results.controllers;

import com.bnta.f1_results.models.Driver;
import com.bnta.f1_results.models.Race;
import com.bnta.f1_results.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("drivers")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

//    // INDEX
//    @GetMapping
//    public ResponseEntity<List<Driver>> getDrivers() {
//        return new ResponseEntity<>(driverRepository.findAll(), HttpStatus.OK);
//    }


    // INDEX AND FILTERS:
    // GET /drivers
    // GET /drivers?nationality=German
    // GET /drivers?

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDriversAndFilters(
            @RequestParam(required = false, name = "nationality") String nationality
    ){
        if(nationality != null){
            return new ResponseEntity<>(driverRepository.findByNationalityEquals(nationality), HttpStatus.OK);
        } else
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

    //     DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDriver (@PathVariable("id") Long id) {
        driverRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

