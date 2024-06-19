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


public class SubMenuUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SubMenuUsuario(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 25));

        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuario");
        contentPane.add(btnCadastrarUsuario);

        JButton btnAtualizarUsuario = new JButton("Atualizar Usuario");
        contentPane.add(btnAtualizarUsuario);

        JButton btnDeletarUsuario = new JButton("Deletar Usuario");
        contentPane.add(btnDeletarUsuario);

        JButton btnVerUsuarioPorId = new JButton("Ver Usuario por ID");
        contentPane.add(btnVerUsuarioPorId);

        JButton btnVerTodosUsuarios = new JButton("Ver Todos Usuarios");
        contentPane.add(btnVerTodosUsuarios);

        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVoltar);
    }
}