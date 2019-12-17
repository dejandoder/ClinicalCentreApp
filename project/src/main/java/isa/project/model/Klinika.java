package isa.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Klinika {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="adresa")
	private String adresa;
	
	@Column(name="opis")
	private String opis;
	
	@Column(name="grad")
	private String grad;
	
	//@OneToMany(mappedBy="klinika", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToMany
	@JoinTable(name = "klinikaLjekari")
	private List<Ljekar> ljekari = new ArrayList<>();
	
	
	//@OneToMany(mappedBy="klinika", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToMany
	@JoinTable(name = "klinikaPregledi")
	private List<Pregled> pregledi = new ArrayList<>();
	
	public Klinika() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Ljekar> getLjekari() {
		return ljekari;
	}

	public void setLjekari(List<Ljekar> ljekari) {
		this.ljekari = ljekari;
	}

	public List<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(List<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	
	
	

}
