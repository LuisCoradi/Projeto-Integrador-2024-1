package model.repositories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

import model.entities.Usuario;

public class UsuarioRepository implements BasicCrud {

    EntityManager em = Persistence.createEntityManagerFactory("admin").createEntityManager();

    @Override
    public Usuario create(Object object) {
        Usuario usuario = (Usuario) object;
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        return findById(usuario.getId());
    }

    @Override
    public Usuario findById(Long id) {
        try {
            return em.find(Usuario.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Usuario updateById(Object object) {
        Usuario usuarioUpdate = (Usuario) object;
        em.getTransaction().begin();
        em.merge(usuarioUpdate);
        em.getTransaction().commit();
        return findById(usuarioUpdate.getId());
    }

    @Override
     public void delete(Long id) {
        em.getTransaction().begin();
        Usuario usuario = findById(id);
        if (usuario != null) {
            em.remove(usuario);
        }
        em.getTransaction().commit();
    }

    public List<Usuario> findAll() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public Usuario update(Long id, String nome, String email, String senha, Date dataCadastro, String informacoesPerfil) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            em.getTransaction().begin();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setDataCadastro(dataCadastro);
            usuario.setInformacoesPerfil(informacoesPerfil);
            em.merge(usuario);
            em.getTransaction().commit();
        }
        return usuario;
    }
}
