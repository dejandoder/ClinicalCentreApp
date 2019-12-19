package isa.project.controller;

import java.util.List;

import isa.project.dto.PretragaLjekaraDTO;
import isa.project.model.Ljekar;
import isa.project.service.LjekarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ljekari")
public class LjekarController {
	
	@Autowired
	private LjekarService ljekarService;
	
	
	@RequestMapping(value = "/pretragaLjekara", method = RequestMethod.POST)
	public List<Ljekar> pretragaLjekara(@RequestBody PretragaLjekaraDTO parametar){
		return ljekarService.pretragaLjekara(parametar);
	}

}
