package service;

import model.tms.transporte.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ViagemRepository;

import java.util.List;

@Service
public class ViagemService {
    private final ViagemRepository viagemRepository;

    @Autowired
    public ViagemService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    public List<Viagem> getViagens() {
        return viagemRepository.findAll();
    }

    // outros métodos conforme necessário
}
