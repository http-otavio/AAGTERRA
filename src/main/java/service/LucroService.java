package service;

import exception.ResourceNotFoundException;
import model.tms.socios.Lucro;
import model.tms.socios.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LucroRepository;
import repository.SocioRepository;

import java.util.List;

@Service
public class LucroService {
    private final LucroRepository lucroRepository;
    private final SocioRepository socioRepository;

    @Autowired
    public LucroService(LucroRepository lucroRepository, SocioRepository socioRepository) {
        this.lucroRepository = lucroRepository;
        this.socioRepository = socioRepository;
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

    public void distribuirLucro(double valorTotal) {
        List<Socio> socios = socioRepository.findAll();

        if (socios.size() != 2) {
            throw new IllegalArgumentException("O número de sócios deve ser exatamente 2");
        }

        // Definindo os percentuais de lucro para cada sócio
        socios.get(0).setPercentualDeLucro(50.0);
        socios.get(1).setPercentualDeLucro(50.0);

        // Distribuindo o lucro para cada sócio
        for (Socio socio : socios) {
            double valorDoLucro = valorTotal * (socio.getPercentualDeLucro() / 100.0);
            socio.setValorRecebido(valorDoLucro);
            socioRepository.save(socio);
        }
    }
}
