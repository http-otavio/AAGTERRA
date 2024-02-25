package controller;

import jakarta.validation.Valid;
import model.tms.faturamento.Faturamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.FaturamentoService;

import java.util.List;

@RestController
@RequestMapping("/faturamentos")
public class FaturamentoController {
    private final FaturamentoService faturamentoService;

    @Autowired
    public FaturamentoController(FaturamentoService faturamentoService) {
        this.faturamentoService = faturamentoService;
    }

    @GetMapping
    public List<Faturamento> getFaturamentos() {
        return faturamentoService.getFaturamentos();
    }

    @PostMapping
    public Faturamento adicionarFaturamento(@Valid @RequestBody Faturamento faturamento) {
        return faturamentoService.adicionarFaturamento(faturamento);
    }


    // Atualizar Faturamento
    @PutMapping("/{id}")
    public Faturamento atualizarFaturamento(@Valid @PathVariable Long id, @RequestBody Faturamento faturamento) {
        return faturamentoService.atualizarFaturamento(id, faturamento);
    }

    // Deletar Faturamento
    @DeleteMapping("/{id}")
    public void deletarFaturamento(@Valid @PathVariable Long id) {
        faturamentoService.deletarFaturamento(id);
    }

}
