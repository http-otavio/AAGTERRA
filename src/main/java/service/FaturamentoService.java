package service;

import exception.ResourceNotFoundException;
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

    public Faturamento adicionarFaturamento(Faturamento faturamento) {
        return faturamentoRepository.save(faturamento);
    }

    public Faturamento atualizarFaturamento(Long id, Faturamento faturamento) {
        Faturamento faturamentoExistente = faturamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faturamento", "id", id));

        // Atualize os campos necessários do faturamentoExistente com os do faturamento

        return faturamentoRepository.save(faturamentoExistente);
    }

    public void deletarFaturamento(Long id) {
        if (!faturamentoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Faturamento", "id", id);
        }

        faturamentoRepository.deleteById(id);
    }

}
