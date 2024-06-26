package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import utils.Map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

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

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 911, 815);
        contentPane.add(tabbedPane);

        //------------------------------------------------
        // Aba de Administradores
        //------------------------------------------------
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(null);
        adminPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Admin", null, adminPanel, null);

        JButton btnCadastrarAdministrador = new JButton("Cadastrar Administrador");
        btnCadastrarAdministrador.setBounds(251, 254, 431, 58);
        btnCadastrarAdministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarAdministradorFrame(MainFrame.this).setVisible(true);
                setVisible(false); 
            }
        });
        adminPanel.add(btnCadastrarAdministrador);

        JButton btnGerenciarAdministrador = new JButton("Gerenciar Administradores");
        btnGerenciarAdministrador.setBounds(251, 325, 431, 58);
        btnGerenciarAdministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdministradorTab().setVisible(true);
                setVisible(false); 
            }
        });
        adminPanel.add(btnGerenciarAdministrador);

        //------------------------------------------------
        // Aba de Locais
        //------------------------------------------------
        JPanel localPanel = new JPanel();
        localPanel.setLayout(null);
        localPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Locais", null, localPanel, null);

        JButton btnCadastrarLocal = new JButton("Cadastrar Local");
        btnCadastrarLocal.setBounds(251, 254, 431, 58);
        btnCadastrarLocal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarLocalFrame(MainFrame.this).setVisible(true);
                setVisible(false);
            }
        });
        localPanel.add(btnCadastrarLocal);

        JButton btnGerenciarLocal = new JButton("Gerenciar Locais");
        btnGerenciarLocal.setBounds(251, 325, 431, 58);
        btnGerenciarLocal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LocalTab().setVisible(true);
                setVisible(false); 
            }
        });
        localPanel.add(btnGerenciarLocal);

        //------------------------------------------------
        // Aba de Viagens
        //------------------------------------------------
        JPanel viagemPanel = new JPanel();
        viagemPanel.setLayout(null);
        viagemPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Viagens", null, viagemPanel, null);

        JButton btnCadastrarViagem = new JButton("Cadastrar Viagem");
        btnCadastrarViagem.setBounds(251, 254, 431, 58);
        btnCadastrarViagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarViagemFrame(MainFrame.this).setVisible(true);
                setVisible(false); 
            }
        });
        viagemPanel.add(btnCadastrarViagem);

        JButton btnGerenciarViagem = new JButton("Gerenciar Viagens");
        btnGerenciarViagem.setBounds(251, 325, 431, 58);
        btnGerenciarViagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViagemTab().setVisible(true);
                setVisible(false); 
            }
        });
        viagemPanel.add(btnGerenciarViagem);

        //------------------------------------------------
        // Aba de Destinos
        //------------------------------------------------
        JPanel destinoPanel = new JPanel();
        destinoPanel.setLayout(null);
        destinoPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Destinos", null, destinoPanel, null);

        JButton btnCadastrarDestino = new JButton("Cadastrar Destino");
        btnCadastrarDestino.setBounds(251, 254, 431, 58);
        btnCadastrarDestino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarDestinoFrame(MainFrame.this).setVisible(true);
                setVisible(false); 
            }
        });
        destinoPanel.add(btnCadastrarDestino);

        JButton btnGerenciarDestino = new JButton("Gerenciar Destinos");
        btnGerenciarDestino.setBounds(251, 325, 431, 58);
        btnGerenciarDestino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DestinoTab().setVisible(true);
                setVisible(false); 
            }
        });
        destinoPanel.add(btnGerenciarDestino);

        //------------------------------------------------
        // Aba de Reservas
        //------------------------------------------------
        JPanel reservaPanel = new JPanel();
        reservaPanel.setLayout(null);
        reservaPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Reservas", null, reservaPanel, null);

        JButton btnCadastrarReserva = new JButton("Cadastrar Reserva");
        btnCadastrarReserva.setBounds(251, 254, 431, 58);
        btnCadastrarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarReservaFrame(MainFrame.this).setVisible(true);
                setVisible(false); 
            }
        });
        reservaPanel.add(btnCadastrarReserva);

        JButton btnGerenciarReserva = new JButton("Gerenciar Reservas");
        btnGerenciarReserva.setBounds(251, 325, 431, 58);
        btnGerenciarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ReservaTab().setVisible(true);
                setVisible(false); 
            }
        });
        reservaPanel.add(btnGerenciarReserva);

        //------------------------------------------------
        // Aba de Mapa
        //------------------------------------------------
        JPanel mapaPanel = new JPanel();
        mapaPanel.setLayout(null);
        mapaPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Mapa", null, mapaPanel, null);

        JButton btnAbrirMapa = new JButton("Abrir Mapa");
        btnAbrirMapa.setBounds(251, 294, 431, 58);
        btnAbrirMapa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Map.main(new String[0]); 
            }
        });
        mapaPanel.add(btnAbrirMapa);
    }
}

