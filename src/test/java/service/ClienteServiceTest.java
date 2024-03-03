package service;

import com.aagterra.transportes.model.transporte.Cliente;
import com.aagterra.transportes.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.aagterra.transportes.repository.ClienteRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    ClienteService clienteService;

    @Mock
    ClienteRepository clienteRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getClientesTest() {
        Cliente cliente = new Cliente();
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));

        List<Cliente> result = clienteService.getClientes();
        assertEquals(1, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void adicionarClienteTest() {
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.adicionarCliente(cliente);
        assertEquals(cliente, result);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void deletarClienteTest() {
        Long id = 1L;
        doNothing().when(clienteRepository).deleteById(id);

        clienteService.deletarCliente(id);
        verify(clienteRepository, times(1)).deleteById(id);
    }

    @Test
    public void alterarClienteTest() {
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.alterarCliente(cliente);
        assertEquals(cliente, result);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testGetClientes() {
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        List<Cliente> expectedClientes = Arrays.asList(cliente1, cliente2);

        when(clienteRepository.findAll()).thenReturn(expectedClientes);

        List<Cliente> actualClientes = clienteService.getClientes();

        assertEquals(expectedClientes, actualClientes);
    }
}