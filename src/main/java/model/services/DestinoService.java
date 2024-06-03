package model.services;

import java.util.List;
import model.entities.Destino;
import model.repositories.DestinoRepository;

public class DestinoService {

    private DestinoRepository destinoRepository = new DestinoRepository();

    public void create(Destino destino) {
        destinoRepository.create(destino);
    }

    public List<Destino> findAll() {
        return destinoRepository.findAll();
    }

    public Destino findDestinoById(Long id) {
        return destinoRepository.findById(id);
    }

    public boolean deletarDestino(Long id) {
        Destino destino = destinoRepository.findById(id);
        if (destino != null) {
            destinoRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    public Destino updateDestino(Long id, String nomeDestino, String descricaoDestino, String fotoDestino, String pais, String regiao) {
        Destino destino = destinoRepository.findById(id);
        if (destino != null) {
            destino.setNomeDestino(nomeDestino);
            destino.setDescricaoDestino(descricaoDestino);
            destino.setFotoDestino(fotoDestino);
            destino.setPais(pais);
            destino.setRegiao(regiao);
            return destinoRepository.updateById(destino);
        }
        return null;
    }
}

