package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.ViagemController;
import model.entities.Destino;
import model.entities.Usuario;
import model.entities.Viagem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AtualizarViagemFrame extends JFrame {

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
    private ViagemController viagemController = new ViagemController();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AtualizarViagemFrame frame = new AtualizarViagemFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AtualizarViagemFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setForeground(Color.BLACK);
        lblId.setBounds(251, 50, 431, 27);
        contentPane.add(lblId);

        idField = new JTextField();
        idField.setBounds(251, 80, 431, 27);
        contentPane.add(idField);
        idField.setColumns(10);

        JLabel lblDataInicio = new JLabel("Data Início (yyyy-MM-dd):");
        lblDataInicio.setForeground(Color.BLACK);
        lblDataInicio.setBounds(251, 120, 431, 27);
        contentPane.add(lblDataInicio);

        dataInicioField = new JTextField();
        dataInicioField.setBounds(251, 150, 431, 27);
        contentPane.add(dataInicioField);
        dataInicioField.setColumns(10);

        JLabel lblDataTermino = new JLabel("Data Término (yyyy-MM-dd):");
        lblDataTermino.setForeground(Color.BLACK);
        lblDataTermino.setBounds(251, 190, 431, 27);
        contentPane.add(lblDataTermino);

        dataTerminoField = new JTextField();
        dataTerminoField.setBounds(251, 220, 431, 27);
        contentPane.add(dataTerminoField);
        dataTerminoField.setColumns(10);

        JLabel lblStatusViagem = new JLabel("Status Viagem:");
        lblStatusViagem.setForeground(Color.BLACK);
        lblStatusViagem.setBounds(251, 260, 431, 27);
        contentPane.add(lblStatusViagem);

        statusViagemField = new JTextField();
        statusViagemField.setBounds(251, 290, 431, 27);
        contentPane.add(statusViagemField);
        statusViagemField.setColumns(10);

        JLabel lblOrcamento = new JLabel("Orçamento:");
        lblOrcamento.setForeground(Color.BLACK);
        lblOrcamento.setBounds(251, 330, 431, 27);
        contentPane.add(lblOrcamento);

        orcamentoField = new JTextField();
        orcamentoField.setBounds(251, 360, 431, 27);
        contentPane.add(orcamentoField);
        orcamentoField.setColumns(10);

        JLabel lblAvaliacaoViagem = new JLabel("Avaliação Viagem:");
        lblAvaliacaoViagem.setForeground(Color.BLACK);
        lblAvaliacaoViagem.setBounds(251, 400, 431, 27);
        contentPane.add(lblAvaliacaoViagem);

        avaliacaoViagemField = new JTextField();
        avaliacaoViagemField.setBounds(251, 430, 431, 27);
        contentPane.add(avaliacaoViagemField);
        avaliacaoViagemField.setColumns(10);

        JLabel lblUsuarioId = new JLabel("ID do Usuário:");
        lblUsuarioId.setForeground(Color.BLACK);
        lblUsuarioId.setBounds(251, 470, 431, 27);
        contentPane.add(lblUsuarioId);

        usuarioIdField = new JTextField();
        usuarioIdField.setBounds(251, 500, 431, 27);
        contentPane.add(usuarioIdField);
        usuarioIdField.setColumns(10);

        JLabel lblDestinoId = new JLabel("ID do Destino:");
        lblDestinoId.setForeground(Color.BLACK);
        lblDestinoId.setBounds(251, 540, 431, 27);
        contentPane.add(lblDestinoId);

        destinoIdField = new JTextField();
        destinoIdField.setBounds(251, 570, 431, 27);
        contentPane.add(destinoIdField);
        destinoIdField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Viagem");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 610, 431, 27);
        contentPane.add(btnAtualizar);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                String dataInicioText = dataInicioField.getText();
                String dataTerminoText = dataTerminoField.getText();
                String statusViagem = statusViagemField.getText();
                Double orcamento = Double.parseDouble(orcamentoField.getText());
                String avaliacaoViagem = avaliacaoViagemField.getText();
                Long usuarioId = Long.parseLong(usuarioIdField.getText());
                Long destinoId = Long.parseLong(destinoIdField.getText());

                try {
                    Date dataInicio = dateFormat.parse(dataInicioText);
                    Date dataTermino = dateFormat.parse(dataTerminoText);
                    Usuario usuario = viagemController.findUsuarioById(usuarioId);
                    Destino destino = viagemController.findDestinoById(destinoId);

                    Viagem viagemAtualizada = viagemController.updateViagem(id, dataInicio, dataTermino, statusViagem, orcamento, avaliacaoViagem, usuario, destino);
                    if (viagemAtualizada != null) {
                        JOptionPane.showMessageDialog(null, "Viagem atualizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Viagem não encontrada ou atualização falhou.");
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
        btnVoltar.setBounds(251, 650, 431, 27);
        contentPane.add(btnVoltar);
        
        JPanel panel = new JPanel();
        panel.setBounds(231, 45, 469, 664);
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
