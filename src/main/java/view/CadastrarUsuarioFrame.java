package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Usuario;
import controller.UsuarioController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.Date;

public class CadastrarUsuarioFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JTextField informacoesPerfilField;
    private UsuarioController usuarioController = new UsuarioController();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarUsuarioFrame frame = new CadastrarUsuarioFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastrarUsuarioFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNome.setForeground(UIManager.getColor("Button.foreground"));
        lblNome.setBounds(251, 130, 431, 27);
        contentPane.add(lblNome);

        nomeField = new JTextField();
        nomeField.setBounds(251, 160, 431, 27);
        contentPane.add(nomeField);
        nomeField.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEmail.setForeground(UIManager.getColor("Button.foreground"));
        lblEmail.setBounds(251, 200, 431, 27);
        contentPane.add(lblEmail);

        emailField = new JTextField();
        emailField.setBounds(251, 230, 431, 27);
        contentPane.add(emailField);
        emailField.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSenha.setForeground(UIManager.getColor("Button.foreground"));
        lblSenha.setBounds(251, 270, 431, 27);
        contentPane.add(lblSenha);

        senhaField = new JPasswordField();
        senhaField.setBounds(251, 300, 431, 27);
        contentPane.add(senhaField);

        JLabel lblInformacoesPerfil = new JLabel("Informações do Perfil:");
        lblInformacoesPerfil.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblInformacoesPerfil.setForeground(UIManager.getColor("Button.foreground"));
        lblInformacoesPerfil.setBounds(251, 340, 431, 27);
        contentPane.add(lblInformacoesPerfil);

        informacoesPerfilField = new JTextField();
        informacoesPerfilField.setBounds(251, 370, 431, 27);
        contentPane.add(informacoesPerfilField);
        informacoesPerfilField.setColumns(10);

        JButton btnCadastrar = new JButton("Cadastrar Usuário");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setBounds(251, 420, 431, 27);
        contentPane.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                String informacoesPerfil = informacoesPerfilField.getText();

                Usuario usuario = new Usuario(nome, email, senha, new Date(), informacoesPerfil);
                usuarioController.create(usuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

                if (parent != null) {
                    parent.setVisible(true);
                }
                dispose();
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(251, 460, 431, 27);
        contentPane.add(btnVoltar);
        
        JPanel panel = new JPanel();
        panel.setBounds(231, 112, 471, 404);
        contentPane.add(panel);

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (parent != null) {
                    parent.setVisible(true);
                }
                dispose();
            }
        });
    }
}
