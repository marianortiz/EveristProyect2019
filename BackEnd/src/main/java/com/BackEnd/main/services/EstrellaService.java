package com.BackEnd.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BackEnd.main.dtos.EstrellaDTO;
import com.BackEnd.main.entidades.Estrella;
import com.BackEnd.main.entidades.Planeta;
import com.BackEnd.main.repositorio.EstrellaRerpository;

@Service
public class EstrellaService implements ObjectService<EstrellaDTO> {
	
	private EstrellaRerpository estrellaRepository;
	
	public EstrellaService(EstrellaRerpository estrellaRepository) {
		this.estrellaRepository = estrellaRepository;
	}

	@Override
	public List<EstrellaDTO> getAll() {
		
		List<EstrellaDTO> result = new ArrayList<>();
		
		for(Estrella estrella : estrellaRepository.findAll()) {
			EstrellaDTO temp = new EstrellaDTO();
			
			temp.setId(estrella.getId());
			temp.setNombre(estrella.getNombre());
			temp.setTamanio(estrella.getTamanio());
			result.add(temp);
		}
		return result;
	}

	@Override
	public EstrellaDTO getOne(int id) {
		Optional<Estrella> aOptional = estrellaRepository.findById(id);
		
		EstrellaDTO temp = new EstrellaDTO();
		
		try {
			
			Estrella estrella = aOptional.get();
			
			temp.setId(estrella.getId());
			temp.setNombre(estrella.getNombre());
			temp.setTamanio(estrella.getTamanio());
			
			
		} catch (Exception e) {
			System.out.println("no existe el id");
		}
		return temp;
	}

	@Override
	public EstrellaDTO save(EstrellaDTO t) {
		Estrella estrella = new Estrella();
		
		estrella.setNombre(t.getNombre());
		estrella.setTamanio(t.getTamanio());
		
		try {
		estrellaRepository.save(estrella);
		}catch (Exception e) {
			
			
		}
		
		t.setId(estrella.getId());
		
		return t;
	}

	@Override
	public EstrellaDTO update(EstrellaDTO t, int id) {
	
		Optional<Estrella> pOptional = estrellaRepository.findById(id);
		
		Estrella temp = new Estrella();
		
		try {
			
			temp = pOptional.get();
			
			temp.setNombre(t.getNombre());
			temp.setTamanio(t.getTamanio());
			
			estrellaRepository.save(temp);
			
			t.setId(temp.getId());
			
		} catch (Exception e) {
			System.out.println("n existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			estrellaRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	

	

}
