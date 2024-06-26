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
import java.util.List;

public class LocalList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private LocalService localService = new LocalService();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LocalList frame = new LocalList(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LocalList(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout absoluto

        JLabel lblTitulo = new JLabel("Lista de Locais");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(403, 10, 126, 27);
        contentPane.add(lblTitulo);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(10, 50, 911, 600);
        contentPane.add(textArea);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 50, 911, 600);
        contentPane.add(scrollPane);

        List<Local> locais = localService.findAll();
        for (Local local : locais) {
            textArea.append("ID: " + local.getId() + ", Nome: " + local.getNomeLocal() + ", Descrição: " + local.getDescricao() + ", Latitude Y: " + local.getLatitudeY() + ", Latitude X: " + local.getLatitudeX() + ", Foto: " + local.getFotoLocal() + ", Avaliação: " + local.getAvaliacao() + ", Categoria: " + local.getCategoriaLocal() + "\n");
            textArea.append("=========================================\n");
        }

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(251, 660, 431, 27);
        contentPane.add(btnVoltar);

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

