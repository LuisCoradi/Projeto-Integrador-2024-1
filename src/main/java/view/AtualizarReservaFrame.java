package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.ReservaController;
import model.entities.Reserva;
import model.entities.Local;
import model.entities.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AtualizarReservaFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
    private JTextField dataReservaField;
    private JTextField detalhesField;
    private JTextField usuarioIdField;
    private JTextField localIdField;
    private ReservaController reservaController = new ReservaController();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AtualizarReservaFrame frame = new AtualizarReservaFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AtualizarReservaFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setForeground(Color.BLACK);
        lblId.setBounds(251, 114, 431, 27);
        contentPane.add(lblId);

        idField = new JTextField();
        idField.setBounds(251, 144, 431, 27);
        contentPane.add(idField);
        idField.setColumns(10);

        JLabel lblDataReserva = new JLabel("Data da Reserva (yyyy-MM-dd):");
        lblDataReserva.setForeground(Color.BLACK);
        lblDataReserva.setBounds(251, 194, 431, 27);
        contentPane.add(lblDataReserva);

        dataReservaField = new JTextField();
        dataReservaField.setBounds(251, 224, 431, 27);
        contentPane.add(dataReservaField);
        dataReservaField.setColumns(10);

        JLabel lblDetalhes = new JLabel("Detalhes:");
        lblDetalhes.setForeground(Color.BLACK);
        lblDetalhes.setBounds(251, 264, 431, 27);
        contentPane.add(lblDetalhes);

        detalhesField = new JTextField();
        detalhesField.setBounds(251, 294, 431, 27);
        contentPane.add(detalhesField);
        detalhesField.setColumns(10);

        JLabel lblUsuarioId = new JLabel("ID do Usuário:");
        lblUsuarioId.setForeground(Color.BLACK);
        lblUsuarioId.setBounds(251, 334, 431, 27);
        contentPane.add(lblUsuarioId);

        usuarioIdField = new JTextField();
        usuarioIdField.setBounds(251, 364, 431, 27);
        contentPane.add(usuarioIdField);
        usuarioIdField.setColumns(10);

        JLabel lblLocalId = new JLabel("ID do Local:");
        lblLocalId.setForeground(Color.BLACK);
        lblLocalId.setBounds(251, 404, 431, 27);
        contentPane.add(lblLocalId);

        localIdField = new JTextField();
        localIdField.setBounds(251, 434, 431, 27);
        contentPane.add(localIdField);
        localIdField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Reserva");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 484, 431, 27);
        contentPane.add(btnAtualizar);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                String dataReservaText = dataReservaField.getText();
                String detalhes = detalhesField.getText();
                Long usuarioId = Long.parseLong(usuarioIdField.getText());
                Long localId = Long.parseLong(localIdField.getText());

                try {
                    Date dataReserva = dateFormat.parse(dataReservaText);
                    Usuario usuario = reservaController.findUsuarioById(usuarioId);
                    Local local = reservaController.findLocalById(localId);

                    Reserva reservaAtualizada = reservaController.updateReserva(id, dataReserva, detalhes, usuario, local);
                    if (reservaAtualizada != null) {
                        JOptionPane.showMessageDialog(null, "Reserva atualizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Reserva não encontrada ou atualização falhou.");
                    }

                    if (parent != null) {
                        parent.setVisible(true);
                    }
                    dispose();
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira uma data válida no formato yyyy-MM-dd.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                dispose();
            }
        });
    }
}
