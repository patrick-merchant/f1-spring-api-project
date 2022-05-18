package com.bnta.f1_results.repositories;

import com.bnta.f1_results.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
