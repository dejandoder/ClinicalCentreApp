package isa.project.dto;

import isa.project.model.Klinika;


import isa.project.model.Ljekar;
import isa.project.model.Pregled;

import java.util.Date;
import java.util.List;

public class PretragaKlinikaDTO {
	
	private String tipPregleda;
	
	private Date datumPregleda;
	
	private String lokacijaKlinike;
	
	private int ocjenaKlinike;
	
	private List<Klinika> klinike;
	
	private List<KlinikaDTO> klinikeDTO;
	
	private Pregled pregled;
	
	private List<Ljekar> ljekari;
	
	private int cijenaPregleda;
	
	public PretragaKlinikaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(String tipPregleda) {
		this.tipPregleda = tipPregleda;
	}

	public Date getDatumPregleda() {
		return datumPregleda;
	}

	public void setDatumPregleda(Date datumPregleda) {
		this.datumPregleda = datumPregleda;
	}

	public String getLokacijaKlinike() {
		return lokacijaKlinike;
	}

	public void setLokacijaKlinike(String lokacijaKlinike) {
		this.lokacijaKlinike = lokacijaKlinike;
	}

	public int getOcjenaKlinike() {
		return ocjenaKlinike;
	}

	public void setOcjenaKlinike(int ocjenaKlinike) {
		this.ocjenaKlinike = ocjenaKlinike;
	}

	public List<Klinika> getKlinike() {
		return klinike;
	}

	public void setKlinike(List<Klinika> klinike) {
		this.klinike = klinike;
	}

	public int getCijenaPregleda() {
		return cijenaPregleda;
	}

	public void setCijenaPregleda(int cijenaPregleda) {
		this.cijenaPregleda = cijenaPregleda;
	}

	public Pregled getPregled() {
		return pregled;
	}

	public void setPregled(Pregled pregled) {
		this.pregled = pregled;
	}

	public List<Ljekar> getLjekari() {
		return ljekari;
	}

	public void setLjekari(List<Ljekar> ljekari) {
		this.ljekari = ljekari;
	}

	public List<KlinikaDTO> getKlinikeDTO() {
		return klinikeDTO;
	}

	public void setKlinikeDTO(List<KlinikaDTO> klinikeDTO) {
		this.klinikeDTO = klinikeDTO;
	}
	
	
	

}
