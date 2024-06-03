package model.services;

import java.util.Date;
import java.util.List;
import model.entities.Local;
import model.entities.Reserva;
import model.entities.Usuario;
import model.repositories.ReservaRepository;

public class ReservaService {

    private ReservaRepository reservaRepository = new ReservaRepository();

    public void create(Reserva reserva) {
        reservaRepository.create(reserva);
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva findReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    public boolean deletarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id);
        if (reserva != null) {
            reservaRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    public Reserva updateReserva(Long id, Date dataReserva, String detalhes, Usuario usuario, Local local) {
        Reserva reserva = reservaRepository.findById(id);
        if (reserva != null) {
            reserva.setDataReserva(dataReserva);
            reserva.setDetalhes(detalhes);
            reserva.setUsuario(usuario);
            reserva.setLocal(local);
            return reservaRepository.updateById(reserva);
        }
        return null;
    }
}
