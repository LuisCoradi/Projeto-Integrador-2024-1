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
        btnCadastrarAdministrador.setBounds(196, 220, 533, 67);
        btnCadastrarAdministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastrarAdministradorFrame(SubMenuAdministradores.this).setVisible(true);
                setVisible(false); // Esconde a janela atual
            }
        });
        contentPane.add(btnCadastrarAdministrador);

        JButton btnAtualizarAdministrador = new JButton("Atualizar Administrador");
        btnAtualizarAdministrador.setBounds(196, 297, 533, 67);
        btnAtualizarAdministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AtualizarAdministradorFrame(SubMenuAdministradores.this).setVisible(true);
                setVisible(false); // Esconde a janela atual
            }
        });
        contentPane.add(btnAtualizarAdministrador);

        JButton btnDeletarAdministrador = new JButton("Deletar Administrador");
        btnDeletarAdministrador.setBounds(196, 374, 533, 67);
        btnDeletarAdministrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeletarAdministradorFrame(SubMenuAdministradores.this).setVisible(true);
                setVisible(false); // Esconde a janela atual
            }
        });
        contentPane.add(btnDeletarAdministrador);

        JButton btnVerTodosAdministradores = new JButton("Ver Todos Administradores");
        btnVerTodosAdministradores.setBounds(196, 451, 533, 67);
        btnVerTodosAdministradores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdministradorList(SubMenuAdministradores.this).setVisible(true);
                setVisible(false); // Esconde a janela atual
            }
        });
        contentPane.add(btnVerTodosAdministradores);

        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.setBounds(196, 528, 533, 67);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainFrame().setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnVoltar);
    }
}
