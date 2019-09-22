package com.BackEnd.main.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackEnd.main.dtos.PlanetaDTO;
import com.BackEnd.main.services.PlanetaService;

@Controller
@RestController
@RequestMapping(path = "api/v1/planetas")
public class PlanetaController implements ObjectController<PlanetaDTO> {
	private PlanetaService planetaService;

	public PlanetaController(PlanetaService planetaService) {
		this.planetaService = planetaService;
	}

	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public List<PlanetaDTO> getAll() {
		return ResponseEntity.status(200).body(planetaService.getAll()).getBody();
	}

	@Override
	@CrossOrigin("*")
	@GetMapping("/{id}")
	public PlanetaDTO getOne(@PathVariable int id) {
		
		return ResponseEntity.status(200).body(planetaService.getOne(id)).getBody();
		
	}

	@Override
	@CrossOrigin("*")
	@PostMapping("/")
	public ResponseEntity save(@RequestBody PlanetaDTO t) {
		
		
		PlanetaDTO temp = planetaService.save(t);
		
		if(temp.getId() != 0) {
			return ResponseEntity.status(201).body(temp);
		}else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
		
	}

	@Override
	@CrossOrigin("*")
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody PlanetaDTO t,@PathVariable int id) {
		
		
		
		return ResponseEntity.status(201).body(planetaService.update(t, id));	
		
	}

	@Override
	@CrossOrigin("*")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = planetaService.delete(id);
		if (det = true) {
			return ResponseEntity.status(204).body("'message': 'Great Delete'");
		}else {
			return ResponseEntity.status(400).body("'message': 'unsucefully delete'");
		}
	}
	
	
}
