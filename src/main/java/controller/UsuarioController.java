package controller;

import java.util.List;
import model.entities.Usuario;
import model.services.UsuarioService;

public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();

    public Usuario create(Usuario usuario) {
        return usuarioService.create(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioService.findUsuarioById(id);
    }

    public boolean deletarUsuario(Long id) {
        return usuarioService.deletarUsuario(id);
    }

    public Usuario updateUsuario(Long id, String nome, String email, String senha, String informacoesPerfil) {
        return usuarioService.updateUsuario(id, nome, email, senha, informacoesPerfil);
    }
    
    public boolean verificarUsuario() {
    	return usuarioService.verificarUsuario();
    }
}
