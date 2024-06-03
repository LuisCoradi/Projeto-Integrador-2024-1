package model.services;

import java.util.Date;
import java.util.List;
import model.entities.Destino;
import model.entities.Usuario;
import model.entities.Viagem;
import model.repositories.ViagemRepository;

public class ViagemService {

    private ViagemRepository viagemRepository = new ViagemRepository();

    public void create(Viagem viagem) {
        viagemRepository.create(viagem);
    }

    public List<Viagem> findAll() {
        return viagemRepository.findAll();
    }

    public Viagem findViagemById(Long id) {
        return viagemRepository.findById(id);
    }

    public boolean deletarViagem(Long id) {
        Viagem viagem = viagemRepository.findById(id);
        if (viagem != null) {
            viagemRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    public Viagem updateViagem(Long id, Date dataInicio, Date dataTermino, String statusViagem, Double orcamento, String avaliacaoViagem, Usuario usuario, Destino destino) {
        Viagem viagem = viagemRepository.findById(id);
        if (viagem != null) {
            viagem.setDataInicio(dataInicio);
            viagem.setDataTermino(dataTermino);
            viagem.setStatusViagem(statusViagem);
            viagem.setOrcamento(orcamento);
            viagem.setAvaliacaoViagem(avaliacaoViagem);
            viagem.setUsuario(usuario);
            viagem.setDestino(destino);
            return viagemRepository.updateById(viagem);
        }
        return null;
    }
}
