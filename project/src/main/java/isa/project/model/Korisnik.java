package isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Korisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="prezime")
	private String prezime;
	
	@Column(name="email")
	private String email;
	
	@Column(name="adresa")
	private String adresa;
	
	@Column(name="grad")
	private String grad;
	
	@Column(name="drzava")
	private String drzava;
	
	@Column(name="broj_telefona")
	private int brojTelefona;
	
	@Column(name="jedinstveni_broj")
	private int jedinstveniBroj;
	
	@Column(name="lozinka")
	private String password;
    
	public Korisnik() {
		// TODO Auto-generated constructor stub
	}
	

	public Korisnik(Long id, String ime, String prezime, String email,
			String adresa, String drzava, int brojTelefona,
			int jedinstveniBroj, String password) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.drzava = drzava;
		this.brojTelefona = brojTelefona;
		this.jedinstveniBroj = jedinstveniBroj;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public int getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(int brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public int getJedinstveniBroj() {
		return jedinstveniBroj;
	}

	public void setJedinstveniBroj(int jedinstveniBroj) {
		this.jedinstveniBroj = jedinstveniBroj;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getGrad() {
		return grad;
	}


	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	
	
	
}
