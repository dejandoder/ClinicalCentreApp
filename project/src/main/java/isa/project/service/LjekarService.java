package isa.project.service;

import isa.project.repository.LjekarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LjekarService {
	
	@Autowired
	private LjekarRepository ljekarRepository;

}
