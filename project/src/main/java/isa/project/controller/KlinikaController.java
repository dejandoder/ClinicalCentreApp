package isa.project.controller;

import java.util.List;

import isa.project.model.Klinika;
import isa.project.service.KlinikaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "klinike")
public class KlinikaController {
	
	@Autowired
	private KlinikaService klinikaService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Klinika>> getAllPregled() {
		
		List<Klinika> klinike = klinikaService.findAll();
		return new ResponseEntity<>(klinike, HttpStatus.OK);
		
	}

}
