package service;

import model.tms.transporte.Transporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TransporteRepository;

import java.util.List;

@Service
public class TransporteService {
    private final TransporteRepository transporteRepository;

    @Autowired
    public TransporteService(TransporteRepository transporteRepository) {
        this.transporteRepository = transporteRepository;
    }

    public List<Transporte> getTransportes() {
        return transporteRepository.findAll();
    }

    public Transporte adicionarTransporte(Transporte transporte) {
        return transporteRepository.save(transporte);
    }

    public void deletarTransporte(Long id) {
        transporteRepository.deleteById(id);
    }

    public Transporte alterarTransporte(Transporte transporte) {
        return transporteRepository.save(transporte);
    }
}