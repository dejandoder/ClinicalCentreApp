package isa.project.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import isa.project.model.Klinika;
import isa.project.model.Korisnik;
import isa.project.model.Pregled;
import isa.project.model.TipPregleda;
import isa.project.repository.PregledRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PregledServiceTest {
	
	@Mock
	private PregledRepository PregledRepositoryMock;
	
	@Mock
	private Pregled pregledMock;
	
	@InjectMocks
	private PregledService pregledService;
	
	@Test
	public void testFindAll() {
	
		when(PregledRepositoryMock.findAll()).thenReturn(Arrays.asList(new Pregled()));
		List<Pregled> tip = pregledService.findAll();
		assertThat(tip).hasSize(1);
		
		verify(PregledRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(PregledRepositoryMock);
        
	}
	
	@Test
    @Transactional
	public void testSaveKlinika(){
		    
        when(PregledRepositoryMock.save(pregledMock)).thenReturn(pregledMock);
             
        Pregled pregled = pregledService.savePregled(pregledMock);
                 
        assertThat(pregled, is(equalTo(pregledMock)));
	}
	
	@Test
	public void testIstorija() {
		
		Korisnik k = new Korisnik();
		k.setId((long) 28);
	
		when(PregledRepositoryMock.getZakazaniPregledi()).thenReturn(Arrays.asList(new Pregled()));
		List<Pregled> tip = pregledService.getIstorijaPregleda(k.getId());
		assertThat(tip);
		
		verify(PregledRepositoryMock, times(1)).getIstorijaPregleda();
        verifyNoMoreInteractions(PregledRepositoryMock);
        
	}
		

	@Test
	public void testDostupni() {
	
		when(PregledRepositoryMock.getDostupniPregledi()).thenReturn(Arrays.asList(new Pregled()));
		List<Pregled> tip = pregledService.getDostupniPregledi();
		assertThat(tip).hasSize(1);
		
		verify(PregledRepositoryMock, times(1)).getDostupniPregledi();
        verifyNoMoreInteractions(PregledRepositoryMock);
        
	}
	

}
