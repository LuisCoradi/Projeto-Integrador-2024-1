package model.repositories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import model.entities.Local;

public class LocalRepository implements BasicCrud {

    EntityManager em = Persistence.createEntityManagerFactory("admin").createEntityManager();

    @Override
    public Local create(Object object) {
        Local local = (Local) object;
        em.getTransaction().begin();
        em.persist(local);
        em.getTransaction().commit();
        return findById(local.getId());
    }

    @Override
    public Local findById(Long id) {
        try {
            return em.find(Local.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Local updateById(Object object) {
        Local localUpdate = (Local) object;
        em.getTransaction().begin();
        em.merge(localUpdate);
        em.getTransaction().commit();
        return findById(localUpdate.getId());
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Local local = findById(id);
        if (local != null) {
            em.remove(local);
        }
        em.getTransaction().commit();
    }

    public List<Local> findAll() {
        return em.createQuery("SELECT l FROM Local l", Local.class).getResultList();
    }

    public Local update(Long id, String nomeLocal, String descricao, String latitudeY, String latitudeX, String fotoLocal, String avaliacao, String categoriaLocal) {
        Local local = findById(id);
        if (local != null) {
            em.getTransaction().begin();
            local.setNomeLocal(nomeLocal);
            local.setDescricao(descricao);
            local.setLatitudeY(latitudeY);
            local.setLatitudeX(latitudeX);
            local.setFotoLocal(fotoLocal);
            local.setAvaliacao(avaliacao);
            local.setCategoriaLocal(categoriaLocal);
            em.merge(local);
            em.getTransaction().commit();
        }
        return local;
    }
}
