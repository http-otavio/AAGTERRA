package service;

import model.tms.despesas.Motorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MotoristaRepository;

import java.util.List;

@Service
public class MotoristaService {
    private final MotoristaRepository motoristaRepository;

    @Autowired
    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public List<Motorista> getMotoristas() {
        return motoristaRepository.findAll();
    }

    // outros métodos conforme necessário
}
