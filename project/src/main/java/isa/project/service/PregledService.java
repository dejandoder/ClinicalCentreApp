package isa.project.service;

import isa.project.repository.PregledRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PregledService {
	
	@Autowired
	private PregledRepository pregledRepository;

}
