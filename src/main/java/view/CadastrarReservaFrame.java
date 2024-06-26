package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.ReservaController;
import model.entities.Reserva;
import model.entities.Usuario;
import model.entities.Local;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CadastrarReservaFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField dataReservaField;
    private JTextField detalhesField;
    private JTextField usuarioIdField;
    private JTextField localIdField;
    private ReservaController reservaController = new ReservaController();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarReservaFrame frame = new CadastrarReservaFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastrarReservaFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout absoluto

        JLabel lblDataReserva = new JLabel("Data da Reserva:");
        lblDataReserva.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDataReserva.setForeground(UIManager.getColor("Button.foreground"));
        lblDataReserva.setBounds(251, 130, 431, 27);
        contentPane.add(lblDataReserva);

        dataReservaField = new JTextField();
        dataReservaField.setBounds(251, 160, 431, 27);
        contentPane.add(dataReservaField);
        dataReservaField.setColumns(10);

        JLabel lblDetalhes = new JLabel("Detalhes:");
        lblDetalhes.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDetalhes.setForeground(UIManager.getColor("Button.foreground"));
        lblDetalhes.setBounds(251, 200, 431, 27);
        contentPane.add(lblDetalhes);

        detalhesField = new JTextField();
        detalhesField.setBounds(251, 230, 431, 27);
        contentPane.add(detalhesField);
        detalhesField.setColumns(10);

        JLabel lblUsuarioId = new JLabel("ID do Usuario:");
        lblUsuarioId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUsuarioId.setForeground(UIManager.getColor("Button.foreground"));
        lblUsuarioId.setBounds(251, 270, 431, 27);
        contentPane.add(lblUsuarioId);

        usuarioIdField = new JTextField();
        usuarioIdField.setBounds(251, 300, 431, 27);
        contentPane.add(usuarioIdField);
        usuarioIdField.setColumns(10);

        JLabel lblLocalId = new JLabel("ID do Local:");
        lblLocalId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLocalId.setForeground(UIManager.getColor("Button.foreground"));
        lblLocalId.setBounds(251, 340, 431, 27);
        contentPane.add(lblLocalId);

        localIdField = new JTextField();
        localIdField.setBounds(251, 370, 431, 27);
        contentPane.add(localIdField);
        localIdField.setColumns(10);

        JButton btnCadastrar = new JButton("Cadastrar Reserva");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setBounds(251, 420, 431, 27);
        contentPane.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dataReservaText = dataReservaField.getText();
                String detalhes = detalhesField.getText();
                Long usuarioId = Long.parseLong(usuarioIdField.getText());
                Long localId = Long.parseLong(localIdField.getText());

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date dataReserva = dateFormat.parse(dataReservaText);
                    Usuario usuario = reservaController.findUsuarioById(usuarioId);
                    Local local = reservaController.findLocalById(localId);

                    if (usuario != null && local != null) {
                        Reserva reserva = new Reserva(dataReserva, detalhes, usuario, local);
                        reservaController.create(reserva);
                        JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ou Local não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato yyyy-MM-dd.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                dispose(); // Fecha a janela atual
            }
        });
    }
}
