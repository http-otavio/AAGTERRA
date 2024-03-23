package com.aagterra.transportes.controller;

import jakarta.validation.Valid;
import com.aagterra.transportes.model.transporte.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aagterra.transportes.service.ClienteService;

import java.util.List;

@RestController


@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping
    public Cliente adicionarCliente(@Valid @RequestBody Cliente cliente) {
        return clienteService.adicionarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

    @PutMapping
    public Cliente alterarCliente(@RequestBody Cliente cliente) {
        return clienteService.alterarCliente(cliente);
    }
}