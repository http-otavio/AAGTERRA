package service;

import exception.ResourceNotFoundException;
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

    public Lucro adicionarLucro(Lucro lucro) {
        return lucroRepository.save(lucro);
    }

    public Lucro atualizarLucro(Long id, Lucro lucro) {
        Lucro lucroExistente = lucroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lucro", "id", id));

        // Atualize os campos necessários do lucroExistente com os do lucro

        return lucroRepository.save(lucroExistente);
    }

    public void deletarLucro(Long id) {
        if (!lucroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lucro", "id", id);
        }

        lucroRepository.deleteById(id);
    }

}
