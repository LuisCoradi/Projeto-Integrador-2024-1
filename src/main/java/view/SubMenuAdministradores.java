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
        contentPane.setLayout(new GridLayout(0, 1, 0, 25));

        JButton btnCadastrarAdministrador = new JButton("Cadastrar Administrador");
        contentPane.add(btnCadastrarAdministrador);

        JButton btnAtualizarAdministrador = new JButton("Atualizar Administrador");
        contentPane.add(btnAtualizarAdministrador);

        JButton btnDeletarAdministrador = new JButton("Deletar Administrador");
        contentPane.add(btnDeletarAdministrador);

        JButton btnVerAdministradorPorId = new JButton("Ver Administrador por ID");
        contentPane.add(btnVerAdministradorPorId);

        JButton btnVerTodosAdministradores = new JButton("Ver Todos Administradores");
        contentPane.add(btnVerTodosAdministradores);

        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainFrame().setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnVoltar);
    }
}
