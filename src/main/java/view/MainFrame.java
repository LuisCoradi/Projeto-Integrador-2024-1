
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;

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
        contentPane.setLayout(new GridLayout(0, 1, 0, 25));

        JButton btnGerenciarUsuarios = new JButton("Gerenciar Usuarios");
        btnGerenciarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubMenuUsuario(MainFrame.this).setVisible(true);
                setVisible(false);
            }
        });
        contentPane.add(btnGerenciarUsuarios);

        JButton btnGerenciarLocais = new JButton("Gerenciar Locais");
        btnGerenciarLocais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubMenuLocais(MainFrame.this).setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnGerenciarLocais);

        JButton btnGerenciarViagens = new JButton("Gerenciar Viagens");
        btnGerenciarViagens.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubMenuViagens(MainFrame.this).setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnGerenciarViagens);

        JButton btnGerenciarDestinos = new JButton("Gerenciar Destinos");
        btnGerenciarDestinos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubMenuDestinos(MainFrame.this).setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnGerenciarDestinos);


        JButton btnGerenciarAdministradores = new JButton("Gerenciar Administradores");
        btnGerenciarAdministradores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubMenuAdministradores(MainFrame.this).setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnGerenciarAdministradores);

        JButton btnGerenciarReservas = new JButton("Gerenciar Reservas");
        btnGerenciarReservas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubMenuReservas(MainFrame.this).setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnGerenciarReservas);
    }
}