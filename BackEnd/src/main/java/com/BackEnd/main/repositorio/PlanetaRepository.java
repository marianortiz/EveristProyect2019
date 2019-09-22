package com.BackEnd.main.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackEnd.main.entidades.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Integer>{
	
}
