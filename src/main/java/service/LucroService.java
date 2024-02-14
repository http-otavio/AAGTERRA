package service;

import model.tms.socios.Lucro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LucroRepository;

import java.util.List;

@Service
public class LucroService {
    private final LucroRepository lucroRepository;

    @Autowired
    public LucroService(LucroRepository lucroRepository) {
        this.lucroRepository = lucroRepository;
    }

    public List<Lucro> getLucros() {
        return lucroRepository.findAll();
    }

    // outros métodos conforme necessário
}
