package model.repositories;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Local;
import model.entities.Reserva;
import model.entities.Usuario;

public class ReservaRepository implements BasicCrud {

    EntityManager em = Persistence.createEntityManagerFactory("admin").createEntityManager();

    @Override
    public Reserva create(Object object) {
        Reserva reserva = (Reserva) object;
        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();
        return findById(reserva.getId());
    }

    @Override
    public Reserva findById(Long id) {
        try {
            return em.find(Reserva.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return null;
    }

    @Override
    public Reserva updateById(Object object) {
        Reserva reservaUpdate = (Reserva) object;
        em.getTransaction().begin();
        em.merge(reservaUpdate);
        em.getTransaction().commit();
        return findById(reservaUpdate.getId());
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Reserva reserva = findById(id);
        em.remove(reserva);
        em.getTransaction().commit();
    }

    public List<Reserva> findAll() {
        return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
    }

    public Reserva update(Long id, Date dataReserva, String detalhes, Usuario usuario, Local local) {
        Reserva reserva = findById(id);
        if (reserva != null) {
            em.getTransaction().begin();
            reserva.setDataReserva(dataReserva);
            reserva.setDetalhes(detalhes);
            reserva.setUsuario(usuario);
            reserva.setLocal(local);
            em.merge(reserva);
            em.getTransaction().commit();
        }
        return reserva;
    }
}
