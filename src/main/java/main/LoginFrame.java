package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UsuarioController;
import view.MainFrame;
import view.RegisterFrame;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblEmail;
	private JTextField emailField;
	private JPanel panel_1;
	private JLabel lblSenha;
	private JTextField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 49));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 5, 0));
		
		JInternalFrame internalFrame = new JInternalFrame("Login");
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		internalFrame.setVisible(true);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		internalFrame.getContentPane().add(panel);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBounds(0, 0, 480, 100);
		panel.add(panel_2);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(20, 20, 200, 20);
		panel_2.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(20, 40, 431, 27);
		panel_2.add(emailField);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBounds(0, 100, 480, 100);
		panel.add(panel_1);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(20, 20, 200, 20);
		panel_1.add(lblSenha);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(20, 40, 431, 27);
		panel_1.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(20, 150, 100, 30);
		panel.add(loginButton);
		
		JLabel registerLabel = new JLabel("Clique para se cadastrar");
		registerLabel.setForeground(new Color(0, 64, 128));
		registerLabel.setBounds(20, 200, 200, 20);
		panel.add(registerLabel);
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailField.getText();
				String password = passwordField.getText();
				
				if (email.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				UsuarioController usuarioLista = new UsuarioController();
				
				if (usuarioLista.verificarUsuario()) {
			        new MainFrame().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Email ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				new RegisterFrame().setVisible(true);
			}
		});
	}
}
