package service;

import model.tms.transporte.Transporte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.TransporteRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TransporteServiceTest {

    @InjectMocks
    TransporteService transporteService;

    @Mock
    TransporteRepository transporteRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTransportesTest() {
        Transporte transporte = new Transporte();
        when(transporteRepository.findAll()).thenReturn(Arrays.asList(transporte));

        List<Transporte> result = transporteService.getTransportes();
        assertEquals(1, result.size());
        verify(transporteRepository, times(1)).findAll();
    }

    @Test
    public void adicionarTransporteTest() {
        Transporte transporte = new Transporte();
        when(transporteRepository.save(transporte)).thenReturn(transporte);

        Transporte result = transporteService.adicionarTransporte(transporte);
        assertEquals(transporte, result);
        verify(transporteRepository, times(1)).save(transporte);
    }

    @Test
    public void deletarTransporteTest() {
        Long id = 1L;
        doNothing().when(transporteRepository).deleteById(id);

        transporteService.deletarTransporte(id);
        verify(transporteRepository, times(1)).deleteById(id);
    }

    @Test
    public void alterarTransporteTest() {
        Transporte transporte = new Transporte();
        when(transporteRepository.save(transporte)).thenReturn(transporte);

        Transporte result = transporteService.alterarTransporte(transporte);
        assertEquals(transporte, result);
        verify(transporteRepository, times(1)).save(transporte);
    }
}