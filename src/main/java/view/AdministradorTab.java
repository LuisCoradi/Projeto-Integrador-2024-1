package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Administrador;
import controller.AdministradorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.List;

public class AdministradorTab extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JTextField nivelPermissaoField;
    private JTextField idField;
    private JTextArea detalhesTextArea;
    private JTextArea textArea;
    private AdministradorController administradorController = new AdministradorController();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdministradorTab frame = new AdministradorTab();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdministradorTab() {
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
        
        // --------------------------------------------------------
        // Tab de Deleção
        // --------------------------------------------------------
        
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

        JButton btnBuscar = new JButton("Buscar Administrador");
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

        JButton btnDeletar = new JButton("Deletar Administrador");
        btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeletar.setBounds(315, 480, 275, 47);
        deletarPanel.add(btnDeletar);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(174, 37, 568, 517);
        deletarPanel.add(panel_1);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                Administrador administrador = administradorController.findAdministradorById(id);
                if (administrador != null) {
                    detalhesTextArea.setText("ID: " + administrador.getId() + "\n" +
                                             "Nome: " + administrador.getNome() + "\n" +
                                             "Email: " + administrador.getEmail() + "\n" +
                                             "Nível de Permissão: " + administrador.getNivelPermissao());
                } else {
                    JOptionPane.showMessageDialog(null, "Administrador não encontrado.");
                    detalhesTextArea.setText("");
                }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                Administrador administrador = administradorController.findAdministradorById(id);
                if (administrador == null) {
                    JOptionPane.showMessageDialog(null, "Administrador não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!administrador.getLocais().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não é possível deletar o administrador porque ele possui locais associados.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean sucesso = administradorController.deletarAdministrador(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Administrador deletado com sucesso!");
                    detalhesTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Administrador não encontrado ou exclusão falhou.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // --------------------------------------------------------
        // Tab de Listagem
        // --------------------------------------------------------
        JPanel listarPanel = new JPanel();
        listarPanel.setLayout(null);
        listarPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Listar", null, listarPanel, null);

        JLabel lblTitulo = new JLabel("Lista de Administradores");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(361, 10, 210, 27);
        listarPanel.add(lblTitulo);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(1, 1, 872, 598);
        listarPanel.add(textArea);

        JScrollPane scrollPaneList = new JScrollPane(textArea);
        scrollPaneList.setBounds(10, 50, 911, 600);
        listarPanel.add(scrollPaneList);

        List<Administrador> administradores = administradorController.findAll();
        for (Administrador administrador : administradores) {
            textArea.append("ID: " + administrador.getId() + ", Nome: " + administrador.getNome() + ", Email: " + administrador.getEmail() + ", Nível de Permissão: " + administrador.getNivelPermissao() + "\n");
            textArea.append("=========================================\n");
        }
    }
}
