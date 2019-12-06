package isa.project.service;

import isa.project.model.Korisnik;
import isa.project.repository.KorisnikRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	public Korisnik saveUser(Korisnik user) {
		return korisnikRepository.save(user);
	}

}
