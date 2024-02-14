package service;

import com.aagterra.transportes.TransportesApplication;
import model.tms.transporte.Cliente;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import repository.ClienteRepository;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = TransportesApplication.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Test
    public void testGetClientes() {
        clienteService.getClientes();
        verify(clienteRepository, times(1)).findAll();
    }

//    @Test
//    public void testAdicionarCliente() {
//        Cliente cliente = new Cliente();
//        clienteService.adicionarCliente(cliente);
//        verify(clienteRepository, times(1)).save(cliente);
//    }

    // outros testes conforme necessário
}
