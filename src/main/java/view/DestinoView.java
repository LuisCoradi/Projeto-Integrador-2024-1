package view;

import java.util.List;
import java.util.Scanner;
import controller.DestinoController;
import model.entities.Destino;

public class DestinoView {

    private DestinoController destinoController;
    private Scanner scanner;

    public DestinoView() {
        destinoController = new DestinoController();
        scanner = new Scanner(System.in);
    }

    public void criarNovoDestino() {
        System.out.println("Digite o nome do destino:");
        String nomeDestino = scanner.nextLine();

        System.out.println("Digite a descrição do destino:");
        String descricaoDestino = scanner.nextLine();

        System.out.println("Digite a foto do destino:");
        String fotoDestino = scanner.nextLine();

        System.out.println("Digite o país do destino:");
        String pais = scanner.nextLine();

        System.out.println("Digite a região do destino:");
        String regiao = scanner.nextLine();

        Destino destino = new Destino();
        destino.setNomeDestino(nomeDestino);
        destino.setDescricaoDestino(descricaoDestino);
        destino.setFotoDestino(fotoDestino);
        destino.setPais(pais);
        destino.setRegiao(regiao);

        destinoController.create(destino);
        System.out.println("Destino cadastrado com sucesso!");
    }

    public void mostrarTodosDestinos() {
        List<Destino> destinos = destinoController.findAll();
        for (Destino destino : destinos) {
            System.out.println("ID: " + destino.getId() + ", Nome: " + destino.getNomeDestino());
            System.out.println("///////////////////////////////////////////");
        }
    }

    public void mostrarDestinoPorId(Long id) {
        Destino destino = destinoController.findDestinoById(id);
        if (destino != null) {
            System.out.println("ID: " + destino.getId());
            System.out.println("Nome: " + destino.getNomeDestino());
            System.out.println("Descrição: " + destino.getDescricaoDestino());
            System.out.println("Foto: " + destino.getFotoDestino());
            System.out.println("País: " + destino.getPais());
            System.out.println("Região: " + destino.getRegiao());
        } else {
            System.out.println("Destino não encontrado.");
        }
    }

    public void deletarDestino() {
        List<Destino> destinos = destinoController.findAll();
        for (Destino destino : destinos) {
            System.out.println("ID: " + destino.getId() + ", Nome: " + destino.getNomeDestino());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID do destino a ser deletado:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        boolean sucesso = destinoController.deletarDestino(id);
        if (sucesso) {
            System.out.println("Destino deletado com sucesso!");
        } else {
            System.out.println("Não foi possível deletar o destino. Ele não existe.");
        }
    }

    public void atualizarDestino() {
        List<Destino> destinos = destinoController.findAll();
        for (Destino destino : destinos) {
            System.out.println("ID: " + destino.getId() + ", Nome: " + destino.getNomeDestino());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID do destino a ser atualizado:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite o novo nome do destino:");
        String nomeDestino = scanner.nextLine();

        System.out.println("Digite a nova descrição do destino:");
        String descricaoDestino = scanner.nextLine();

        System.out.println("Digite a nova foto do destino:");
        String fotoDestino = scanner.nextLine();

        System.out.println("Digite o novo país do destino:");
        String pais = scanner.nextLine();

        System.out.println("Digite a nova região do destino:");
        String regiao = scanner.nextLine();

        Destino destinoAtualizado = destinoController.updateDestino(id, nomeDestino, descricaoDestino, fotoDestino, pais, regiao);
        if (destinoAtualizado != null) {
            System.out.println("Destino atualizado com sucesso!");
        } else {
            System.out.println("Destino não encontrado ou atualização falhou.");
        }
    }
}
