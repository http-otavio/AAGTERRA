package service;

import com.aagterra.transportes.TransportesApplication;
import model.tms.transporte.Transporte;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import repository.TransporteRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = TransportesApplication.class) // Substitua SuaClassePrincipal pela sua classe principal
public class TransporteServiceTest {

    @InjectMocks
    private TransporteService transporteService;

    @Mock
    private TransporteRepository transporteRepository;

    @Test
    public void testGetTransportes() {
        transporteService.getTransportes();
        verify(transporteRepository, times(1)).findAll();
    }

    @SuppressWarnings("null")
    @Test
    public void testAdicionarTransporte() {
        Transporte transporte = new Transporte();
        when(transporteRepository.save(any(Transporte.class))).thenReturn(transporte);
        Transporte created = transporteService.adicionarTransporte(transporte);
        assertNotNull(created);
        verify(transporteRepository, times(1)).save(transporte);
    }

    // outros testes conforme necessário
}
