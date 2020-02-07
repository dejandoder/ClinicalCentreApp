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

import isa.project.dto.PretragaKlinikaDTO;
import isa.project.model.Klinika;
import isa.project.repository.KlinikaRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KlinikaServiceTest {
	
	@Mock
	private KlinikaRepository klinikaRepositoryMock;

	@Mock
	private Klinika klinikaMock;
	
	@InjectMocks
	private KlinikaService klinikaService;
	
	@Test
	public void testFindAll() {
	
		when(klinikaRepositoryMock.findAll()).thenReturn(Arrays.asList(new Klinika()));
		List<Klinika> klinika = klinikaService.findAll();
		assertThat(klinika).hasSize(1);
		
		verify(klinikaRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(klinikaRepositoryMock);
        
	}
	
	@Test
	public void testFindOne(){
		
		when(klinikaRepositoryMock.findOneById((long) 1)).thenReturn(klinikaMock);
		Klinika klinika = klinikaService.findKlinikaById((long) 1);
		assertEquals(klinikaMock, klinika);
		
        verify(klinikaRepositoryMock, times(1)).findOneById((long) 1);
        verifyNoMoreInteractions(klinikaRepositoryMock);
	}
	
	@Test
    @Transactional
	public void testSaveKlinika(){
		    
        when(klinikaRepositoryMock.save(klinikaMock)).thenReturn(klinikaMock);
             
        Klinika klinika = klinikaService.saveKlinika(klinikaMock);
                 
        assertThat(klinika, is(equalTo(klinikaMock)));
	}
	
	@Test
	public void testPretragaKlinika(){
		
		Klinika klinika = new Klinika();
		klinika.setIme("Vojna");
		klinika.setGrad("Herceg Novi");
		klinika.setAdresa("Drenovik");
		
		Klinika klinika1 = new Klinika();
		klinika.setIme("Drzavna");
		klinika.setGrad("Igalo");
		klinika.setAdresa("");
		
		when(klinikaRepositoryMock.findAll()).thenReturn(new java.util.ArrayList<>(Arrays.asList(klinika, klinika1)));
		PretragaKlinikaDTO pom = new PretragaKlinikaDTO();
		List<Klinika> lista = new ArrayList<Klinika>();
		lista.add(klinika);
		lista.add(klinika1);

		pom.setKlinike(lista);
		
		assertEquals(klinika, lista.get(0));

	}
	
}
