package isa.project.service;

import java.util.ArrayList;
import java.util.List;

import isa.project.dto.PretragaLjekaraDTO;
import isa.project.model.Ljekar;
import isa.project.repository.LjekarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LjekarService {

	@Autowired
	private LjekarRepository ljekarRepository;

	public List<Ljekar> pretragaLjekara(PretragaLjekaraDTO pom) {
		ArrayList<Ljekar> lista = new ArrayList<>();
		lista.addAll(pom.getLjekari());

		if (pom.getIme() != "") {
			lista.removeIf(n -> (!n.getIme().equalsIgnoreCase(pom.getIme())));
		}

		if (pom.getPrezime() != "") {
			lista.removeIf(n -> (!n.getPrezime().equalsIgnoreCase(
					pom.getPrezime())));
		}

		if (pom.getOcjena() != 0) {
			lista.removeIf(n -> (n.getOcjena() > pom.getOcjena()));
		}

		return lista;
	}
	
	public Ljekar findLjekarById(Long id){
		return ljekarRepository.findOneById(id);
	}
	
	public double konacanRezultat(double rezultat){
		rezultat=round(rezultat,2);
		return rezultat;
	}
	
	public Ljekar saveLjekar(Ljekar ljekar){
		return ljekarRepository.save(ljekar);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
