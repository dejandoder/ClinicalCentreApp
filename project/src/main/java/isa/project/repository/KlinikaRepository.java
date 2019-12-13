package isa.project.repository;

import java.util.List;

import isa.project.model.Klinika;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KlinikaRepository extends JpaRepository<Klinika, Long> {
	
	List<Klinika> findAll();

}
