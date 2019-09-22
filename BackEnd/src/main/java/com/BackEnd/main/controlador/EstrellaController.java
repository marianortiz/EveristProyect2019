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

import com.BackEnd.main.dtos.EstrellaDTO;
import com.BackEnd.main.services.EstrellaService;

@Controller
@RestController
@RequestMapping(path = "api/v1/estrellas")
public class EstrellaController implements ObjectController<EstrellaDTO>{

	private EstrellaService estrellaService;
	
	public EstrellaController(EstrellaService estrellaService) {
		this.estrellaService = estrellaService;
	}
	
	@Override
	@CrossOrigin("*")
	@GetMapping(path = "/")
	public List<EstrellaDTO> getAll() {
		return ResponseEntity.status(200).body(estrellaService.getAll()).getBody();
	}

	@Override
	@CrossOrigin("*")
	@GetMapping("/{id}")
	public EstrellaDTO getOne(@PathVariable int id) {
		return ResponseEntity.status(200).body(estrellaService.getOne(id)).getBody();
	}

	@Override
	@CrossOrigin("*")
	@PostMapping("/")
	public ResponseEntity save(@RequestBody EstrellaDTO t) {
		
		EstrellaDTO temp = estrellaService.save(t);
		
		if(temp.getId() != 0) {
			return ResponseEntity.status(201).body(t);
		}else {
			return ResponseEntity.status(400).body("{'error' : 'bad request'}");
		}
		
	}

	@Override
	@CrossOrigin("*")
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody EstrellaDTO t,@PathVariable int id) {
		
		return ResponseEntity.status(201).body(estrellaService.update(t, id));	
	
	}

	@Override
	@CrossOrigin("*")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean det = estrellaService.delete(id);
		if (det = true) {
			return ResponseEntity.status(204).body("'message': 'Great Delete'");
		}else {
			return ResponseEntity.status(400).body("'message': 'unsucefully delete'");
		}
	}

	

}
