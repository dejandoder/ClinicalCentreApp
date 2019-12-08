package isa.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pregled {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//ostaje veza sa ljekarom
	//@Column(name="termin")
	//private Date termin;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date termin;
	
	@Column(name="sala")
	private int sala;
	
	@Column(name="cijena")
	private int cijena;
	
	@Column(name="popust")
	private int popust;
	
	@Column(name="tip")
	private String tip;
	
	@Column(name="opis")
	private String opis;
	
	@Column(name="trajanje")
	private String trajanje;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Ljekar ljekar;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Klinika klinika;
	
	public Pregled() {
		// TODO Auto-generated constructor stub
	}

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

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public int getCijena() {
		return cijena;
	}

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}

	public Ljekar getLjekar() {
		return ljekar;
	}

	public void setLjekar(Ljekar ljekar) {
		this.ljekar = ljekar;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	
	
	
	
	
	
	

}
