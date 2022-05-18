package com.bnta.f1_results.repositories;

import com.bnta.f1_results.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
