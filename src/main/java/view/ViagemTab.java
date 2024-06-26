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

        //-------------------------------------------------------------------
        // Tab de Atualização
        //-------------------------------------------------------------------
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

        JLabel lblDataInicioUpdate = new JLabel("Data Início:");
        lblDataInicioUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDataInicioUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblDataInicioUpdate.setBounds(251, 120, 431, 27);
        atualizarPanel.add(lblDataInicioUpdate);

        dataInicioField = new JTextField();
        dataInicioField.setBounds(251, 150, 431, 27);
        atualizarPanel.add(dataInicioField);
        dataInicioField.setColumns(10);

        JLabel lblDataTerminoUpdate = new JLabel("Data Término:");
        lblDataTerminoUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDataTerminoUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblDataTerminoUpdate.setBounds(251, 190, 431, 27);
        atualizarPanel.add(lblDataTerminoUpdate);

        dataTerminoField = new JTextField();
        dataTerminoField.setBounds(251, 220, 431, 27);
        atualizarPanel.add(dataTerminoField);
        dataTerminoField.setColumns(10);

        JLabel lblStatusViagemUpdate = new JLabel("Status Viagem:");
        lblStatusViagemUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStatusViagemUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblStatusViagemUpdate.setBounds(251, 260, 431, 27);
        atualizarPanel.add(lblStatusViagemUpdate);

        statusViagemField = new JTextField();
        statusViagemField.setBounds(251, 290, 431, 27);
        atualizarPanel.add(statusViagemField);
        statusViagemField.setColumns(10);

        JLabel lblOrcamentoUpdate = new JLabel("Orçamento:");
        lblOrcamentoUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblOrcamentoUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblOrcamentoUpdate.setBounds(251, 330, 431, 27);
        atualizarPanel.add(lblOrcamentoUpdate);

        orcamentoField = new JTextField();
        orcamentoField.setBounds(251, 360, 431, 27);
        atualizarPanel.add(orcamentoField);
        orcamentoField.setColumns(10);

        JLabel lblAvaliacaoViagemUpdate = new JLabel("Avaliação Viagem:");
        lblAvaliacaoViagemUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAvaliacaoViagemUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblAvaliacaoViagemUpdate.setBounds(251, 400, 431, 27);
        atualizarPanel.add(lblAvaliacaoViagemUpdate);

        avaliacaoViagemField = new JTextField();
        avaliacaoViagemField.setBounds(251, 430, 431, 27);
        atualizarPanel.add(avaliacaoViagemField);
        avaliacaoViagemField.setColumns(10);

        JLabel lblUsuarioIdUpdate = new JLabel("ID Usuário:");
        lblUsuarioIdUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUsuarioIdUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblUsuarioIdUpdate.setBounds(251, 470, 431, 27);
        atualizarPanel.add(lblUsuarioIdUpdate);

        usuarioIdField = new JTextField();
        usuarioIdField.setBounds(251, 500, 431, 27);
        atualizarPanel.add(usuarioIdField);
        usuarioIdField.setColumns(10);

        JLabel lblDestinoIdUpdate = new JLabel("ID Destino:");
        lblDestinoIdUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDestinoIdUpdate.setForeground(UIManager.getColor("Button.foreground"));
        lblDestinoIdUpdate.setBounds(251, 540, 431, 27);
        atualizarPanel.add(lblDestinoIdUpdate);

        destinoIdField = new JTextField();
        destinoIdField.setBounds(251, 570, 431, 27);
        atualizarPanel.add(destinoIdField);
        destinoIdField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Viagem");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 610, 431, 27);
        atualizarPanel.add(btnAtualizar);
        
        JPanel panel = new JPanel();
        panel.setBounds(230, 39, 471, 611);
        atualizarPanel.add(panel);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(idField.getText());
                    Date dataInicio = new Date(dataInicioField.getText());
                    Date dataTermino = new Date(dataTerminoField.getText());
                    String statusViagem = statusViagemField.getText();
                    Double orcamento = Double.parseDouble(orcamentoField.getText());
                    String avaliacaoViagem = avaliacaoViagemField.getText();
                    Long usuarioId = Long.parseLong(usuarioIdField.getText());
                    Long destinoId = Long.parseLong(destinoIdField.getText());

                    Usuario usuario = viagemController.findUsuarioById(usuarioId);
                    Destino destino = viagemController.findDestinoById(destinoId);

                    if (usuario != null && destino != null) {
                        Viagem viagemAtualizada = viagemController.updateViagem(id, dataInicio, dataTermino, statusViagem, orcamento, avaliacaoViagem, usuario, destino);
                        if (viagemAtualizada != null) {
                            JOptionPane.showMessageDialog(null, "Viagem atualizada com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Viagem não encontrada ou atualização falhou.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou Destino não encontrados.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar a viagem. Verifique os dados inseridos.", "Erro", JOptionPane.ERROR_MESSAGE);
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
