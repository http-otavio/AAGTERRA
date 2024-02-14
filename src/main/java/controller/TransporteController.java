package controller;

import model.tms.transporte.Transporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TransporteService;

import java.util.List;

@RestController
@RequestMapping("/transportes")
public class TransporteController {
    private final TransporteService transporteService;

    @Autowired
    public TransporteController(TransporteService transporteService) {
        this.transporteService = transporteService;
    }

    @GetMapping
    public List<Transporte> getTransportes() {
        return transporteService.getTransportes();
    }

    // outros métodos conforme necessário
}
