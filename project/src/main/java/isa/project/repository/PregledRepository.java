package isa.project.repository;

import isa.project.model.Pregled;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PregledRepository extends JpaRepository<Pregled, Long> {
	
	Page<Pregled> findAll(Pageable pageable);

}
