package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.UsuarioController;
import model.entities.Usuario;

public class RegisterFrame extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private UsuarioController usuarioController = new UsuarioController();
    private JTextField descricaoField;
    Date dataAtual = new Date();//sim, date eh uma merda mas eh oq tem por hoje
   

	public RegisterFrame(JFrame parent) {
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
        senhaField.setColumns(10);

        JLabel lblDescricao = new JLabel("Se descreva:");
        lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDescricao.setForeground(UIManager.getColor("Button.foreground"));
        lblDescricao.setBounds(251, 340, 431, 27);
        contentPane.add(lblDescricao);

        descricaoField = new JTextField();
        descricaoField.setBounds(251, 370, 431, 27);
        contentPane.add(descricaoField);

        JButton btnCadastrar = new JButton("Cadastrar-se");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setBounds(251, 420, 431, 27);
        contentPane.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                String descricao = new String(descricaoField.getText());

                Usuario usuario = new Usuario(nome, email, senha, dataAtual, descricao);
                usuarioController.create(usuario);
                JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");

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
        panel.setBounds(231, 130, 470, 384);
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
