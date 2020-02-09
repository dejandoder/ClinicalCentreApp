package isa.project.controller;

import java.util.List;

import isa.project.dto.PretragaLjekaraDTO;
import isa.project.model.Ljekar;
import isa.project.service.LjekarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ljekari")
public class LjekarController {

	@Autowired
	private LjekarService ljekarService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Ljekar>> getAllLjekar() {

		List<Ljekar> ljekari = ljekarService.findAll();
		return new ResponseEntity<>(ljekari, HttpStatus.OK);

	}

	@RequestMapping(value = "/pretragaLjekara", method = RequestMethod.POST)
	public List<Ljekar> pretragaLjekara(
			@RequestBody PretragaLjekaraDTO parametar) {
		return ljekarService.pretragaLjekara(parametar);
	}
	
	@RequestMapping(value = "/ocijeniLjekara/{parametar}", method = RequestMethod.POST)
	public Ljekar ocjenaLjekara(
			@RequestBody Ljekar ljekar, @PathVariable double parametar) {
		double rezultat=0;
		Ljekar lj = ljekarService.findLjekarById(ljekar.getId());
		rezultat=(lj.getOcjena() + parametar)/2;
		double konacno = ljekarService.konacanRezultat(rezultat);
		lj.setOcjena(konacno);
		ljekarService.saveLjekar(lj);
		return ljekar;
	}

}
