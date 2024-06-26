package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Viagem;
import controller.ViagemController;
import model.entities.Destino;
import model.entities.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.Date;
import java.util.List;

public class ViagemTab extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
    private JTextField dataInicioField;
    private JTextField dataTerminoField;
    private JTextField statusViagemField;
    private JTextField orcamentoField;
    private JTextField avaliacaoViagemField;
    private JTextField usuarioIdField;
    private JTextField destinoIdField;
    private JTextArea detalhesTextArea;
    private JTextArea textArea;
    private ViagemController viagemController = new ViagemController();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViagemTab frame = new ViagemTab();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViagemTab() {
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

        JButton btnBuscar = new JButton("Buscar Viagem");
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

        JButton btnDeletar = new JButton("Deletar Viagem");
        btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeletar.setBounds(315, 480, 275, 27);
        deletarPanel.add(btnDeletar);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(174, 39, 570, 499);
        deletarPanel.add(panel_1);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(idField.getText());
                    Viagem viagem = viagemController.findViagemById(id);
                    if (viagem != null) {
                        detalhesTextArea.setText("ID: " + viagem.getId() + "\n" +
                                                 "Data Início: " + viagem.getDataInicio() + "\n" +
                                                 "Data Término: " + viagem.getDataTermino() + "\n" +
                                                 "Status Viagem: " + viagem.getStatusViagem() + "\n" +
                                                 "Orçamento: " + viagem.getOrcamento() + "\n" +
                                                 "Avaliação Viagem: " + viagem.getAvaliacaoViagem() + "\n" +
                                                 "ID Usuário: " + viagem.getUsuario().getId() + "\n" +
                                                 "ID Destino: " + viagem.getDestino().getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Viagem não encontrada.");
                        detalhesTextArea.setText("");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar a viagem. Verifique o ID inserido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(idField.getText());
                    boolean sucesso = viagemController.deletarViagem(id);
                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Viagem deletada com sucesso!");
                        detalhesTextArea.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Viagem não encontrada ou exclusão falhou.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar a viagem. Verifique o ID inserido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Tab de Listagem
        JPanel listarPanel = new JPanel();
        listarPanel.setLayout(null);
        listarPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Listar", null, listarPanel, null);

        JLabel lblTitulo = new JLabel("Lista de Viagens");
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

        List<Viagem> viagens = viagemController.findAll();
        for (Viagem viagem : viagens) {
            textArea.append("ID: " + viagem.getId() + ", Data Início: " + viagem.getDataInicio() + ", Data Término: " + viagem.getDataTermino() + ", Status Viagem: " + viagem.getStatusViagem() + ", Orçamento: " + viagem.getOrcamento() + ", Avaliação Viagem: " + viagem.getAvaliacaoViagem() + ", ID Usuário: " + viagem.getUsuario().getId() + ", ID Destino: " + viagem.getDestino().getId() + "\n");
            textArea.append("=========================================\n");
        }
    }
}
