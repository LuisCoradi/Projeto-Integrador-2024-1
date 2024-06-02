package model.repositories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import model.entities.Administrador;

public class AdministradorRepository implements BasicCrud {

    EntityManager em = Persistence.createEntityManagerFactory("admin").createEntityManager();

    @Override
    public Administrador create(Object object) {
        Administrador administrador = (Administrador) object;
        em.getTransaction().begin();
        em.persist(administrador);
        em.getTransaction().commit();
        return findById(administrador.getId());
    }

    @Override
    public Administrador findById(Long id) {
        try {
            return em.find(Administrador.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Administrador updateById(Object object) {
        Administrador administradorUpdate = (Administrador) object;
        em.getTransaction().begin();
        em.merge(administradorUpdate);
        em.getTransaction().commit();
        return findById(administradorUpdate.getId());
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Administrador administrador = findById(id);
        if (administrador != null) {
            em.remove(administrador);
        }
        em.getTransaction().commit();
    }

    public List<Administrador> findAll() {
        return em.createQuery("SELECT a FROM Administrador a", Administrador.class).getResultList();
    }

    public Administrador update(Long id, String nome, String email, String senha, int nivelPermissao) {
        Administrador administrador = findById(id);
        if (administrador != null) {
            em.getTransaction().begin();
            administrador.setNome(nome);
            administrador.setEmail(email);
            administrador.setSenha(senha);
            administrador.setNivelPermissao(nivelPermissao);
            em.merge(administrador);
            em.getTransaction().commit();
        }
        return administrador;
    }
}
