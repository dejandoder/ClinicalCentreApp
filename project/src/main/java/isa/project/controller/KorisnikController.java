package isa.project.controller;

import javax.servlet.http.HttpServletRequest;

import isa.project.model.Korisnik;
import isa.project.model.Role;
import isa.project.service.EmailService;
import isa.project.service.KorisnikService;

import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "korisnici")
public class KorisnikController {

	private Logger logger = LoggerFactory.getLogger(KorisnikController.class);

	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	private EmailService emailService;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@RequestMapping(value = "/registracija", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Korisnik> registrujKorisnika(
			@RequestBody Korisnik novi) {
		if (novi == null) {
			return new ResponseEntity<>(novi, HttpStatus.BAD_REQUEST);
		} else {
			Korisnik provjeraMejla = korisnikService.findByEmail(novi
					.getEmail());
			if (provjeraMejla == null) {

				String hashPass = "";
				hashPass = encoder.encode(novi.getPassword());
				novi.setPassword(hashPass);
				// automatsko postavljanje da je korisnik verifikovan, zbog
				// nepostojanosti profila ljekara
				novi.setVerifikovan(true);
				novi.setRole(Role.REGISTROVAN);

				// simulacija slanja mejla za verifikaciju
				try {
					emailService.slanjeMejlaZaVerifikaciju(novi);
				} catch (Exception e) {
					logger.info("Greska prilikom slanja emaila: "
							+ e.getMessage());
				}

				korisnikService.saveUser(novi);

				return new ResponseEntity<>(novi, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(novi, HttpStatus.BAD_REQUEST);
			}

		}

	}

	@RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Korisnik getCurrentUser(
			@Context HttpServletRequest request) {
		Korisnik user = korisnikService.getCurrentUser();
		return user;
	}

	@RequestMapping(value = "/trenutniKorisnik", method = RequestMethod.GET)
	public Korisnik trenutniKorisnik(@Context HttpServletRequest request) {
		return korisnikService.getCurrentUser();
	}

	@RequestMapping(value = "/izmjena", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Korisnik> izmijeniKorisnika(
			@RequestBody Korisnik novi) {

		// String hashPass = "";
		// hashPass = encoder.encode(novi.getPassword());
		// novi.setPassword(hashPass);
		korisnikService.saveUser(novi);

		return new ResponseEntity<>(novi, HttpStatus.OK);
	}

	@RequestMapping(value = "/izmjenaLozinke", method = RequestMethod.POST)
	void izmijeniLozinkuKorisnika(@RequestBody String novi) {
		Korisnik user = korisnikService.getCurrentUser();
		String hashPass = "";
		hashPass = encoder.encode(novi);
		user.setPassword(hashPass);
		korisnikService.saveUser(user);

		// return novi;
	}

	@RequestMapping(value = "/verifikuj/{email}", method = RequestMethod.GET)
	void verifikuj(@PathVariable String email) {
		Korisnik korisnik = korisnikService.findByEmail(email);
		korisnik.setVerifikovan(true);
		korisnik.setRole(Role.REGISTROVAN);
		korisnikService.saveUser(korisnik);
		// return korisnikService.getCurrentUser();
	}

}
