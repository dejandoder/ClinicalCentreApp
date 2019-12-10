package isa.project.controller;

import java.util.List;

import isa.project.model.Korisnik;
import isa.project.model.Pregled;
import isa.project.model.StanjePregleda;
import isa.project.service.KorisnikService;
import isa.project.service.PregledService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "pregledi")
public class PregledController {
	
	@Autowired
	private PregledService pregledService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Pregled>> getAllPregled() {
		
		List<Pregled> pregledi = pregledService.findAll();
		return new ResponseEntity<>(pregledi, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/zakaziDostupni", method=RequestMethod.POST)
	public Pregled zakaziDostupniPregled(@RequestBody Pregled pregled){
		Korisnik trenutni = korisnikService.getCurrentUser();
		pregled.setStanje(StanjePregleda.ZAKAZAN);
		pregled.setKorisnik(trenutni);
		pregledService.savePregled(pregled);
		return pregled;
				
	}
	
	@RequestMapping(value="/otkazi", method=RequestMethod.POST)
	public Pregled otkaziPregled(@RequestBody Pregled pregled){
		Korisnik trenutni = korisnikService.getCurrentUser();
		pregled.setStanje(StanjePregleda.OTKAZAN);
		pregled.setKorisnik(trenutni);
		pregledService.savePregled(pregled);
		return pregled;
				
	}
	
	@GetMapping(value = "/zakazani")
	public ResponseEntity<List<Pregled>> getZakazani() {
		
		List<Pregled> pregledi = pregledService.getPregledZakazani();
		return new ResponseEntity<>(pregledi, HttpStatus.OK);
		
	}

}
