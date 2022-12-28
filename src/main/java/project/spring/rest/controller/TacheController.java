package project.spring.rest.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.spring.entites.Tache;
import project.spring.rest.dto.TacheDto;
import project.spring.service.TacheService;

@CrossOrigin
@RestController
public class TacheController {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	TacheService tacheService;

	@GetMapping("/taches")
	@ResponseBody
	public List <Tache> getAllTaches(){
		List <Tache> list = tacheService.getAllTache();
		List <TacheDto> listDtos = modelMapper.map(list, new TypeToken <List<TacheDto>>(){}.getType());
		return list;
	}

	@PostMapping("/taches")
	public Object ajouterTache(@RequestBody() TacheDto tacheDto) {
		Tache tache=modelMapper.map(tacheDto, Tache.class);
		tache = tacheService.ajouterTache(tache);
		tacheDto = modelMapper.map(tache, TacheDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(tacheDto);
		
	}
	
	
	@PutMapping("/taches/{id}")
	public Object updateTache(@PathVariable("id") Long id , @RequestBody TacheDto tacheDto) {
		Tache tache=modelMapper.map(tacheDto, Tache.class);
		tache = tacheService.updateTache(id, tache);
		tacheDto=modelMapper.map(tache, TacheDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(tacheDto);
	}
	
	@GetMapping("/taches/{id}")
	public Object findByIdTache (@PathVariable("id") long id) {
		Tache tache = tacheService.findByIdTache(id);
		TacheDto tacheDto=modelMapper.map(tache, TacheDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(tacheDto);
		
	}
	
	@DeleteMapping("/taches/{id}")
	@ResponseBody
	public Object deleteTache(@PathVariable("id") Long idTache) {
		tacheService.deleteTache(idTache);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	
	
	
	

}