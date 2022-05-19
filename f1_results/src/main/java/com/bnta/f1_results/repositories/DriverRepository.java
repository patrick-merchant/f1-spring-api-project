package com.bnta.f1_results.repositories;

import com.bnta.f1_results.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

// first derived query - find driver by country
    List<Driver> findByNationalityEquals(String nationality);

    List<Driver> findByRacesName(String name);
    // This derived query traverses the association between Races and Drivers.
    // It basically works by generating an SQL query with a temporary join between drivers and races, then
    // selecting from that temporary joined table.

    List<Driver> findDistinctDriversByRacesYear(int year);

}
