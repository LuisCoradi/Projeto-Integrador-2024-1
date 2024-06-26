package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Local;
import controller.LocalController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.List;

public class LocalTab extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
    private JTextField nomeField;
    private JTextField descricaoField;
    private JTextField latitudeYField;
    private JTextField latitudeXField;
    private JTextField fotoLocalField;
    private JTextField avaliacaoField;
    private JTextField categoriaLocalField;
    private JTextArea detalhesTextArea;
    private JTextArea textArea;
    private LocalController localController = new LocalController();

    public LocalTab() {
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

        //-------------------------------------------------------------------
        // Tab de Deleção
        //-------------------------------------------------------------------
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

        JButton btnBuscar = new JButton("Buscar Local");
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

        JButton btnDeletar = new JButton("Deletar Local");
        btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeletar.setBounds(315, 480, 275, 27);
        deletarPanel.add(btnDeletar);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(174, 33, 570, 490);
        deletarPanel.add(panel_1);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                Local local = localController.findLocalById(id);
                if (local != null) {
                    detalhesTextArea.setText("ID: " + local.getId() + "\n" +
                                             "Nome Local: " + local.getNomeLocal() + "\n" +
                                             "Descrição: " + local.getDescricao() + "\n" +
                                             "Latitude Y: " + local.getLatitudeY() + "\n" +
                                             "Latitude X: " + local.getLatitudeX() + "\n" +
                                             "Foto Local: " + local.getFotoLocal() + "\n" +
                                             "Avaliação: " + local.getAvaliacao() + "\n" +
                                             "Categoria Local: " + local.getCategoriaLocal());
                } else {
                    JOptionPane.showMessageDialog(null, "Local não encontrado.");
                    detalhesTextArea.setText("");
                }
            }
        });

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                boolean sucesso = localController.deletarLocal(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Local deletado com sucesso!");
                    detalhesTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Local não encontrado ou exclusão falhou.");
                }
            }
        });

        //-------------------------------------------------------------------
        // Tab de Listagem
        //-------------------------------------------------------------------
        JPanel listarPanel = new JPanel();
        listarPanel.setLayout(null);
        listarPanel.setBackground(new Color(0, 0, 49));
        tabbedPane.addTab("Listar", null, listarPanel, null);

        JLabel lblTitulo = new JLabel("Lista de Locais");
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

        List<Local> locais = localController.findAll();
        for (Local local : locais) {
            textArea.append("ID: " + local.getId() + ", Nome Local: " + local.getNomeLocal() + ", Descrição: " + local.getDescricao() + ", Latitude Y: " + local.getLatitudeY() + ", Latitude X: " + local.getLatitudeX() + ", Foto Local: " + local.getFotoLocal() + ", Avaliação: " + local.getAvaliacao() + ", Categoria Local: " + local.getCategoriaLocal() + "\n");
            textArea.append("=========================================\n");
        }
    }
}

