package model.services;

import java.util.List;
import model.entities.Local;
import model.repositories.LocalRepository;

public class LocalService {

    private LocalRepository localRepository = new LocalRepository();

    public void create(Local local) {
        localRepository.create(local);
    }

    public List<Local> findAll() {
        return localRepository.findAll();
    }

    public Local findLocalById(Long id) {
        return localRepository.findById(id);
    }

    public boolean deletarLocal(Long id) {
        Local local = localRepository.findById(id);
        if (local != null) {
            localRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    public Local updateLocal(Long id, String nomeLocal, String descricao, String localizacao, String fotoLocal, String avaliacao, String categoriaLocal) {
        Local local = localRepository.findById(id);
        if (local != null) {
            local.setNomeLocal(nomeLocal);
            local.setDescricao(descricao);
            local.setLocalizacao(localizacao);
            local.setFotoLocal(fotoLocal);
            local.setAvaliacao(avaliacao);
            local.setCategoriaLocal(categoriaLocal);
            return localRepository.updateById(local);
        }
        return null;
    }
}