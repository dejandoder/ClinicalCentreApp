package isa.project.controller;

import isa.project.model.Korisnik;
import isa.project.service.KorisnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "korisnici")
public class KorisnikController {
	
	@Autowired
	KorisnikService korisnikService;
	
	@RequestMapping(value = "/registracija", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Korisnik> registrujKorisnika(@RequestBody Korisnik novi) {
		Korisnik registrovan = new Korisnik();
		korisnikService.saveUser(novi);
        
		return new ResponseEntity<>(novi, HttpStatus.OK);
	}
	

}
