package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubMenuLocais extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SubMenuLocais(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 25));

        JButton btnCadastrarLocal = new JButton("Cadastrar Local");
        contentPane.add(btnCadastrarLocal);

        JButton btnAtualizarLocal = new JButton("Atualizar Local");
        contentPane.add(btnAtualizarLocal);

        JButton btnDeletarLocal = new JButton("Deletar Local");
        contentPane.add(btnDeletarLocal);

        JButton btnVerLocalPorId = new JButton("Ver Local por ID");
        contentPane.add(btnVerLocalPorId);

        JButton btnVerTodosLocais = new JButton("Ver Todos Locais");
        contentPane.add(btnVerTodosLocais);

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
