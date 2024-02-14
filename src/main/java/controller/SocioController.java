package controller;

import model.tms.socios.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.SocioService;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {
    private final SocioService socioService;

    @Autowired
    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping
    public List<Socio> getSocios() {
        return socioService.getSocios();
    }

    // outros métodos conforme necessário
}
