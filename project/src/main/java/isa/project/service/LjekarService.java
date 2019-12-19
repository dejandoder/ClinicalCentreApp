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

		/*
		 * if (pom.getPolazisna() != null) lista.removeIf(n ->
		 * (!n.getPolaznaDestinacija().getLokacija()
		 * .contains(pom.getPolazisna()))); if (pom.getOdredisna() != null)
		 * lista.removeIf(n -> (!n.getDolaznaDestinacija().getLokacija()
		 * .contains(pom.getOdredisna()))); if (pom.getCijena() != 0)
		 * lista.removeIf(n -> (n.getCijenaKarte() > pom.getCijena())); if
		 * (pom.getDatumPocetak() != null) lista.removeIf(n ->
		 * (n.getPolijetanje().compareTo( pom.getDatumPocetak()) != 0)); if
		 * (pom.getDatumKraj() != null) lista.removeIf(n -> (n.getSlijetanje()
		 * .compareTo(pom.getDatumKraj()) != 0));
		 */
		return lista;
	}

}
