package isa.project.repository;

import java.util.List;
import isa.project.model.Ljekar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LjekarRepository extends JpaRepository<Ljekar, Long> {
	
	//@Query("select pregled from Pregled pregled where pregled.stanje = isa.project.model.StanjePregleda.ZAKAZAN ")
	//List<Ljekar> getljekariPoTipu();

}
