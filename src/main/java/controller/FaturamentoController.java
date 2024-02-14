package controller;

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

    // outros métodos conforme necessário
}
