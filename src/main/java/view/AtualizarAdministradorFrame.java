package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Administrador;
import model.services.AdministradorService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.List;

public class AtualizarAdministradorFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JTextField nivelPermissaoField;
    private AdministradorService administradorService = new AdministradorService();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AtualizarAdministradorFrame frame = new AtualizarAdministradorFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AtualizarAdministradorFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout absoluto

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblId.setForeground(UIManager.getColor("Button.foreground"));
        lblId.setBounds(251, 114, 431, 27);
        contentPane.add(lblId);

        idField = new JTextField();
        idField.setBounds(251, 144, 431, 27);
        contentPane.add(idField);
        idField.setColumns(10);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNome.setForeground(UIManager.getColor("Button.foreground"));
        lblNome.setBounds(251, 194, 431, 27);
        contentPane.add(lblNome);

        nomeField = new JTextField();
        nomeField.setBounds(251, 224, 431, 27);
        contentPane.add(nomeField);
        nomeField.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEmail.setForeground(UIManager.getColor("Button.foreground"));
        lblEmail.setBounds(251, 264, 431, 27);
        contentPane.add(lblEmail);

        emailField = new JTextField();
        emailField.setBounds(251, 294, 431, 27);
        contentPane.add(emailField);
        emailField.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSenha.setForeground(UIManager.getColor("Button.foreground"));
        lblSenha.setBounds(251, 334, 431, 27);
        contentPane.add(lblSenha);

        senhaField = new JPasswordField();
        senhaField.setBounds(251, 364, 431, 27);
        contentPane.add(senhaField);

        JLabel lblNivelPermissao = new JLabel("Nível de Permissão:");
        lblNivelPermissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNivelPermissao.setForeground(UIManager.getColor("Button.foreground"));
        lblNivelPermissao.setBounds(251, 404, 431, 27);
        contentPane.add(lblNivelPermissao);

        nivelPermissaoField = new JTextField();
        nivelPermissaoField.setBounds(251, 434, 431, 27);
        contentPane.add(nivelPermissaoField);
        nivelPermissaoField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Administrador");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 484, 431, 27);
        contentPane.add(btnAtualizar);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                int nivelPermissao = Integer.parseInt(nivelPermissaoField.getText());

                Administrador administradorAtualizado = administradorService.updateAdministrador(id, nome, email, senha, nivelPermissao);
                if (administradorAtualizado != null) {
                    JOptionPane.showMessageDialog(null, "Administrador atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Administrador não encontrado ou atualização falhou.");
                }

                if (parent != null) {
                    parent.setVisible(true);
                }
                dispose(); // Fecha a janela atual
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(251, 524, 431, 27);
        contentPane.add(btnVoltar);
        
        JPanel panel = new JPanel();
        panel.setBounds(231, 114, 470, 459);
        contentPane.add(panel);

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (parent != null) {
                    parent.setVisible(true);
                }
                dispose(); // Fecha a janela atual
            }
        });
    }
}
