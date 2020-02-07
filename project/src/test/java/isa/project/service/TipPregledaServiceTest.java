package isa.project.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import isa.project.model.TipPregleda;
import isa.project.repository.TipPregledaRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipPregledaServiceTest {
	
	@Mock
	private TipPregledaRepository tipPregledaRepositoryMock;
	
	@Mock
	private TipPregleda tipPregledaMock;
	
	@InjectMocks
	private TipPregledaService tipPregledaService;
	
	@Test
	public void testFindAll() {
	
		when(tipPregledaRepositoryMock.findAll()).thenReturn(Arrays.asList(new TipPregleda()));
		List<TipPregleda> tip = tipPregledaService.sviTipoviPregleda();
		assertThat(tip).hasSize(1);
		
		verify(tipPregledaRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(tipPregledaRepositoryMock);
        
	}

}
