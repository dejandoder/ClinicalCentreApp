package isa.project.service;

import java.util.List;

import isa.project.model.Klinika;
import isa.project.repository.KlinikaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlinikaService {
	
	@Autowired
	private KlinikaRepository klinikaRepository;
	
	public List<Klinika> findAll() {
		return klinikaRepository.findAll();
	}

}
