package isa.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Termin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIME)
	private Date termin;
	
	@Column(name = "zauzet")
	private boolean zauzet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTermin() {
		return termin;
	}

	public void setTermin(Date termin) {
		this.termin = termin;
	}

	public boolean isZauzet() {
		return zauzet;
	}

	public void setZauzet(boolean zauzet) {
		this.zauzet = zauzet;
	}
	
	

}
