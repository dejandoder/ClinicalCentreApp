package isa.project.service;

import java.util.ArrayList;
import java.util.List;

import isa.project.dto.KlinikaDTO;
import isa.project.dto.PretragaKlinikaDTO;
import isa.project.model.Klinika;
import isa.project.model.Pregled;
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

	public PretragaKlinikaDTO pretragaKlinika(PretragaKlinikaDTO pom) {

		List<Klinika> lista = new ArrayList<>();
		List<KlinikaDTO> listaDTO = new ArrayList<>();
		PretragaKlinikaDTO konacno = new PretragaKlinikaDTO();
		int cijena = 0;

		List<Pregled> pregledi = pregledRepository.getPregledPoTipu(pom
				.getTipPregleda());

		for (Pregled p : pregledi) {
			cijena = p.getCijena();
			Klinika temp = p.getLjekar().getKlinika();
			if (!lista.contains(temp)) {
				lista.add(temp);

			}

			for (KlinikaDTO k : listaDTO) {
				k.setIme(temp.getIme());
				k.setOpis(temp.getOpis());
				k.setAdresa(temp.getAdresa());
				k.setCijenaPregleda(p.getCijena());
				k.setGrad(temp.getGrad());
				k.setOcjena(temp.getOcjena());
				k.setLjekari(temp.getLjekari());
				listaDTO.add(k);

			}

		}

		konacno.setKlinike(lista);
		konacno.setCijenaPregleda(cijena);
		konacno.setKlinikeDTO(listaDTO);

		return konacno;
	}

}
