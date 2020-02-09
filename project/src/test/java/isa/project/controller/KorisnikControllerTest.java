package isa.project.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import isa.project.model.Korisnik;
import isa.project.model.Role;
import isa.project.utils.TestUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class KorisnikControllerTest {
	
private static final String URL_PREFIX = "/korisnici";
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void registruj() throws Exception {
		
		Korisnik k = new Korisnik();
		k.setId((long) 8);
		k.setIme("Dejan");
		k.setAdresa("Njegoseva");
		k.setBrojTelefona(065);
		k.setDrzava("SRBIJA");
		k.setEmail("dejandoder96@gmail.com");
		k.setGrad("Gacko");
		k.setJedinstveniBroj(2806);
		k.setPassword("123");
		k.setRole(Role.REGISTROVAN);
		k.setUsername("doda");
		k.setVerifikovan(true);
		
		
		String json = TestUtil.json(k);

		mockMvc.perform(post(URL_PREFIX + "/registracija" ).contentType(contentType).content(json)).andExpect(status().isOk());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void izmijeni() throws Exception {
		
		Korisnik k = new Korisnik();
		k.setId((long) 8);
		k.setIme("Dejan");
		k.setAdresa("Njegoseva");
		k.setBrojTelefona(065);
		k.setDrzava("SRBIJA");
		k.setEmail("clio2806@gmail.com");
		k.setGrad("Gacko");
		k.setJedinstveniBroj(2806);
		k.setPassword("123");
		k.setRole(Role.REGISTROVAN);
		k.setUsername("doda");
		k.setVerifikovan(true);
		
		
		String json = TestUtil.json(k);

		mockMvc.perform(post(URL_PREFIX + "/izmjena" ).contentType(contentType).content(json)).andExpect(status().isOk());
	}
	

}
