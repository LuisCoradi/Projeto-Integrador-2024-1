package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubMenuAdministradores extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SubMenuAdministradores(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout absoluto

        JButton btnCadastrarAdministrador = new JButton("Cadastrar Administrador");
        btnCadastrarAdministrador.setBounds(251, 285, 431, 27);
        btnCadastrarAdministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarAdministradorFrame(SubMenuAdministradores.this).setVisible(true);
                setVisible(false); // Esconde a janela atual
            }
        });
        contentPane.add(btnCadastrarAdministrador);

        JButton btnGerenciarAdministrador = new JButton("Gerenciar Administradores");
        btnGerenciarAdministrador.setBounds(251, 325, 431, 27);
        btnGerenciarAdministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdministradorTab().setVisible(true);
                setVisible(false); // Esconde a janela atual
            }
        });
        contentPane.add(btnGerenciarAdministrador);

        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.setBounds(251, 365, 431, 27);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainFrame().setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnVoltar);
    }
}

