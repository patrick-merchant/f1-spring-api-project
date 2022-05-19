package com.bnta.f1_results;

import com.bnta.f1_results.repositories.DriverRepository;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class F1ResultsApplicationTests {

	@Autowired
	private DriverRepository driverRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void testFindByNationality() {
		assertThat(driverRepository.findByNationalityEquals("German").size()).isEqualTo(3);
	}

}
