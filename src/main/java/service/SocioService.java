package service;

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

    // outros métodos conforme necessário
}
