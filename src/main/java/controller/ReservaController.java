package controller;

import java.util.Date;
import java.util.List;
import model.entities.Local;
import model.entities.Reserva;
import model.entities.Usuario;
import model.services.ReservaService;
import model.services.LocalService;
import model.services.UsuarioService;

public class ReservaController {

    private ReservaService reservaService = new ReservaService();
    private LocalService localService = new LocalService();
    private UsuarioService usuarioService = new UsuarioService();

    public void create(Reserva reserva) {
        reservaService.create(reserva);
    }

    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    public Reserva findReservaById(Long id) {
        return reservaService.findReservaById(id);
    }

    public boolean deletarReserva(Long id) {
        return reservaService.deletarReserva(id);
    }

    public Reserva updateReserva(Long id, Date dataReserva, String detalhes, Usuario usuario, Local local) {
        return reservaService.updateReserva(id, dataReserva, detalhes, usuario, local);
    }

    public Local findLocalById(Long id) {
        return localService.findLocalById(id);
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioService.findUsuarioById(id);
    }
}
