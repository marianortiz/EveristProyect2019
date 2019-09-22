package com.BackEnd.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.BackEnd.main.dtos.EstrellaDTO;
import com.BackEnd.main.entidades.Estrella;
import com.BackEnd.main.repositorio.EstrellaRerpository;
import com.BackEnd.main.services.EstrellaService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEstrellaService {

	@Autowired
	EstrellaService estrellaservice;
	EstrellaRerpository estrellaRespository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
