package service;

import exception.ResourceNotFoundException;
import model.tms.socios.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SocioRepository;

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

    public Socio adicionarSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    public Socio atualizarSocio(Long id, Socio socio) {
        Socio socioExistente = socioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Socio", "id", id));

        // Atualize os campos necessários do socioExistente com os do socio

        return socioRepository.save(socioExistente);
    }

    public void deletarSocio(Long id) {
        if (!socioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Socio", "id", id);
        }

        socioRepository.deleteById(id);
    }

}
