package main;

import view.LocalView;
import view.UsuarioView;
import view.AdministradorView;

import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static LocalView localView = new LocalView();
    private static UsuarioView usuarioView = new UsuarioView();
    private static AdministradorView administradorView = new AdministradorView();

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showUsuarioMenu();
                    break;
                case 2:
                    showAdministradorMenu();
                    break;
                case 3:
                    showLocalMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Gerenciar Usuarios");
        System.out.println("2. Gerenciar Administradores");
        System.out.println("3. Gerenciar Locais");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void showUsuarioMenu() {
        while (true) {
            System.out.println("=== Menu Usuarios ===");
            System.out.println("1. Cadastrar Usuario");
            System.out.println("2. Atualizar Usuario");
            System.out.println("3. Deletar Usuario");
            System.out.println("4. Ver Usuario por ID");
            System.out.println("5. Ver Todos Usuarios");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    usuarioView.criarNovoUsuario();
                    break;
                case 2:
                    usuarioView.atualizarUsuario();
                    break;
                case 3:
                    usuarioView.deletarUsuario();
                    break;
                case 4:
                    System.out.println("Digite o ID do Usuario:");
                    Long id = Long.parseLong(scanner.nextLine());
                    usuarioView.mostrarUsuarioPorId(id);
                    break;
                case 5:
                    usuarioView.mostrarTodosUsuarios();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void showAdministradorMenu() {
        while (true) {
            System.out.println("=== Menu Administradores ===");
            System.out.println("1. Cadastrar Administrador");
            System.out.println("2. Atualizar Administrador");
            System.out.println("3. Deletar Administrador");
            System.out.println("4. Ver Administrador por ID");
            System.out.println("5. Ver Todos Administradores");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    administradorView.criarNovoAdministrador();
                    break;
                case 2:
                    administradorView.atualizarAdministrador();
                    break;
                case 3:
                    administradorView.deletarAdministrador();
                    break;
                case 4:
                    System.out.println("Digite o ID do Administrador:");
                    Long id = Long.parseLong(scanner.nextLine());
                    administradorView.mostrarAdministradorPorId(id);
                    break;
                case 5:
                    administradorView.mostrarTodosAdministradores();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void showLocalMenu() {
        while (true) {
            System.out.println("=== Menu Locais ===");
            System.out.println("1. Cadastrar Local");
            System.out.println("2. Atualizar Local");
            System.out.println("3. Deletar Local");
            System.out.println("4. Ver Local por ID");
            System.out.println("5. Ver Todos Locais");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    localView.criarNovoLocal();
                    break;
                case 2:
                    localView.atualizarLocal();
                    break;
                case 3:
                    localView.deletarLocal();
                    break;
                case 4:
                    System.out.println("Digite o ID do Local:");
                    Long id = Long.parseLong(scanner.nextLine());
                    localView.mostrarLocalPorId(id);
                    break;
                case 5:
                    localView.mostrarTodosLocais();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
