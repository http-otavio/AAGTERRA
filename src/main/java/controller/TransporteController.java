package controller;

import model.tms.transporte.Transporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public Transporte adicionarTransporte(@RequestBody Transporte transporte) {
        return transporteService.adicionarTransporte(transporte);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTransporte(@PathVariable Long id) {
        try {
            transporteService.deletarTransporte(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Transporte> alterarTransporte(@RequestBody Transporte transporte) {
        try {
            Transporte transporteAtualizado = transporteService.alterarTransporte(transporte);
            return ResponseEntity.ok(transporteAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
