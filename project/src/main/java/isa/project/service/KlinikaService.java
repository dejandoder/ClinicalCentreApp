package isa.project.service;

import isa.project.repository.KlinikaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlinikaService {
	
	@Autowired
	private KlinikaRepository klinikaRepository;

}
