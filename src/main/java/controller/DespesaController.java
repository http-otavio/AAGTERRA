package controller;

import model.tms.despesas.Despesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DespesaService;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {
    private final DespesaService despesaService;

    @Autowired
    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @GetMapping
    public List<Despesa> getDespesas() {
        return despesaService.getDespesas();
    }

    // outros métodos conforme necessário
}
