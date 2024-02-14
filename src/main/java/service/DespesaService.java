package service;

import model.tms.despesas.Despesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DespesaRepository;

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

    // outros métodos conforme necessário
}
