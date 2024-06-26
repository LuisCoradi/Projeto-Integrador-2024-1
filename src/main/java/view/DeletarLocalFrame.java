package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Local;
import model.services.LocalService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class DeletarLocalFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
    private JTextArea detalhesTextArea;
    private LocalService localService = new LocalService();

    public DeletarLocalFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblId.setForeground(UIManager.getColor("Button.foreground"));
        lblId.setBounds(251, 50, 431, 27);
        contentPane.add(lblId);

        idField = new JTextField();
        idField.setBounds(251, 80, 431, 27);
        contentPane.add(idField);
        idField.setColumns(10);

        JButton btnBuscar = new JButton("Buscar Local");
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

        JButton btnDeletar = new JButton("Deletar Local");
        btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeletar.setBounds(329, 480, 275, 27);
        contentPane.add(btnDeletar);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                Local local = localService.findLocalById(id);
                if (local != null) {
                    detalhesTextArea.setText("ID: " + local.getId() + "\n" +
                                             "Nome: " + local.getNomeLocal() + "\n" +
                                             "Descrição: " + local.getDescricao() + "\n" +
                                             "Latitude Y: " + local.getLatitudeY() + "\n" +
                                             "Latitude X: " + local.getLatitudeX() + "\n" +
                                             "Foto: " + local.getFotoLocal() + "\n" +
                                             "Avaliação: " + local.getAvaliacao() + "\n" +
                                             "Categoria: " + local.getCategoriaLocal());
                } else {
                    JOptionPane.showMessageDialog(null, "Local não encontrado.");
                    detalhesTextArea.setText("");
                }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                boolean sucesso = localService.deletarLocal(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Local deletado com sucesso!");
                    detalhesTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Local não encontrado ou exclusão falhou.");
                }
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(329, 520, 275, 27);
        contentPane.add(btnVoltar);
        
        JPanel panel = new JPanel();
        panel.setBounds(174, 31, 570, 555);
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
