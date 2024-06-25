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

public class DeletarAdministradorFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
    private JTextArea detalhesTextArea;
    private AdministradorService administradorService = new AdministradorService();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeletarAdministradorFrame frame = new DeletarAdministradorFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DeletarAdministradorFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout absoluto

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblId.setForeground(UIManager.getColor("Button.foreground"));
        lblId.setBounds(251, 50, 431, 27);
        contentPane.add(lblId);

        idField = new JTextField();
        idField.setBounds(251, 80, 431, 27);
        contentPane.add(idField);
        idField.setColumns(10);

        JButton btnBuscar = new JButton("Buscar Administrador");
        btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBuscar.setBounds(329, 120, 275, 27);
        contentPane.add(btnBuscar);

        detalhesTextArea = new JTextArea();
        detalhesTextArea.setEditable(false);
        detalhesTextArea.setBounds(10, 160, 911, 300);
        contentPane.add(detalhesTextArea);

        JScrollPane scrollPane = new JScrollPane(detalhesTextArea);
        scrollPane.setBounds(174, 160, 570, 300);
        contentPane.add(scrollPane);

        JButton btnDeletar = new JButton("Deletar Administrador");
        btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeletar.setBounds(329, 480, 275, 27);
        contentPane.add(btnDeletar);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                Administrador administrador = administradorService.findAdministradorById(id);
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
                boolean sucesso = administradorService.deletarAdministrador(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Administrador deletado com sucesso!");
                    detalhesTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Administrador não encontrado ou exclusão falhou.");
                }
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(329, 520, 275, 27);
        contentPane.add(btnVoltar);
        
        JPanel panel = new JPanel();
        panel.setBounds(174, 37, 570, 556);
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
