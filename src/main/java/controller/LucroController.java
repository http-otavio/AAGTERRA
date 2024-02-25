package controller;

import jakarta.validation.Valid;
import model.tms.socios.Lucro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.LucroService;

import java.util.List;

@RestController
@RequestMapping("/lucros")
public class LucroController {
    private final LucroService lucroService;

    @Autowired
    public LucroController(LucroService lucroService) {
        this.lucroService = lucroService;
    }

    @GetMapping
    public List<Lucro> getLucros() {
        return lucroService.getLucros();
    }

    @PostMapping
    public Lucro adicionarLucro(@Valid @RequestBody Lucro lucro) {
        return lucroService.adicionarLucro(lucro);
    }


    // Atualizar Lucro
    @PutMapping("/{id}")
    public Lucro atualizarLucro(@Valid  @PathVariable Long id, @Valid @RequestBody Lucro lucro) {
        return lucroService.atualizarLucro(id, lucro);
    }

    // Deletar Lucro
    @DeleteMapping("/{id}")
    public void deletarLucro(@Valid @PathVariable Long id) {
        lucroService.deletarLucro(id);
    }

}
