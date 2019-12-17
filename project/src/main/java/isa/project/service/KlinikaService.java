package isa.project.service;

import java.util.List;

import isa.project.dto.PretragaKlinikaDTO;
import isa.project.model.Klinika;
import isa.project.repository.KlinikaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KlinikaService {
	
	@Autowired
	private KlinikaRepository klinikaRepository;
	
	public List<Klinika> findAll() {
		return klinikaRepository.findAll();
	}
	
	public List<Klinika> pretragaKlinika(PretragaKlinikaDTO pom) {
		List<Klinika> lista = klinikaRepository.pronadjiPoTipuPregleda(pom.getTipPregleda());

		/*if (pom.getPolazisna() != null)
			lista.removeIf(n -> (!n.getPolaznaDestinacija().getLokacija()
					.contains(pom.getPolazisna())));
		if (pom.getOdredisna() != null)
			lista.removeIf(n -> (!n.getDolaznaDestinacija().getLokacija()
					.contains(pom.getOdredisna())));
		if (pom.getCijena() != 0)
			lista.removeIf(n -> (n.getCijenaKarte() > pom.getCijena()));
		if (pom.getDatumPocetak() != null)
			lista.removeIf(n -> (n.getPolijetanje().compareTo(
					pom.getDatumPocetak()) != 0));
		if (pom.getDatumKraj() != null)
			lista.removeIf(n -> (n.getSlijetanje()
					.compareTo(pom.getDatumKraj()) != 0));*/

		return lista;
	}

}
