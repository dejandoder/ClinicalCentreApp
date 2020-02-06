package isa.project.repository;

import java.util.List;

import isa.project.model.Ljekar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LjekarRepository extends JpaRepository<Ljekar, Long> {
	
	Ljekar findOneById(Long id);
	
	List<Ljekar> findAll();
	
}
