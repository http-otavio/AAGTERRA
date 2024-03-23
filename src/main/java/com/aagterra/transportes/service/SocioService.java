package com.aagterra.transportes.service;

import com.aagterra.transportes.exception.ResourceNotFoundException;
import com.aagterra.transportes.model.socios.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aagterra.transportes.repository.SocioRepository;

import java.util.List;

@Service
public class SocioService {
    private final SocioRepository socioRepository;

    @Autowired
    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public List<Socio> getSocios() {
        return socioRepository.findAll();
    }

    @SuppressWarnings("null")
    public Socio adicionarSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    @SuppressWarnings("null")
    public Socio atualizarSocio(Long id, Socio socio) {
        Socio socioExistente = socioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Socio", "id", id));

        // Atualize os campos necessários do socioExistente com os do socio

        return socioRepository.save(socioExistente);
    }

    @SuppressWarnings("null")
    public void deletarSocio(Long id) {
        if (!socioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Socio", "id", id);
        }

        socioRepository.deleteById(id);
    }

}
