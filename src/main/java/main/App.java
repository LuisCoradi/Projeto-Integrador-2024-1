package main;

import view.LocalView;
import view.MainFrame;
import view.UsuarioView;
import view.AdministradorView;
import view.DestinoView;
import view.ReservaView;
import view.ViagemView;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static LocalView localView = new LocalView();
    private static UsuarioView usuarioView = new UsuarioView();
    private static AdministradorView administradorView = new AdministradorView();
    private static DestinoView destinoView = new DestinoView();
    private static ReservaView reservaView = new ReservaView();
    private static ViagemView viagemView = new ViagemView();

    public static void main(String[] args) {
        while (true) {
            MainFrame mainMenu = new MainFrame();
            mainMenu.setVisible(true);
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
                case 4:
                    showDestinoMenu();
                    break;
                case 5:
                    showReservaMenu();
                    break;
                case 6:
                    showViagemMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void showMainMenu() {
        
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

    private static void showDestinoMenu() {
        while (true) {
            System.out.println("=== Menu Destinos ===");
            System.out.println("1. Cadastrar Destino");
            System.out.println("2. Atualizar Destino");
            System.out.println("3. Deletar Destino");
            System.out.println("4. Ver Destino por ID");
            System.out.println("5. Ver Todos Destinos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    destinoView.criarNovoDestino();
                    break;
                case 2:
                    destinoView.atualizarDestino();
                    break;
                case 3:
                    destinoView.deletarDestino();
                    break;
                case 4:
                    System.out.println("Digite o ID do Destino:");
                    Long id = Long.parseLong(scanner.nextLine());
                    destinoView.mostrarDestinoPorId(id);
                    break;
                case 5:
                    destinoView.mostrarTodosDestinos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void showReservaMenu() {
        while (true) {
            System.out.println("=== Menu Reservas ===");
            System.out.println("1. Cadastrar Reserva");
            System.out.println("2. Atualizar Reserva");
            System.out.println("3. Deletar Reserva");
            System.out.println("4. Ver Reserva por ID");
            System.out.println("5. Ver Todas Reservas");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    reservaView.criarNovaReserva();
                    break;
                case 2:
                    reservaView.atualizarReserva();
                    break;
                case 3:
                    reservaView.deletarReserva();
                    break;
                case 4:
                    System.out.println("Digite o ID da Reserva:");
                    Long id = Long.parseLong(scanner.nextLine());
                    reservaView.mostrarReservaPorId(id);
                    break;
                case 5:
                    reservaView.mostrarTodasReservas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void showViagemMenu() {
        while (true) {
            System.out.println("=== Menu Viagens ===");
            System.out.println("1. Cadastrar Viagem");
            System.out.println("2. Atualizar Viagem");
            System.out.println("3. Deletar Viagem");
            System.out.println("4. Ver Viagem por ID");
            System.out.println("5. Ver Todas Viagens");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    viagemView.criarNovaViagem();
                    break;
                case 2:
                    viagemView.atualizarViagem();
                    break;
                case 3:
                    viagemView.deletarViagem();
                    break;
                case 4:
                    System.out.println("Digite o ID da Viagem:");
                    Long id = Long.parseLong(scanner.nextLine());
                    viagemView.mostrarViagemPorId(id);
                    break;
                case 5:
                    viagemView.mostrarTodasViagens();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
