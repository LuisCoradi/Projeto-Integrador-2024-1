package controller;

import java.util.List;
import model.entities.Administrador;
import model.services.AdministradorService;

public class AdministradorController {

    private AdministradorService administradorService = new AdministradorService();

    public void create(Administrador administrador) {
        administradorService.create(administrador);
    }

    public List<Administrador> findAll() {
        return administradorService.findAll();
    }

    public Administrador findAdministradorById(Long id) {
        return administradorService.findAdministradorById(id);
    }

    public boolean deletarAdministrador(Long id) {
        return administradorService.deletarAdministrador(id);
    }

    public Administrador updateAdministrador(Long id, String nome, String email, String senha, int nivelPermissao) {
        return administradorService.updateAdministrador(id, nome, email, senha, nivelPermissao);
    }
}
