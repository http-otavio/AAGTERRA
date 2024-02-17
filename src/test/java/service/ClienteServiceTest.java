package service;

import model.tms.transporte.Cliente;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.dao.EmptyResultDataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.ClienteRepository;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceTest.class);

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Test
    public void testGetClientes() {
        logger.info("Iniciando teste: testGetClientes");
        Cliente cliente = new Cliente();
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));

        List<Cliente> result = clienteService.getClientes();

        assertEquals(1, result.size());
        verify(clienteRepository, times(1)).findAll();
        logger.info("Teste concluído: testGetClientes");
    }

    @SuppressWarnings("null")
    @Test
    public void testAdicionarCliente() {
        logger.info("Iniciando teste: testAdicionarCliente");
        Cliente cliente = new Cliente();
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente result = clienteService.adicionarCliente(cliente);

        assertNotNull(result);
        verify(clienteRepository, times(1)).save(cliente);
        logger.info("Teste concluído: testAdicionarCliente");
    }

    @Test
    public void testDeletarCliente() {
        logger.info("Iniciando teste: testDeletarCliente");
        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.deletarCliente(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
        logger.info("Teste concluído: testDeletarCliente");
    }

    @Test
    public void testDeletarClienteComErro() {
        logger.info("Iniciando teste: testDeletarClienteComErro");
        doThrow(EmptyResultDataAccessException.class).when(clienteRepository).deleteById(1L);

        assertThrows(EmptyResultDataAccessException.class, () -> {
            clienteService.deletarCliente(1L);
        });

        verify(clienteRepository, times(1)).deleteById(1L);
        logger.info("Teste concluído: testDeletarClienteComErro");
    }

    @SuppressWarnings("null")
    @Test
    public void testAlterarCliente() {
        logger.info("Iniciando teste: testAlterarCliente");
        Cliente cliente = new Cliente();
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente result = clienteService.alterarCliente(cliente);

        assertNotNull(result);
        verify(clienteRepository, times(1)).save(cliente);
        logger.info("Teste concluído: testAlterarCliente");
    }
}
