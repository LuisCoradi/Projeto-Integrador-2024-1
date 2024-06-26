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
import java.util.List;
import java.text.SimpleDateFormat;

public class ReservaTab extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
    private JTextField dataReservaField;
    private JTextField detalhesField;
    private JTextField usuarioIdField;
    private JTextField localIdField;
    private JTextArea detalhesTextArea;
    private JTextArea textArea;
    private ReservaController reservaController = new ReservaController();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReservaTab frame = new ReservaTab();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ReservaTab() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout absoluto

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

        JLabel lblDataReserva = new JLabel("Data da Reserva:");
        lblDataReserva.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDataReserva.setForeground(UIManager.getColor("Button.foreground"));
        lblDataReserva.setBounds(251, 120, 431, 27);
        atualizarPanel.add(lblDataReserva);

        dataReservaField = new JTextField();
        dataReservaField.setBounds(251, 150, 431, 27);
        atualizarPanel.add(dataReservaField);
        dataReservaField.setColumns(10);

        JLabel lblDetalhes = new JLabel("Detalhes:");
        lblDetalhes.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDetalhes.setForeground(UIManager.getColor("Button.foreground"));
        lblDetalhes.setBounds(251, 190, 431, 27);
        atualizarPanel.add(lblDetalhes);

        detalhesField = new JTextField();
        detalhesField.setBounds(251, 220, 431, 27);
        atualizarPanel.add(detalhesField);
        detalhesField.setColumns(10);

        JLabel lblUsuarioId = new JLabel("ID do Usuario:");
        lblUsuarioId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUsuarioId.setForeground(UIManager.getColor("Button.foreground"));
        lblUsuarioId.setBounds(251, 260, 431, 27);
        atualizarPanel.add(lblUsuarioId);

        usuarioIdField = new JTextField();
        usuarioIdField.setBounds(251, 290, 431, 27);
        atualizarPanel.add(usuarioIdField);
        usuarioIdField.setColumns(10);

        JLabel lblLocalId = new JLabel("ID do Local:");
        lblLocalId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLocalId.setForeground(UIManager.getColor("Button.foreground"));
        lblLocalId.setBounds(251, 330, 431, 27);
        atualizarPanel.add(lblLocalId);

        localIdField = new JTextField();
        localIdField.setBounds(251, 360, 431, 27);
        atualizarPanel.add(localIdField);
        localIdField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Reserva");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 400, 431, 27);
        atualizarPanel.add(btnAtualizar);
        
        JPanel panel = new JPanel();
        panel.setBounds(228, 35, 471, 404);
        atualizarPanel.add(panel);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
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
                        Reserva reservaAtualizada = reservaController.updateReserva(id, dataReserva, detalhes, usuario, local);
                        if (reservaAtualizada != null) {
                            JOptionPane.showMessageDialog(null, "Reserva atualizada com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Reserva não encontrada ou atualização falhou.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ou Local não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar reserva.", "Erro", JOptionPane.ERROR_MESSAGE);
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

        JButton btnBuscar = new JButton("Buscar Reserva");
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

        JButton btnDeletar = new JButton("Deletar Reserva");
        btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeletar.setBounds(315, 480, 275, 27);
        deletarPanel.add(btnDeletar);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(174, 44, 570, 478);
        deletarPanel.add(panel_1);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                Reserva reserva = reservaController.findReservaById(id);
                if (reserva != null) {
                    detalhesTextArea.setText("ID: " + reserva.getId() + "\n" +
                                             "Data Reserva: " + reserva.getDataReserva() + "\n" +
                                             "Detalhes: " + reserva.getDetalhes() + "\n" +
                                             "Usuario: " + reserva.getUsuario().getNome() + "\n" +
                                             "Local: " + reserva.getLocal().getNomeLocal());
                } else {
                    JOptionPane.showMessageDialog(null, "Reserva não encontrada.");
                    detalhesTextArea.setText("");
                }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                boolean sucesso = reservaController.deletarReserva(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Reserva deletada com sucesso!");
                    detalhesTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Reserva não encontrada ou exclusão falhou.");
                }
            }
        });

        // Tab de Listagem
        JPanel listarPanel = new JPanel();
        listarPanel.setLayout(null);
        listarPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Listar", null, listarPanel, null);

        JLabel lblTitulo = new JLabel("Lista de Reservas");
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

        List<Reserva> reservas = reservaController.findAll();
        for (Reserva reserva : reservas) {
            textArea.append("ID: " + reserva.getId() + ", Data Reserva: " + reserva.getDataReserva() + ", Detalhes: " + reserva.getDetalhes() + ", Usuario: " + reserva.getUsuario().getNome() + ", Local: " + reserva.getLocal().getNomeLocal() + "\n");
            textArea.append("=========================================\n");
        }
    }
}
