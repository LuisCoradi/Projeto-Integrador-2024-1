package controller;

import java.util.List;
import model.entities.Destino;
import model.services.DestinoService;

public class DestinoController {

    private DestinoService destinoService = new DestinoService();

    public void create(Destino destino) {
        destinoService.create(destino);
    }

    public List<Destino> findAll() {
        return destinoService.findAll();
    }

    public Destino findDestinoById(Long id) {
        return destinoService.findDestinoById(id);
    }

    public boolean deletarDestino(Long id) {
        return destinoService.deletarDestino(id);
    }

    public Destino updateDestino(Long id, String nomeDestino, String descricaoDestino, String fotoDestino, String pais, String regiao) {
        return destinoService.updateDestino(id, nomeDestino, descricaoDestino, fotoDestino, pais, regiao);
    }
}
