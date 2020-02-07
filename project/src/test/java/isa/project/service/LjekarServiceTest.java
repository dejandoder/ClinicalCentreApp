package isa.project.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import isa.project.dto.PretragaLjekaraDTO;
import isa.project.model.Ljekar;
import isa.project.repository.LjekarRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LjekarServiceTest {
	
	@Mock
	private LjekarRepository ljekarRepositoryMock;
	
	@Mock
	private Ljekar ljekarMock;
	
	@InjectMocks
	private LjekarService ljekarService;
	
	@Test
	public void testFindAll() {
	
		when(ljekarRepositoryMock.findAll()).thenReturn(Arrays.asList(new Ljekar()));
		List<Ljekar> ljekar = ljekarService.findAll();
		assertThat(ljekar).hasSize(1);
		
		verify(ljekarRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(ljekarRepositoryMock);
        
	}
	
	@Test
	public void testFindOne(){
		
		when(ljekarRepositoryMock.findOneById((long) 1)).thenReturn(ljekarMock);
		Ljekar ljekar = ljekarService.findLjekarById((long) 1);
		assertEquals(ljekarMock, ljekar);
		
        verify(ljekarRepositoryMock, times(1)).findOneById((long) 1);
        verifyNoMoreInteractions(ljekarRepositoryMock);
	}
	
	@Test
    @Transactional
	public void testSaveLjekar(){
		    
        when(ljekarRepositoryMock.save(ljekarMock)).thenReturn(ljekarMock);
             
        Ljekar ljekar = ljekarService.saveLjekar(ljekarMock);
           
        assertThat(ljekar, is(equalTo(ljekarMock)));
	}
	
	@Test
	public void pretraziLjekara(){
		
		Ljekar ljekar = new Ljekar();
		ljekar.setIme("Dejan");
		ljekar.setPrezime("");
		ljekar.setOcjena(5);
		
		Ljekar ljekar1 = new Ljekar();
		ljekar1.setIme("Todor");
		ljekar.setPrezime("");
		ljekar1.setOcjena(4);
		
		
		when(ljekarRepositoryMock.findAll()).thenReturn(new java.util.ArrayList<>(Arrays.asList(ljekar,ljekar1)));
		PretragaLjekaraDTO pom = new PretragaLjekaraDTO();
		pom.setIme("Dejan");
		pom.setOcjena(5);
		pom.setPrezime("");
		
		ArrayList<Ljekar> ljekari = new ArrayList<>();
		ljekari.add(ljekar);
		//ljekari.add(ljekar1);
		pom.setLjekari(ljekari);
		
		List<Ljekar> lista = ljekarService.pretragaLjekara(pom);
		
		List<Ljekar> rez= new ArrayList<>();
		rez.add(ljekar);
		
		assertEquals(lista,rez);
		
		verifyNoMoreInteractions(ljekarRepositoryMock);
				
	}
	
}
