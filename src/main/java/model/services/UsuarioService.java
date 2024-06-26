package model.services;

import java.util.Date;
import java.util.List;

import model.entities.Local;
import model.entities.Usuario;
import model.repositories.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public Usuario create(Usuario usuario) {
        usuario.setDataCadastro(new Date());
        return usuarioRepository.create(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public boolean deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario != null) {
            usuarioRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    public Usuario updateUsuario(Long id, String nome, String email, String senha, String informacoesPerfil) {
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario != null) {
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setInformacoesPerfil(informacoesPerfil);
            return usuarioRepository.updateById(usuario);
        }
        return null;
    }
    
    public boolean verificarUsuario(String email, String senha) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            if(email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
                return true;
            }
        }
        return false;
    }
}
