package com.aagterra.transportes.service;

import com.aagterra.transportes.model.transporte.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aagterra.transportes.repository.ClienteRepository;


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

    
    public Cliente adicionarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    
    public Cliente alterarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}