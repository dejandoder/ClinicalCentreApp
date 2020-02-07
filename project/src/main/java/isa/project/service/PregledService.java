package isa.project.service;

import java.util.ArrayList;
import java.util.List;

import isa.project.model.Pregled;
import isa.project.repository.KorisnikRepository;
import isa.project.repository.PregledRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PregledService {

	@Autowired
	private PregledRepository pregledRepository;
	
	@Autowired
	private KorisnikRepository korisnikRepository;

	public List<Pregled> findAll() {
		return pregledRepository.findAll();
	}
	
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public Pregled savePregled(Pregled pregled) {
		return pregledRepository.save(pregled);
	}

	public List<Pregled> getPregledZakazani(Long id) {
		List<Pregled> pregledi = new ArrayList<Pregled>();
		pregledi.addAll(pregledRepository.getZakazaniPregledi());
		pregledi.removeIf(n -> (!n.getKorisnik().getId().equals(id)));
		return pregledi;
	}

	public List<Pregled> getIstorijaPregleda(Long id) {
		List<Pregled> pregledi = new ArrayList<Pregled>();
		pregledi.addAll(pregledRepository.getIstorijaPregleda());
		pregledi.removeIf(n -> (!n.getKorisnik().getId().equals(id)));
		return pregledi;
	}

	public List<Pregled> getDostupniPregledi() {
		return pregledRepository.getDostupniPregledi();
	}
	
	public List<Pregled> getPregledPoKorisniku(Long id){
		return pregledRepository.getPregledPoKorisniku(id);
	}

	public List<Pregled> getPreglediPoTipu(String tip) {
		return pregledRepository.getPregledPoTipu(tip);
	}

}
