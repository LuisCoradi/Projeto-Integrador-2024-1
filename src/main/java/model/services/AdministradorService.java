package model.services;

import java.util.List;
import model.entities.Administrador;
import model.repositories.AdministradorRepository;

public class AdministradorService {

    private AdministradorRepository administradorRepository = new AdministradorRepository();

    public void create(Administrador administrador) {
        administradorRepository.create(administrador);
    }

    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    public Administrador findAdministradorById(Long id) {
        return administradorRepository.findById(id);
    }

    public boolean deletarAdministrador(Long id) {
        Administrador administrador = administradorRepository.findById(id);
        if (administrador != null) {
            administradorRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    public Administrador updateAdministrador(Long id, String nome, String email, String senha, int nivelPermissao) {
        Administrador administrador = administradorRepository.findById(id);
        if (administrador != null) {
            administrador.setNome(nome);
            administrador.setEmail(email);
            administrador.setSenha(senha);
            administrador.setNivelPermissao(nivelPermissao);
            return administradorRepository.updateById(administrador);
        }
        return null;
    }
}

