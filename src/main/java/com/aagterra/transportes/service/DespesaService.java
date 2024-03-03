package com.aagterra.transportes.service;

import com.aagterra.transportes.exception.ResourceNotFoundException;
import com.aagterra.transportes.model.despesas.Despesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aagterra.transportes.repository.DespesaRepository;

import java.util.List;

@Service
public class DespesaService {
    private final DespesaRepository despesaRepository;

    @Autowired
    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public List<Despesa> getDespesas() {
        return despesaRepository.findAll();
    }

    public Despesa adicionarDespesa(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public Despesa atualizarDespesa(Long id, Despesa despesa) {
        Despesa despesaExistente = despesaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Despesa", "id", id));

        // Atualize os campos necessários da despesaExistente com os da despesa

        return despesaRepository.save(despesaExistente);
    }

    public void deletarDespesa(Long id) {
        if (!despesaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Despesa", "id", id);
        }

        despesaRepository.deleteById(id);
    }

}
