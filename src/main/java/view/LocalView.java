package view;

import java.util.List;
import java.util.Scanner;
import controller.LocalController;
import model.entities.Local;

public class LocalView {
/*
    private LocalController localController;
    private Scanner scanner;

    public LocalView() {
        localController = new LocalController();
        scanner = new Scanner(System.in);
    }

    public void criarNovoLocal() {
        System.out.println("Digite o nome do local:");
        String nomeLocal = scanner.nextLine();

        System.out.println("Digite a descrição do local:");
        String descricao = scanner.nextLine();

        System.out.println("Digite a localização do local:");
        String localizacao = scanner.nextLine();

        System.out.println("Digite a foto do local:");
        String fotoLocal = scanner.nextLine();

        System.out.println("Digite a avaliação do local:");
        String avaliacao = scanner.nextLine();

        System.out.println("Digite a categoria do local:");
        String categoriaLocal = scanner.nextLine();

        Local local = new Local();
        local.setNomeLocal(nomeLocal);
        local.setDescricao(descricao);
        local.setLocalizacao(localizacao);
        local.setFotoLocal(fotoLocal);
        local.setAvaliacao(avaliacao);
        local.setCategoriaLocal(categoriaLocal);

        localController.create(local);
        System.out.println("Local cadastrado com sucesso!");
    }

    public void mostrarTodosLocais() {
        List<Local> locais = localController.findAll();
        for (Local local : locais) {
            System.out.println("ID: " + local.getId() + ", Nome: " + local.getNomeLocal());
            System.out.println("///////////////////////////////////////////");
        }
    }

    public void mostrarLocalPorId(Long id) {
        Local local = localController.findLocalById(id);
        if (local != null) {
            System.out.println("ID: " + local.getId());
            System.out.println("Nome: " + local.getNomeLocal());
            System.out.println("Descrição: " + local.getDescricao());
            System.out.println("Localização: " + local.getLocalizacao());
            System.out.println("Foto: " + local.getFotoLocal());
            System.out.println("Avaliação: " + local.getAvaliacao());
            System.out.println("Categoria: " + local.getCategoriaLocal());
        } else {
            System.out.println("Local não encontrado.");
        }
    }

    public void deletarLocal() {
        List<Local> locais = localController.findAll();
        for (Local local : locais) {
            System.out.println("ID: " + local.getId() + ", Nome: " + local.getNomeLocal());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID do local a ser deletado:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        boolean sucesso = localController.deletarLocal(id);
        if (sucesso) {
            System.out.println("Local deletado com sucesso!");
        } else {
            System.out.println("Não foi possível deletar o local. Ele não existe.");
        }
    }

    public void atualizarLocal() {
        List<Local> locais = localController.findAll();
        for (Local local : locais) {
            System.out.println("ID: " + local.getId() + ", Nome: " + local.getNomeLocal());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID do local a ser atualizado:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite o novo nome do local:");
        String nomeLocal = scanner.nextLine();

        System.out.println("Digite a nova descrição do local:");
        String descricao = scanner.nextLine();

        System.out.println("Digite a nova localização do local:");
        String localizacao = scanner.nextLine();

        System.out.println("Digite a nova foto do local:");
        String fotoLocal = scanner.nextLine();

        System.out.println("Digite a nova avaliação do local:");
        String avaliacao = scanner.nextLine();

        System.out.println("Digite a nova categoria do local:");
        String categoriaLocal = scanner.nextLine();
/*
        Local localAtualizado = localController.updateLocal(id, nomeLocal, descricao, localizacao, fotoLocal, avaliacao, categoriaLocal);
        if (localAtualizado != null) {
            System.out.println("Local atualizado com sucesso!");
        } else {
            System.out.println("Local não encontrado ou atualização falhou.");
        }
        
    }
  */
}
