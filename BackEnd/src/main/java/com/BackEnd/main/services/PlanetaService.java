package com.BackEnd.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BackEnd.main.dtos.EstrellaDTO;
import com.BackEnd.main.dtos.PlanetaDTO;
import com.BackEnd.main.entidades.Estrella;
import com.BackEnd.main.entidades.Planeta;
import com.BackEnd.main.repositorio.PlanetaRepository;







@Service
public class PlanetaService implements ObjectService<PlanetaDTO> {
	
	private PlanetaRepository planetaRepository;
	
	public PlanetaService(PlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}
	
	@Override
	public List<PlanetaDTO> getAll() {
		
		List<PlanetaDTO> result = new ArrayList<>();
		
		for(Planeta planeta: planetaRepository.findAll()) {
			PlanetaDTO temp = new PlanetaDTO();
			EstrellaDTO estrellaDTO =  new EstrellaDTO();
			temp.setId(planeta.getId());
			temp.setNombre(planeta.getNombre());
			temp.setDencidad(planeta.getDencidad());
			temp.setTamanio(planeta.getTamanio());
			estrellaDTO.setNombre(planeta.getEstrella().getNombre());
			estrellaDTO.setId(planeta.getEstrella().getId());
			estrellaDTO.setTamanio(planeta.getEstrella().getTamanio());
			
			temp.setEstrellaDTO(estrellaDTO);
			
			result.add(temp);
			
		}
		return result;
	}

	@Override
	public PlanetaDTO getOne(int id) {
		
		Optional<Planeta> aOptional = planetaRepository.findById(id);
		
		PlanetaDTO temp = new PlanetaDTO();
		
		try {
			
			Planeta planeta = aOptional.get();
			
			temp.setId(planeta.getId());
			temp.setNombre(planeta.getNombre());
			temp.setDencidad(planeta.getDencidad());
			temp.setTamanio(planeta.getTamanio());
			
			
			EstrellaDTO estrelladto = new EstrellaDTO();
			
			estrelladto.setId(planeta.getEstrella().getId());
			estrelladto.setNombre(planeta.getEstrella().getNombre());
			estrelladto.setTamanio(planeta.getEstrella().getTamanio());
			
			temp.setEstrellaDTO(estrelladto);
			
			return temp;
				
			
			
		} catch (Exception e) {
			System.out.println("no existe el id");
		}
		return temp;
	}

	@Override
	public PlanetaDTO save(PlanetaDTO t) {
		
		Planeta planeta = new Planeta();
		
		planeta.setNombre(t.getNombre());
		planeta.setTamanio(t.getTamanio());
		planeta.setDencidad(t.getDencidad());
		
		Estrella estrella = new Estrella();
		
		estrella.setId(t.getEstrellaDTO().getId());
		
		
		planeta.setEstrella(estrella);
		
		planetaRepository.save(planeta);
		
		t.setId(planeta.getId());
		
		return t;
		
	}

	@Override
	public PlanetaDTO update(PlanetaDTO t, int id) {
		Optional<Planeta> pOptional = planetaRepository.findById(id);
		
		Planeta temp = new Planeta();
		
		
		try {
			Estrella star = new Estrella();
			
			temp = pOptional.get();
			
			temp.setNombre(t.getNombre());
			temp.setDencidad(t.getDencidad());
			temp.setTamanio(t.getTamanio());
			
			star.setId(t.getEstrellaDTO().getId());
			star.setNombre(t.getEstrellaDTO().getNombre());
			star.setTamanio(t.getEstrellaDTO().getTamanio());
			
			temp.setEstrella(star);
			
			planetaRepository.save(temp);
			
			t.setId(temp.getId());
			
		} catch (Exception e) {
			System.out.println("n existe");
		}
		return t;
	}

	@Override
	public boolean delete(int id) {
		try {
			planetaRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	

}
