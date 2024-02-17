package service;

import model.tms.transporte.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @SuppressWarnings("null")
    public Cliente adicionarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @SuppressWarnings("null")
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    public Cliente alterarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}