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
import java.util.List;

public class UsuarioTab extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JTextField informacoesPerfilField;
    private JTextArea detalhesTextArea;
    private JTextArea textArea;
    private UsuarioController usuarioController = new UsuarioController();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UsuarioTab frame = new UsuarioTab();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UsuarioTab() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 911, 815);
        contentPane.add(tabbedPane);

        // Tab de Atualização
        JPanel atualizarPanel = new JPanel();
        atualizarPanel.setLayout(null);
        atualizarPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Atualizar", null, atualizarPanel, null);

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblId.setForeground(UIManager.getColor("Button.foreground"));
        lblId.setBounds(251, 50, 431, 27);
        atualizarPanel.add(lblId);

        idField = new JTextField();
        idField.setBounds(251, 80, 431, 27);
        atualizarPanel.add(idField);
        idField.setColumns(10);

        JLabel lblNomeUpdate = new JLabel("Nome:");
        lblNomeUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNomeUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblNomeUpdate.setBounds(251, 120, 431, 27);
        atualizarPanel.add(lblNomeUpdate);

        nomeField = new JTextField();
        nomeField.setBounds(251, 150, 431, 27);
        atualizarPanel.add(nomeField);
        nomeField.setColumns(10);

        JLabel lblEmailUpdate = new JLabel("Email:");
        lblEmailUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEmailUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblEmailUpdate.setBounds(251, 190, 431, 27);
        atualizarPanel.add(lblEmailUpdate);

        emailField = new JTextField();
        emailField.setBounds(251, 220, 431, 27);
        atualizarPanel.add(emailField);
        emailField.setColumns(10);

        JLabel lblSenhaUpdate = new JLabel("Senha:");
        lblSenhaUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSenhaUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblSenhaUpdate.setBounds(251, 260, 431, 27);
        atualizarPanel.add(lblSenhaUpdate);

        senhaField = new JPasswordField();
        senhaField.setBounds(251, 290, 431, 27);
        atualizarPanel.add(senhaField);

        JLabel lblInformacoesPerfilUpdate = new JLabel("Informações do Perfil:");
        lblInformacoesPerfilUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblInformacoesPerfilUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblInformacoesPerfilUpdate.setBounds(251, 330, 431, 27);
        atualizarPanel.add(lblInformacoesPerfilUpdate);

        informacoesPerfilField = new JTextField();
        informacoesPerfilField.setBounds(251, 360, 431, 27);
        atualizarPanel.add(informacoesPerfilField);
        informacoesPerfilField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Usuário");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 400, 431, 27);
        atualizarPanel.add(btnAtualizar);
        
        JPanel panel = new JPanel();
        panel.setBounds(230, 25, 471, 413);
        atualizarPanel.add(panel);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                String informacoesPerfil = informacoesPerfilField.getText();

                Usuario usuarioAtualizado = usuarioController.updateUsuario(id, nome, email, senha, informacoesPerfil);
                if (usuarioAtualizado != null) {
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado ou atualização falhou.");
                }
            }
        });

        // Tab de Deleção
        JPanel deletarPanel = new JPanel();
        deletarPanel.setLayout(null);
        deletarPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Deletar", null, deletarPanel, null);

        JLabel lblIdDelete = new JLabel("ID:");
        lblIdDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIdDelete.setForeground(UIManager.getColor("Button.foreground"));
        lblIdDelete.setBounds(251, 50, 431, 27);
        deletarPanel.add(lblIdDelete);

        idField = new JTextField();
        idField.setBounds(237, 80, 431, 27);
        deletarPanel.add(idField);
        idField.setColumns(10);

        JButton btnBuscar = new JButton("Buscar Usuário");
        btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBuscar.setBounds(315, 120, 275, 27);
        deletarPanel.add(btnBuscar);

        detalhesTextArea = new JTextArea();
        detalhesTextArea.setEditable(false);
        detalhesTextArea.setBounds(169, 0, 911, 300);
        deletarPanel.add(detalhesTextArea);

        JScrollPane scrollPaneDelete = new JScrollPane(detalhesTextArea);
        scrollPaneDelete.setBounds(174, 160, 570, 300);
        deletarPanel.add(scrollPaneDelete);

        JButton btnDeletar = new JButton("Deletar Usuário");
        btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeletar.setBounds(315, 480, 275, 27);
        deletarPanel.add(btnDeletar);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(174, 35, 570, 493);
        deletarPanel.add(panel_1);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                Usuario usuario = usuarioController.findUsuarioById(id);
                if (usuario != null) {
                    detalhesTextArea.setText("ID: " + usuario.getId() + "\n" +
                                             "Nome: " + usuario.getNome() + "\n" +
                                             "Email: " + usuario.getEmail() + "\n" +
                                             "Informações do Perfil: " + usuario.getInformacoesPerfil());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                    detalhesTextArea.setText("");
                }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                boolean sucesso = usuarioController.deletarUsuario(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
                    detalhesTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado ou exclusão falhou.");
                }
            }
        });

        // Tab de Listagem
        JPanel listarPanel = new JPanel();
        listarPanel.setLayout(null);
        listarPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Listar", null, listarPanel, null);

        JLabel lblTitulo = new JLabel("Lista de Usuários");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(361, 10, 210, 27);
        listarPanel.add(lblTitulo);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(10, 50, 911, 600);
        listarPanel.add(textArea);

        JScrollPane scrollPaneList = new JScrollPane(textArea);
        scrollPaneList.setBounds(10, 50, 911, 600);
        listarPanel.add(scrollPaneList);

        List<Usuario> usuarios = usuarioController.findAll();
        for (Usuario usuario : usuarios) {
            textArea.append("ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail() + ", Informações do Perfil: " + usuario.getInformacoesPerfil() + "\n");
            textArea.append("=========================================\n");
        }
    }
}
