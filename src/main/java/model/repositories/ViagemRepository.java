package model.repositories;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Destino;
import model.entities.Usuario;
import model.entities.Viagem;

public class ViagemRepository implements BasicCrud {

    EntityManager em = Persistence.createEntityManagerFactory("admin").createEntityManager();

    @Override
    public Viagem create(Object object) {
        Viagem viagem = (Viagem) object;
        em.getTransaction().begin();
        em.persist(viagem);
        em.getTransaction().commit();
        return findById(viagem.getId());
    }

    @Override
    public Viagem findById(Long id) {
        try {
            return em.find(Viagem.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Viagem updateById(Object object) {
        Viagem viagemUpdate = (Viagem) object;
        em.getTransaction().begin();
        em.merge(viagemUpdate);
        em.getTransaction().commit();
        return findById(viagemUpdate.getId());
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Viagem viagem = findById(id);
        em.remove(viagem);
        em.getTransaction().commit();
    }

    public List<Viagem> findAll() {
        return em.createQuery("SELECT v FROM Viagem v", Viagem.class).getResultList();
    }

    public Viagem update(Long id, Date dataInicio, Date dataTermino, String statusViagem, Double orcamento, String avaliacaoViagem, Usuario usuario, Destino destino) {
        Viagem viagem = findById(id);
        if (viagem != null) {
            em.getTransaction().begin();
            viagem.setDataInicio(dataInicio);
            viagem.setDataTermino(dataTermino);
            viagem.setStatusViagem(statusViagem);
            viagem.setOrcamento(orcamento);
            viagem.setAvaliacaoViagem(avaliacaoViagem);
            viagem.setUsuario(usuario);
            viagem.setDestino(destino);
            em.merge(viagem);
            em.getTransaction().commit();
        }
        return viagem;
    }
}
