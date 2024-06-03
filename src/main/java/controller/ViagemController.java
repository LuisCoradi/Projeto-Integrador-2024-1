package controller;

import java.util.Date;
import java.util.List;
import model.entities.Destino;
import model.entities.Usuario;
import model.entities.Viagem;
import model.services.ViagemService;
import model.services.DestinoService;
import model.services.UsuarioService;

public class ViagemController {

    private ViagemService viagemService = new ViagemService();
    private DestinoService destinoService = new DestinoService();
    private UsuarioService usuarioService = new UsuarioService();

    public void create(Viagem viagem) {
        viagemService.create(viagem);
    }

    public List<Viagem> findAll() {
        return viagemService.findAll();
    }

    public Viagem findViagemById(Long id) {
        return viagemService.findViagemById(id);
    }

    public boolean deletarViagem(Long id) {
        return viagemService.deletarViagem(id);
    }

    public Viagem updateViagem(Long id, Date dataInicio, Date dataTermino, String statusViagem, Double orcamento, String avaliacaoViagem, Usuario usuario, Destino destino) {
        return viagemService.updateViagem(id, dataInicio, dataTermino, statusViagem, orcamento, avaliacaoViagem, usuario, destino);
    }

    public Destino findDestinoById(Long id) {
        return destinoService.findDestinoById(id);
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioService.findUsuarioById(id);
    }
}
