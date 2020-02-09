package isa.project.service;

import java.util.ArrayList;
import java.util.List;

import isa.project.dto.KlinikaDTO;
import isa.project.dto.PretragaKlinikaDTO;
import isa.project.model.Klinika;
import isa.project.model.Pregled;
import isa.project.model.TipPregleda;
import isa.project.repository.KlinikaRepository;
import isa.project.repository.PregledRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KlinikaService {

	@Autowired
	private KlinikaRepository klinikaRepository;

	@Autowired
	private PregledRepository pregledRepository;

	public List<Klinika> findAll() {
		return klinikaRepository.findAll();
	}
	
	public Klinika findKlinikaById(Long id) {
		return klinikaRepository.findOneById(id);
	}
	
	public Klinika saveKlinika(Klinika klinika) {
		return klinikaRepository.save(klinika);
	}
	
	public double konacanRezultat(double rezultat){
		rezultat=round(rezultat,2);
		return rezultat;
	}

	public PretragaKlinikaDTO pretragaKlinika(PretragaKlinikaDTO pom) {

		List<Klinika> lista = new ArrayList<>();
		//List<KlinikaDTO> listaDTO = new ArrayList<>();
		PretragaKlinikaDTO konacno = new PretragaKlinikaDTO();
		double cijena = 0;

		List<Pregled> pregledi = pregledRepository.getPregledPoTipu(pom
				.getTipPregleda());

		for (Pregled p : pregledi) {
			cijena = p.getTipPregleda().getCijena();
			Klinika temp = p.getLjekar().getKlinika();
			if (!lista.contains(temp)) {
				lista.add(temp);
			}

		}

		if (pom.getOcjenaKlinike() != 0) {
			lista.removeIf(n -> (n.getOcjena() > pom.getOcjenaKlinike()));
		}

		if (pom.getLokacijaKlinike() != "") {
			lista.removeIf(n -> (!n.getGrad().equalsIgnoreCase(
					pom.getLokacijaKlinike())));
		}

		konacno.setKlinike(lista);
		konacno.setCijenaPregleda(cijena);
		//konacno.setKlinikeDTO(listaDTO);

		return konacno;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}


}
