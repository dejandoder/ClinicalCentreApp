package isa.project.repository;

import isa.project.model.Korisnik;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	public Korisnik findByUsername(String username);

}
