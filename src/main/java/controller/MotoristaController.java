package controller;

import jakarta.validation.Valid;
import model.tms.despesas.Motorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MotoristaService;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {
    private final MotoristaService motoristaService;

    @Autowired
    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @GetMapping
    public List<Motorista> getMotoristas() {
        return motoristaService.getMotoristas();
    }

    @PostMapping
    public Motorista adicionarMotorista(@Valid @RequestBody Motorista motorista) {
        return motoristaService.adicionarMotorista(motorista);
    }


    // Atualizar Motorista
    @PutMapping("/{id}")
    public Motorista atualizarMotorista(@Valid @PathVariable Long id, @Valid @RequestBody Motorista motorista) {
        return motoristaService.atualizarMotorista(id, motorista);
    }

    // Deletar Motorista
    @DeleteMapping("/{id}")
    public void deletarMotorista(@Valid @PathVariable Long id) {
        motoristaService.deletarMotorista(id);
    }

}
