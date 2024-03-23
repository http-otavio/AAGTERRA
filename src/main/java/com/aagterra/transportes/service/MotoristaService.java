package com.aagterra.transportes.service;

import com.aagterra.transportes.exception.ResourceNotFoundException;
import com.aagterra.transportes.model.despesas.Motorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aagterra.transportes.repository.MotoristaRepository;

import java.util.List;

@Service
public class MotoristaService {
    private final MotoristaRepository motoristaRepository;

    @Autowired
    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public List<Motorista> getMotoristas() {
        return motoristaRepository.findAll();
    }

    @SuppressWarnings("null")
    public Motorista adicionarMotorista(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    @SuppressWarnings("null")
    public Motorista atualizarMotorista(Long id, Motorista motorista) {
        Motorista motoristaExistente = motoristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorista", "id", id));

        // Atualize os campos necessários do motoristaExistente com os do motorista

        return motoristaRepository.save(motoristaExistente);
    }

    @SuppressWarnings("null")
    public void deletarMotorista(Long id) {
        if (!motoristaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Motorista", "id", id);
        }

        motoristaRepository.deleteById(id);
    }

}
