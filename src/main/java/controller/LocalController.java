package controller;

import java.util.List;
import model.entities.Local;
import model.services.LocalService;

public class LocalController {

    private LocalService localService = new LocalService();

    public void create(Local local) {
        localService.create(local);
    }

    public List<Local> findAll() {
        return localService.findAll();
    }

    public Local findLocalById(Long id) {
        return localService.findLocalById(id);
    }

    public boolean deletarLocal(Long id) {
        return localService.deletarLocal(id);
    }

    public Local updateLocal(Long id, String nomeLocal, String descricao, String localizacao, String fotoLocal, String avaliacao, String categoriaLocal) {
        return localService.updateLocal(id, nomeLocal, descricao, localizacao, fotoLocal, avaliacao, categoriaLocal);
    }
}

