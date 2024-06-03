package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import controller.ReservaController;
import model.entities.Local;
import model.entities.Reserva;
import model.entities.Usuario;

public class ReservaView {

    private ReservaController reservaController;
    private Scanner scanner;

    public ReservaView() {
        reservaController = new ReservaController();
        scanner = new Scanner(System.in);
    }

    public void criarNovaReserva() {
        System.out.println("Digite a data da reserva (dd/MM/yyyy):");
        String dataReservaStr = scanner.nextLine();

        Date dataReserva = null;
        try {
            dataReserva = new SimpleDateFormat("dd/MM/yyyy").parse(dataReservaStr);
        } catch (ParseException e) {
            System.out.println("Data inválida.");
            return;
        }

        System.out.println("Digite a descrição da reserva:");
        String detalhes = scanner.nextLine();

        System.out.println("Digite o ID do local:");
        Long localId = scanner.nextLong();
        scanner.nextLine();
        Local local = reservaController.findLocalById(localId);
        if (local == null) {
            System.out.println("Local não encontrado.");
            return;
        }

        System.out.println("Digite o ID do usuário:");
        Long usuarioId = scanner.nextLong();
        scanner.nextLine();
        Usuario usuario = reservaController.findUsuarioById(usuarioId);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        Reserva reserva = new Reserva();
        reserva.setDataReserva(dataReserva);
        reserva.setDetalhes(detalhes);
        reserva.setLocal(local);
        reserva.setUsuario(usuario);

        reservaController.create(reserva);
        System.out.println("Reserva cadastrada com sucesso!");
    }

    public void mostrarTodasReservas() {
        List<Reserva> reservas = reservaController.findAll();
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getId() + ", Data: " + reserva.getDataReserva());
            System.out.println("///////////////////////////////////////////");
        }
    }

    public void mostrarReservaPorId(Long id) {
        Reserva reserva = reservaController.findReservaById(id);
        if (reserva != null) {
            System.out.println("ID: " + reserva.getId());
            System.out.println("Data: " + reserva.getDataReserva());
            System.out.println("Descrição: " + reserva.getDetalhes());
            System.out.println("Local: " + reserva.getLocal().getNomeLocal());
            System.out.println("Usuário: " + reserva.getUsuario().getNome());
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    public void deletarReserva() {
        List<Reserva> reservas = reservaController.findAll();
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getId() + ", Data: " + reserva.getDataReserva());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID da reserva a ser deletada:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        boolean sucesso = reservaController.deletarReserva(id);
        if (sucesso) {
            System.out.println("Reserva deletada com sucesso!");
        } else {
            System.out.println("Não foi possível deletar a reserva. Ela não existe.");
        }
    }

    public void atualizarReserva() {
        List<Reserva> reservas = reservaController.findAll();
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getId() + ", Data: " + reserva.getDataReserva());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID da reserva a ser atualizada:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite a nova data da reserva (dd/MM/yyyy):");
        String dataReservaStr = scanner.nextLine();
        Date dataReserva = null;
        try {
            dataReserva = new SimpleDateFormat("dd/MM/yyyy").parse(dataReservaStr);
        } catch (ParseException e) {
            System.out.println("Data inválida.");
            return;
        }

        System.out.println("Digite a nova descrição da reserva:");
        String detalhes = scanner.nextLine();

        System.out.println("Digite o novo ID do local:");
        Long localId = scanner.nextLong();
        scanner.nextLine();
        Local local = reservaController.findLocalById(localId);
        if (local == null) {
            System.out.println("Local não encontrado.");
            return;
        }

        System.out.println("Digite o novo ID do usuário:");
        Long usuarioId = scanner.nextLong();
        scanner.nextLine();
        Usuario usuario = reservaController.findUsuarioById(usuarioId);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        Reserva reservaAtualizada = reservaController.updateReserva(id, dataReserva, detalhes, usuario, local);
        if (reservaAtualizada != null) {
            System.out.println("Reserva atualizada com sucesso!");
        } else {
            System.out.println("Reserva não encontrada ou atualização falhou.");
        }
    }
}
