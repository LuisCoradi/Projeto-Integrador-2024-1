package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Destino;
import model.entities.Usuario;
import model.entities.Viagem;
import controller.ViagemController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.Date;

public class CadastrarViagemFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField dataInicioField;
    private JTextField dataTerminoField;
    private JTextField statusViagemField;
    private JTextField orcamentoField;
    private JTextField avaliacaoViagemField;
    private JTextField usuarioIdField;
    private JTextField destinoIdField;
    private ViagemController viagemController = new ViagemController();


    public CadastrarViagemFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDataInicio = new JLabel("Data Início:");
        lblDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDataInicio.setForeground(UIManager.getColor("Button.foreground"));
        lblDataInicio.setBounds(251, 130, 431, 27);
        contentPane.add(lblDataInicio);

        dataInicioField = new JTextField();
        dataInicioField.setBounds(251, 160, 431, 27);
        contentPane.add(dataInicioField);
        dataInicioField.setColumns(10);

        JLabel lblDataTermino = new JLabel("Data Término:");
        lblDataTermino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDataTermino.setForeground(UIManager.getColor("Button.foreground"));
        lblDataTermino.setBounds(251, 200, 431, 27);
        contentPane.add(lblDataTermino);

        dataTerminoField = new JTextField();
        dataTerminoField.setBounds(251, 230, 431, 27);
        contentPane.add(dataTerminoField);
        dataTerminoField.setColumns(10);

        JLabel lblStatusViagem = new JLabel("Status Viagem:");
        lblStatusViagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStatusViagem.setForeground(UIManager.getColor("Button.foreground"));
        lblStatusViagem.setBounds(251, 270, 431, 27);
        contentPane.add(lblStatusViagem);

        statusViagemField = new JTextField();
        statusViagemField.setBounds(251, 300, 431, 27);
        contentPane.add(statusViagemField);
        statusViagemField.setColumns(10);

        JLabel lblOrcamento = new JLabel("Orçamento:");
        lblOrcamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblOrcamento.setForeground(UIManager.getColor("Button.foreground"));
        lblOrcamento.setBounds(251, 340, 431, 27);
        contentPane.add(lblOrcamento);

        orcamentoField = new JTextField();
        orcamentoField.setBounds(251, 370, 431, 27);
        contentPane.add(orcamentoField);
        orcamentoField.setColumns(10);

        JLabel lblAvaliacaoViagem = new JLabel("Avaliação Viagem:");
        lblAvaliacaoViagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAvaliacaoViagem.setForeground(UIManager.getColor("Button.foreground"));
        lblAvaliacaoViagem.setBounds(251, 410, 431, 27);
        contentPane.add(lblAvaliacaoViagem);

        avaliacaoViagemField = new JTextField();
        avaliacaoViagemField.setBounds(251, 440, 431, 27);
        contentPane.add(avaliacaoViagemField);
        avaliacaoViagemField.setColumns(10);

        JLabel lblUsuarioId = new JLabel("ID Usuário:");
        lblUsuarioId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUsuarioId.setForeground(UIManager.getColor("Button.foreground"));
        lblUsuarioId.setBounds(251, 480, 431, 27);
        contentPane.add(lblUsuarioId);

        usuarioIdField = new JTextField();
        usuarioIdField.setBounds(251, 510, 431, 27);
        contentPane.add(usuarioIdField);
        usuarioIdField.setColumns(10);

        JLabel lblDestinoId = new JLabel("ID Destino:");
        lblDestinoId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDestinoId.setForeground(UIManager.getColor("Button.foreground"));
        lblDestinoId.setBounds(251, 550, 431, 27);
        contentPane.add(lblDestinoId);

        destinoIdField = new JTextField();
        destinoIdField.setBounds(251, 580, 431, 27);
        contentPane.add(destinoIdField);
        destinoIdField.setColumns(10);

        JButton btnCadastrar = new JButton("Cadastrar Viagem");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setBounds(251, 620, 431, 27);
        contentPane.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
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
                        Viagem viagem = new Viagem(dataInicio, dataTermino, statusViagem, orcamento, avaliacaoViagem, usuario, destino);
                        viagemController.create(viagem);
                        JOptionPane.showMessageDialog(null, "Viagem cadastrada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou Destino não encontrados.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar a viagem. Verifique os dados inseridos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(251, 660, 431, 27);
        contentPane.add(btnVoltar);

        JPanel panel = new JPanel();
        panel.setBounds(231, 112, 471, 589);
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
