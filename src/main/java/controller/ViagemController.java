package controller;

import model.tms.transporte.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ViagemService;

import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagemController {
    private final ViagemService viagemService;

    @Autowired
    public ViagemController(ViagemService viagemService) {
        this.viagemService = viagemService;
    }

    @GetMapping
    public List<Viagem> getViagens() {
        return viagemService.getViagens();
    }

    // outros métodos conforme necessário
}
