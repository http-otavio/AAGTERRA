package com.aagterra.transportes.controller;

import jakarta.validation.Valid;
import com.aagterra.transportes.model.transporte.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aagterra.transportes.service.ViagemService;

import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagemController {
    private final ViagemService viagemService;

    @Autowired
    public ViagemController(ViagemService viagemService) {
        this.viagemService = viagemService;
    }

    @GetMapping
    public List<Viagem> getViagens() {
        return viagemService.getViagens();
    }

    @PostMapping
    public Viagem adicionarViagem(@Valid @RequestBody Viagem viagem) {
        return viagemService.adicionarViagem(viagem);
    }


    // Atualizar Viagem
    @PutMapping("/{id}")
    public Viagem atualizarViagem(@Valid @PathVariable Long id, @Valid @RequestBody Viagem viagem) {
        return viagemService.atualizarViagem(id, viagem);
    }

    // Deletar Viagem
    @DeleteMapping("/{id}")
    public void deletarViagem(@Valid @PathVariable Long id) {
        viagemService.deletarViagem(id);
    }

}
