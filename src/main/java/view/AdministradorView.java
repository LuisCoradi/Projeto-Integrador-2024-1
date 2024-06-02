package view;

import java.util.List;
import java.util.Scanner;
import controller.AdministradorController;
import model.entities.Administrador;

public class AdministradorView {

    private AdministradorController administradorController;
    private Scanner scanner;

    public AdministradorView() {
        administradorController = new AdministradorController();
        scanner = new Scanner(System.in);
    }

    public void criarNovoAdministrador() {
        System.out.println("Digite o nome do administrador:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do administrador:");
        String email = scanner.nextLine();

        System.out.println("Digite a senha do administrador:");
        String senha = scanner.nextLine();

        System.out.println("Digite o nível de permissão do administrador:");
        int nivelPermissao = scanner.nextInt();
        scanner.nextLine();

        Administrador administrador = new Administrador();
        administrador.setNome(nome);
        administrador.setEmail(email);
        administrador.setSenha(senha);
        administrador.setNivelPermissao(nivelPermissao);

        administradorController.create(administrador);
        System.out.println("Administrador cadastrado com sucesso!");
    }

    public void mostrarTodosAdministradores() {
        List<Administrador> administradores = administradorController.findAll();
        for (Administrador administrador : administradores) {
            System.out.println("ID: " + administrador.getId() + ", Nome: " + administrador.getNome());
            System.out.println("///////////////////////////////////////////");
        }
    }

    public void mostrarAdministradorPorId(Long id) {
        Administrador administrador = administradorController.findAdministradorById(id);
        if (administrador != null) {
            System.out.println("ID: " + administrador.getId());
            System.out.println("Nome: " + administrador.getNome());
            System.out.println("Email: " + administrador.getEmail());
            System.out.println("Nível de Permissão: " + administrador.getNivelPermissao());
        } else {
            System.out.println("Administrador não encontrado.");
        }
    }

    public void deletarAdministrador() {
        List<Administrador> administradores = administradorController.findAll();
        for (Administrador administrador : administradores) {
            System.out.println("ID: " + administrador.getId() + ", Nome: " + administrador.getNome());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID do administrador a ser deletado:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        boolean sucesso = administradorController.deletarAdministrador(id);
        if (sucesso) {
            System.out.println("Administrador deletado com sucesso!");
        } else {
            System.out.println("Não foi possível deletar o administrador. Ele não existe.");
        }
    }

    public void atualizarAdministrador() {
        List<Administrador> administradores = administradorController.findAll();
        for (Administrador administrador : administradores) {
            System.out.println("ID: " + administrador.getId() + ", Nome: " + administrador.getNome());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID do administrador a ser atualizado:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite o novo nome do administrador:");
        String nome = scanner.nextLine();

        System.out.println("Digite o novo email do administrador:");
        String email = scanner.nextLine();

        System.out.println("Digite a nova senha do administrador:");
        String senha = scanner.nextLine();

        System.out.println("Digite o novo nível de permissão do administrador:");
        int nivelPermissao = scanner.nextInt();
        scanner.nextLine();

        Administrador administradorAtualizado = administradorController.updateAdministrador(id, nome, email, senha, nivelPermissao);
        if (administradorAtualizado != null) {
            System.out.println("Administrador atualizado com sucesso!");
        } else {
            System.out.println("Administrador não encontrado ou atualização falhou.");
        }
    }
}
