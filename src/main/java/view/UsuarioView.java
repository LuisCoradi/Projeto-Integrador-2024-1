package view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import controller.UsuarioController;
import model.entities.Usuario;

public class UsuarioView {

    private UsuarioController usuarioController;
    private Scanner scanner;

    public UsuarioView() {
        usuarioController = new UsuarioController();
        scanner = new Scanner(System.in);
    }

    public void criarNovoUsuario() {
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do usuário:");
        String email = scanner.nextLine();

        System.out.println("Digite a senha do usuário:");
        String senha = scanner.nextLine();

        System.out.println("Digite as informações de perfil do usuário:");
        String informacoesPerfil = scanner.nextLine();

        // Obtendo a data atual
        Date dataCadastro = new Date();

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setDataCadastro(dataCadastro);
        usuario.setInformacoesPerfil(informacoesPerfil);

        usuarioController.create(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void mostrarTodosUsuarios() {
        List<Usuario> usuarios = usuarioController.findAll();
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome());
            System.out.println("///////////////////////////////////////////");
        }
    }

    public void mostrarUsuarioPorId(Long id) {
        Usuario usuario = usuarioController.findUsuarioById(id);
        if (usuario != null) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Data de Cadastro: " + usuario.getDataCadastro());
            System.out.println("Informações de Perfil: " + usuario.getInformacoesPerfil());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void deletarUsuario() {
        List<Usuario> usuarios = usuarioController.findAll();
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID do usuário a ser deletado:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        boolean sucesso = usuarioController.deletarUsuario(id);
        if (sucesso) {
            System.out.println("Usuário deletado com sucesso!");
        } else {
            System.out.println("Não foi possível deletar o usuário. Ele possui dados pendentes ou não existe.");
        }
    }

    public void atualizarUsuario() {
        List<Usuario> usuarios = usuarioController.findAll();
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome());
            System.out.println("///////////////////////////////////////////");
        }
        System.out.println("Digite o ID do usuário a ser atualizado:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite o novo nome do usuário:");
        String nome = scanner.nextLine();

        System.out.println("Digite o novo email do usuário:");
        String email = scanner.nextLine();

        System.out.println("Digite a nova senha do usuário:");
        String senha = scanner.nextLine();

        System.out.println("Digite as novas informações de perfil do usuário:");
        String informacoesPerfil = scanner.nextLine();

        Usuario usuarioAtualizado = usuarioController.updateUsuario(id, nome, email, senha, informacoesPerfil);
        if (usuarioAtualizado != null) {
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado ou atualização falhou.");
        }
    }
}
