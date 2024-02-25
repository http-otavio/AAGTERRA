package controller;

import jakarta.validation.Valid;
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

    @PostMapping
    public Socio adicionarSocio(@Valid @RequestBody Socio socio) {
        return socioService.adicionarSocio(socio);
    }


    // Atualizar Socio
    @PutMapping("/{id}")
    public Socio atualizarSocio(@Valid  @PathVariable Long id,@Valid  @RequestBody Socio socio) {
        return socioService.atualizarSocio(id, socio);
    }

    // Deletar Socio
    @DeleteMapping("/{id}")
    public void deletarSocio(@Valid @PathVariable Long id) {
        socioService.deletarSocio(id);
    }

}
