package isa.project.controller;

import java.util.List;

import isa.project.model.Pregled;
import isa.project.service.PregledService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pregledi")
public class PregledController {
	
	@Autowired
	private PregledService pregledService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Pregled>> getAllPregled() {
		
		List<Pregled> students = pregledService.findAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
		
	}

}
