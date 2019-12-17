package isa.project.controller;

import java.util.List;

import isa.project.model.Korisnik;
import isa.project.model.Pregled;
import isa.project.model.StanjePregleda;
import isa.project.service.EmailService;
import isa.project.service.KorisnikService;
import isa.project.service.PregledService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pregledi")
public class PregledController {
	
	private Logger logger = LoggerFactory.getLogger(PregledController.class);
	
	@Autowired
	private PregledService pregledService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private EmailService emailService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
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
		
		try {
			emailService.slanjeMejlaZaDostupnePreglede(trenutni);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
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
	
	@GetMapping(value = "/istorija")
	public ResponseEntity<List<Pregled>> getIstorija() {
		
		List<Pregled> pregledi = pregledService.getIstorijaPregleda();
		return new ResponseEntity<>(pregledi, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/sviDostupni")
	public ResponseEntity<List<Pregled>> getDostupniPregled() {
		
		List<Pregled> pregledi = pregledService.getDostupniPregledi();
		return new ResponseEntity<>(pregledi, HttpStatus.OK);
		
	}
	

}
