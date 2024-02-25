package controller;

import jakarta.validation.Valid;
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

    @PostMapping
    public Despesa adicionarDespesa(@Valid @RequestBody Despesa despesa) {
        return despesaService.adicionarDespesa(despesa);
    }


    // Atualizar Despesa
    @PutMapping("/{id}")
    public Despesa atualizarDespesa(@Valid @PathVariable Long id, @RequestBody Despesa despesa) {
        return despesaService.atualizarDespesa(id, despesa);
    }

    // Deletar Despesa
    @DeleteMapping("/{id}")
    public void deletarDespesa(@Valid @PathVariable Long id) {
        despesaService.deletarDespesa(id);
    }

}
