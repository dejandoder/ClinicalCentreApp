package isa.project.controller;

import isa.project.service.PregledService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pregledi")
public class PregledController {
	
	@Autowired
	private PregledService pregledService;

}
