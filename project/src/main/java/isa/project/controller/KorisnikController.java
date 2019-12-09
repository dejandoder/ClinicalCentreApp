package isa.project.controller;

import javax.servlet.http.HttpServletRequest;

import isa.project.model.Korisnik;
import isa.project.service.KorisnikService;

import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@RequestMapping(value = "/registracija", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Korisnik> registrujKorisnika(@RequestBody Korisnik novi) {
		//Korisnik registrovan = new Korisnik();
		
		String hashPass="";
		hashPass=encoder.encode(novi.getPassword());
		novi.setPassword(hashPass);
		korisnikService.saveUser(novi);
		
				
        
		return new ResponseEntity<>(novi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Korisnik getCurrentUser(@Context HttpServletRequest request) {
		Korisnik user = korisnikService.getCurrentUser();
		return user;
	}
	

}
