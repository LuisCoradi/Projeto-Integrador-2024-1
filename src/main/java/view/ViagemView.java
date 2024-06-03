package view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import controller.ViagemController;
import model.entities.Destino;
import model.entities.Usuario;
import model.entities.Viagem;

public class ViagemView {

    private ViagemController viagemController;
    private Scanner scanner;

    public ViagemView() {
        viagemController = new ViagemController();
        scanner = new Scanner(System.in);
    }

    public void criarNovaViagem() {
        System.out.println("Digite a data de início da viagem (dd/MM/yyyy):");
        String dataInicioStr = scanner.nextLine();
        Date dataInicio = null;
        try {
            dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioStr);
        } catch (ParseException e) {
            System.out.println("Data inválida.");
            return;
        }

        System.out.println("Digite a data de término da viagem (dd/MM/yyyy):");
        String dataTerminoStr = scanner.nextLine();
        Date dataTermino = null;
        try {
            dataTermino = new SimpleDateFormat("dd/MM/yyyy").parse(dataTerminoStr);
        } catch (ParseException e) {
            System.out.println("Data inválida.");
            return;
        }

        System.out.println("Digite o status da viagem:");
        String statusViagem = scanner.nextLine();

        System.out.println("Digite o orçamento da viagem:");
        Double orcamento = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Digite a avaliação da viagem:");
        String avaliacaoViagem = scanner.nextLine();

        System.out.println("Digite o ID do usuário:");
        Long usuarioId = scanner.nextLong();
        scanner.nextLine();
        Usuario usuario = viagemController.findUsuarioById(usuarioId);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Digite o ID do destino:");
        Long destinoId = scanner.nextLong();
        scanner.nextLine();
        Destino destino = viagemController.findDestinoById(destinoId);
        if (destino == null) {
            System.out.println("Destino não encontrado.");
            return;
        }

        Viagem viagem = new Viagem();
        viagem.setDataInicio(dataInicio);
        viagem.setDataTermino(dataTermino);
        viagem.setStatusViagem(statusViagem);
        viagem.setOrcamento(orcamento);
        viagem.setAvaliacaoViagem(avaliacaoViagem);
        viagem.setUsuario(usuario);
        viagem.setDestino(destino);

        viagemController.create(viagem);
        System.out.println("Viagem cadastrada com sucesso!");
    }

    public void mostrarTodasViagens() {
        List<Viagem> viagens = viagemController.findAll();
        for (Viagem viagem : viagens) {
            System.out.println("ID: " + viagem.getId() + ", Data de Início: " + viagem.getDataInicio());
            System.out.println("///////////////////////////////////////////");
        }
    }

    public void mostrarViagemPorId(Long id) {
        Viagem viagem = viagemController.findViagemById(id);
        if (viagem != null) {
            System.out.println("ID: " + viagem.getId());
            System.out.println("Data de Início: " + viagem.getDataInicio());
            System.out.println("Data de Término: " + viagem.getDataTermino());
            System.out.println("Status: " + viagem.getStatusViagem());
            System.out.println("Orçamento: " + viagem.getOrcamento());
            System.out.println("Avaliação: " + viagem.getAvaliacaoViagem());
            System.out.println("Usuário: " + viagem.getUsuario().getNome());
            System.out.println("Destino: " + viagem.getDestino().getNomeDestino());
        } else {
            System.out.println("Viagem não encontrada.");
        }
    }

    public void deletarViagem() {
        List<Viagem> viagens = viagemController.findAll();
        for (Viagem viagem : viagens) {
            System.out.println("ID: " + viagem.getId() + ", Data de Início: " + viagem.getDataInicio());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID da viagem a ser deletada:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        boolean sucesso = viagemController.deletarViagem(id);
        if (sucesso) {
            System.out.println("Viagem deletada com sucesso!");
        } else {
            System.out.println("Não foi possível deletar a viagem. Ela não existe.");
        }
    }

    public void atualizarViagem() {
        List<Viagem> viagens = viagemController.findAll();
        for (Viagem viagem : viagens) {
            System.out.println("ID: " + viagem.getId() + ", Data de Início: " + viagem.getDataInicio());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID da viagem a ser atualizada:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite a nova data de início da viagem (dd/MM/yyyy):");
        String dataInicioStr = scanner.nextLine();
        Date dataInicio = null;
        try {
            dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioStr);
        } catch (ParseException e) {
            System.out.println("Data inválida.");
            return;
        }

        System.out.println("Digite a nova data de término da viagem (dd/MM/yyyy):");
        String dataTerminoStr = scanner.nextLine();
        Date dataTermino = null;
        try {
            dataTermino = new SimpleDateFormat("dd/MM/yyyy").parse(dataTerminoStr);
        } catch (ParseException e) {
            System.out.println("Data inválida.");
            return;
        }

        System.out.println("Digite o novo status da viagem:");
        String statusViagem = scanner.nextLine();

        System.out.println("Digite o novo orçamento da viagem:");
        Double orcamento = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Digite a nova avaliação da viagem:");
        String avaliacaoViagem = scanner.nextLine();

        System.out.println("Digite o novo ID do usuário:");
        Long usuarioId = scanner.nextLong();
        scanner.nextLine();
        Usuario usuario = viagemController.findUsuarioById(usuarioId);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Digite o novo ID do destino:");
        Long destinoId = scanner.nextLong();
        scanner.nextLine();
        Destino destino = viagemController.findDestinoById(destinoId);
        if (destino == null) {
            System.out.println("Destino não encontrado.");
            return;
        }

        Viagem viagemAtualizada = viagemController.updateViagem(id, dataInicio, dataTermino, statusViagem, orcamento, avaliacaoViagem, usuario, destino);
        if (viagemAtualizada != null) {
            System.out.println("Viagem atualizada com sucesso!");
        } else {
            System.out.println("Viagem não encontrada ou atualização falhou.");
        }
    }
}
