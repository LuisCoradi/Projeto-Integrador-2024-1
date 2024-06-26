package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Destino;
import controller.DestinoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.List;

public class DestinoTab extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nomeDestinoField;
    private JTextField descricaoDestinoField;
    private JTextField fotoDestinoField;
    private JTextField paisField;
    private JTextField regiaoField;
    private JTextField idField;
    private JTextArea detalhesTextArea;
    private JTextArea textArea;
    private DestinoController destinoController = new DestinoController();


    public DestinoTab() {
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

        JLabel lblNomeDestino = new JLabel("Nome do Destino:");
        lblNomeDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNomeDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblNomeDestino.setBounds(251, 120, 431, 27);
        atualizarPanel.add(lblNomeDestino);

        nomeDestinoField = new JTextField();
        nomeDestinoField.setBounds(251, 150, 431, 27);
        atualizarPanel.add(nomeDestinoField);
        nomeDestinoField.setColumns(10);

        JLabel lblDescricaoDestino = new JLabel("Descrição do Destino:");
        lblDescricaoDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDescricaoDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblDescricaoDestino.setBounds(251, 190, 431, 27);
        atualizarPanel.add(lblDescricaoDestino);

        descricaoDestinoField = new JTextField();
        descricaoDestinoField.setBounds(251, 220, 431, 27);
        atualizarPanel.add(descricaoDestinoField);
        descricaoDestinoField.setColumns(10);

        JLabel lblFotoDestino = new JLabel("Foto do Destino:");
        lblFotoDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFotoDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblFotoDestino.setBounds(251, 260, 431, 27);
        atualizarPanel.add(lblFotoDestino);

        fotoDestinoField = new JTextField();
        fotoDestinoField.setBounds(251, 290, 431, 27);
        atualizarPanel.add(fotoDestinoField);
        fotoDestinoField.setColumns(10);

        JLabel lblPais = new JLabel("País:");
        lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPais.setForeground(UIManager.getColor("Button.foreground"));
        lblPais.setBounds(251, 330, 431, 27);
        atualizarPanel.add(lblPais);

        paisField = new JTextField();
        paisField.setBounds(251, 360, 431, 27);
        atualizarPanel.add(paisField);
        paisField.setColumns(10);

        JLabel lblRegiao = new JLabel("Região:");
        lblRegiao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblRegiao.setForeground(UIManager.getColor("Button.foreground"));
        lblRegiao.setBounds(251, 400, 431, 27);
        atualizarPanel.add(lblRegiao);

        regiaoField = new JTextField();
        regiaoField.setBounds(251, 430, 431, 27);
        atualizarPanel.add(regiaoField);
        regiaoField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Destino");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 470, 431, 27);
        atualizarPanel.add(btnAtualizar);
        
        JPanel panel = new JPanel();
        panel.setBounds(232, 34, 471, 502);
        atualizarPanel.add(panel);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                String nomeDestino = nomeDestinoField.getText();
                String descricaoDestino = descricaoDestinoField.getText();
                String fotoDestino = fotoDestinoField.getText();
                String pais = paisField.getText();
                String regiao = regiaoField.getText();

                Destino destinoAtualizado = destinoController.updateDestino(id, nomeDestino, descricaoDestino, fotoDestino, pais, regiao);
                if (destinoAtualizado != null) {
                    JOptionPane.showMessageDialog(null, "Destino atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Destino não encontrado ou atualização falhou.");
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

        JButton btnBuscar = new JButton("Buscar Destino");
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

        JButton btnDeletar = new JButton("Deletar Destino");
        btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeletar.setBounds(315, 480, 275, 27);
        deletarPanel.add(btnDeletar);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(174, 33, 570, 486);
        deletarPanel.add(panel_1);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                Destino destino = destinoController.findDestinoById(id);
                if (destino != null) {
                    detalhesTextArea.setText("ID: " + destino.getId() + "\n" +
                                             "Nome: " + destino.getNomeDestino() + "\n" +
                                             "Descrição: " + destino.getDescricaoDestino() + "\n" +
                                             "Foto: " + destino.getFotoDestino() + "\n" +
                                             "País: " + destino.getPais() + "\n" +
                                             "Região: " + destino.getRegiao());
                } else {
                    JOptionPane.showMessageDialog(null, "Destino não encontrado.");
                    detalhesTextArea.setText("");
                }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                boolean sucesso = destinoController.deletarDestino(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Destino deletado com sucesso!");
                    detalhesTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Destino não encontrado ou exclusão falhou.");
                }
            }
        });

        // Tab de Listagem
        JPanel listarPanel = new JPanel();
        listarPanel.setLayout(null);
        listarPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Listar", null, listarPanel, null);

        JLabel lblTitulo = new JLabel("Lista de Destinos");
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

        List<Destino> destinos = destinoController.findAll();
        for (Destino destino : destinos) {
            textArea.append("ID: " + destino.getId() + ", Nome: " + destino.getNomeDestino() + ", Descrição: " + destino.getDescricaoDestino() + ", Foto: " + destino.getFotoDestino() + ", País: " + destino.getPais() + ", Região: " + destino.getRegiao() + "\n");
            textArea.append("=========================================\n");
        }
    }
}
