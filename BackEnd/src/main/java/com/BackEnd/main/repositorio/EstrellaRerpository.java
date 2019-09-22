package com.BackEnd.main.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BackEnd.main.entidades.Estrella;

@Repository
public interface EstrellaRerpository extends JpaRepository<Estrella, Integer>{
}
