package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubMenuViagens extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SubMenuViagens(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 25));

        JButton btnCadastrarViagem = new JButton("Cadastrar Viagem");
        contentPane.add(btnCadastrarViagem);

        JButton btnAtualizarViagem = new JButton("Atualizar Viagem");
        contentPane.add(btnAtualizarViagem);

        JButton btnDeletarViagem = new JButton("Deletar Viagem");
        contentPane.add(btnDeletarViagem);

        JButton btnVerViagemPorId = new JButton("Ver Viagem por ID");
        contentPane.add(btnVerViagemPorId);

        JButton btnVerTodasViagens = new JButton("Ver Todas Viagens");
        contentPane.add(btnVerTodasViagens);

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