package isa.project.controller;

import isa.project.service.LjekarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ljekari")
public class LjekarController {
	
	@Autowired
	private LjekarService ljekarService;

}
