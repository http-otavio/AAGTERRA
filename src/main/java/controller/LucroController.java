package controller;

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

    // outros métodos conforme necessário
}
