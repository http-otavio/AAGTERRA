package com.aagterra.transportes.service;

import com.aagterra.transportes.exception.ResourceNotFoundException;
import com.aagterra.transportes.model.transporte.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aagterra.transportes.repository.ViagemRepository;

import java.util.List;

@Service
public class ViagemService {
    private final ViagemRepository viagemRepository;

    @Autowired
    public ViagemService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    public List<Viagem> getViagens() {
        return viagemRepository.findAll();
    }

    public Viagem adicionarViagem(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    public Viagem atualizarViagem(Long id, Viagem viagem) {
        Viagem viagemExistente = viagemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Viagem", "id", id));

        // Atualize os campos necessários do viagemExistente com os do viagem

        return viagemRepository.save(viagemExistente);
    }

    public void deletarViagem(Long id) {
        if (!viagemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Viagem", "id", id);
        }

        viagemRepository.deleteById(id);
    }

}
