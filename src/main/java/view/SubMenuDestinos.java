package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubMenuDestinos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SubMenuDestinos(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(7, 0, 43));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 25));

        JButton btnCadastrarDestino = new JButton("Cadastrar Destino");
        contentPane.add(btnCadastrarDestino);

        JButton btnAtualizarDestino = new JButton("Atualizar Destino");
        contentPane.add(btnAtualizarDestino);

        JButton btnDeletarDestino = new JButton("Deletar Destino");
        contentPane.add(btnDeletarDestino);

        JButton btnVerTodosDestinos = new JButton("Ver Todos Destinos");
        contentPane.add(btnVerTodosDestinos);

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
