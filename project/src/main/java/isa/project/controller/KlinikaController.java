package isa.project.controller;

import isa.project.service.KlinikaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "klinike")
public class KlinikaController {
	
	@Autowired
	private KlinikaService klinikaService;

}
