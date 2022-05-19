package com.bnta.f1_results;

import com.bnta.f1_results.repositories.DriverRepository;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.bnta.f1_results.repositories.RaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class F1ResultsApplicationTests {

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private RaceRepository raceRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testFindByNationality() {
		assertThat(driverRepository.findByNationalityEquals("German").size()).isEqualTo(3);
	}

	@Test
	public void testFindByRacesName() {
		assertThat(driverRepository.findByRacesName("Australian Grand Prix").size()).isEqualTo(20);
	}

	@Test
	public void testFindDistinctDriversByRacesYear() {
		assertThat(driverRepository.findDistinctDriversByRacesYear(2021).size()).isEqualTo(20);
	}

	@Test
	public void testFindRaceByYear(){
		assertThat(raceRepository.findRaceByYear(2022).size()).isEqualTo(5);
	}

}
