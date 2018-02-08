package com.boot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
//import org.springframework.test.context.web.WebAppConfiguration;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
//@WebAppConfiguration
public class ShipwreckRepositoryIntegrationTest {
	
	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@Test
	public void testFindAll() {
		List<Shipwreck> wrecks = shipwreckRepository.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}
}
