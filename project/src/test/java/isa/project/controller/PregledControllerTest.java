package isa.project.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import isa.project.model.Korisnik;
import isa.project.model.Role;
import isa.project.service.KorisnikService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PregledControllerTest {
	
private static final String URL_PREFIX = "/pregledi";
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());
	
	private MockMvc mockMvc;
	
	@Mock
	private KorisnikService korisnikService;
	
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
	public void testgetAllPregled() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/allPregled" )).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.[*].id").value(hasItem(28)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(29)));
	}
	
	@Test
	public void testgetAllPregledZakazani() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/sviDostupni" )).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.[*].id").value(hasItem(28)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(29)));
	}
	
	/*@Test
	public void testgetZakazani() throws Exception {
		
		Korisnik k = new Korisnik();
		k.setId((long) 100);
		k.setIme("Dejan");
		k.setPrezime("Doder");
		k.setAdresa("Njegoseva");
		k.setBrojTelefona(065);
		k.setDrzava("SRBIJA");
		k.setEmail("dejandoder96666@gmail.com");
		k.setGrad("Gacko");
		k.setJedinstveniBroj(2806);
		k.setPassword("123");
		k.setRole(Role.REGISTROVAN);
		k.setUsername("doda");
		k.setVerifikovan(true);
		
		when(korisnikService.getCurrentUser()).thenReturn(k);
		
		mockMvc.perform(get(URL_PREFIX + "/zakazani" )).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.[*].id").value(hasItem(30)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(31)));
	}*/


}
