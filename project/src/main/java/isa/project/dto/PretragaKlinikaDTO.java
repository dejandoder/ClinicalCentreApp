package isa.project.dto;

import java.util.Date;

public class PretragaKlinikaDTO {
	
	private String tipPregleda;
	
	private Date datumPregleda;
	
	private String lokacijaKlinike;
	
	private int ocjenaKlinike;
	
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
	

}
