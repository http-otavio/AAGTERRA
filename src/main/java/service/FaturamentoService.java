package service;

import model.tms.faturamento.Faturamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FaturamentoRepository;

import java.util.List;

@Service
public class FaturamentoService {
    private final FaturamentoRepository faturamentoRepository;

    @Autowired
    public FaturamentoService(FaturamentoRepository faturamentoRepository) {
        this.faturamentoRepository = faturamentoRepository;
    }

    public List<Faturamento> getFaturamentos() {
        return faturamentoRepository.findAll();
    }

    // outros métodos conforme necessário
}
