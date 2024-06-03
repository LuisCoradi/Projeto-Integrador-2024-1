package model.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.entities.Destino;

public class DestinoRepository implements BasicCrud {

    EntityManager em = Persistence.createEntityManagerFactory("admin").createEntityManager();

    @Override
    public Destino create(Object object) {
        Destino destino = (Destino) object;
        em.getTransaction().begin();
        em.persist(destino);
        em.getTransaction().commit();
        return findById(destino.getId());
    }

    @Override
    public Destino findById(Long id) {
        try {
            return em.find(Destino.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Destino updateById(Object object) {
        Destino destinoUpdate = (Destino) object;
        em.getTransaction().begin();
        em.merge(destinoUpdate);
        em.getTransaction().commit();
        return findById(destinoUpdate.getId());
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Destino destino = findById(id);
        em.remove(destino);
        em.getTransaction().commit();
    }

    public List<Destino> findAll() {
        return em.createQuery("SELECT d FROM Destino d", Destino.class).getResultList();
    }

    public Destino update(Long id, String nomeDestino, String descricaoDestino, String fotoDestino, String pais, String regiao) {
        Destino destino = findById(id);
        if (destino != null) {
            em.getTransaction().begin();
            destino.setNomeDestino(nomeDestino);
            destino.setDescricaoDestino(descricaoDestino);
            destino.setFotoDestino(fotoDestino);
            destino.setPais(pais);
            destino.setRegiao(regiao);
            em.merge(destino);
            em.getTransaction().commit();
        }
        return destino;
    }
}
