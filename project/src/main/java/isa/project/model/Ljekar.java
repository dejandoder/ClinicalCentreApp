package isa.project.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Ljekar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="prezime")
	private String prezime;
	
	@Column(name="ocjena")
	private String ocjena;
	
	@OneToMany(mappedBy="ljekar", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Pregled> pregledi = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "klinika_id")
	private Klinika klinika;
	
	@ManyToMany
	@JoinTable(name = "ljekar_tip_pregleda", joinColumns = @JoinColumn(name = "ljekar_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tip_pregleda_id", referencedColumnName = "id"))
	private Set<TipPregleda> tipovi = new HashSet<TipPregleda>();
	
	public Ljekar() {
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

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getOcjena() {
		return ocjena;
	}

	public void setOcjena(String ocjena) {
		this.ocjena = ocjena;
	}

	public List<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(List<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public Set<TipPregleda> getTipovi() {
		return tipovi;
	}

	public void setTipovi(Set<TipPregleda> tipovi) {
		this.tipovi = tipovi;
	}
	
	
	
	


}
