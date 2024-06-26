package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        // Aba de Administradores
        JPanel adminPanel = createTabPanel("Cadastrar Administrador", "Gerenciar Administradores", 
                                            CadastrarAdministradorFrame.class, AdministradorTab.class);
        tabbedPane.addTab("Admin", null, adminPanel, null);

        // Aba de Locais
        JPanel localPanel = createTabPanel("Cadastrar Local", "Gerenciar Locais", 
                                            CadastrarLocalFrame.class, LocalTab.class);
        tabbedPane.addTab("Locais", null, localPanel, null);

        // Aba de Viagens
        JPanel viagemPanel = createTabPanel("Cadastrar Viagem", "Gerenciar Viagens", 
                                             CadastrarViagemFrame.class, ViagemTab.class);
        tabbedPane.addTab("Viagens", null, viagemPanel, null);

        // Aba de Destinos
        JPanel destinoPanel = createTabPanel("Cadastrar Destino", "Gerenciar Destinos", 
                                              CadastrarDestinoFrame.class, DestinoTab.class);
        tabbedPane.addTab("Destinos", null, destinoPanel, null);

        // Aba de Reservas
        JPanel reservaPanel = createTabPanel("Cadastrar Reserva", "Gerenciar Reservas", 
                                              CadastrarReservaFrame.class, ReservaTab.class);
        tabbedPane.addTab("Reservas", null, reservaPanel, null);
    }

    private JPanel createTabPanel(String cadastrarText, String gerenciarText, 
                                  Class<? extends JFrame> cadastrarFrameClass, 
                                  Class<? extends JFrame> gerenciarFrameClass) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 49));
        panel.setBorder(new EmptyBorder(200, 200, 200, 200));
        panel.setLayout(null);

        JButton btnCadastrar = new JButton(cadastrarText);
        btnCadastrar.setBounds(66, 159, 395, 48);
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame frame = cadastrarFrameClass.getDeclaredConstructor(JFrame.class).newInstance(MainFrame.this);
                    frame.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnCadastrar);

        JButton btnGerenciar = new JButton(gerenciarText);
        btnGerenciar.setBounds(66, 234, 395, 48);
        btnGerenciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame frame = gerenciarFrameClass.getDeclaredConstructor().newInstance();
                    frame.setVisible(true);
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnGerenciar);

        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
