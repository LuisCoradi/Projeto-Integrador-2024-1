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

public class CadastrarDestinoFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nomeDestinoField;
    private JTextField descricaoDestinoField;
    private JTextField fotoDestinoField;
    private JTextField paisField;
    private JTextField regiaoField;
    private DestinoController destinoController = new DestinoController();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarDestinoFrame frame = new CadastrarDestinoFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastrarDestinoFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNomeDestino = new JLabel("Nome do Destino:");
        lblNomeDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNomeDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblNomeDestino.setBounds(251, 130, 431, 27);
        contentPane.add(lblNomeDestino);

        nomeDestinoField = new JTextField();
        nomeDestinoField.setBounds(251, 160, 431, 27);
        contentPane.add(nomeDestinoField);
        nomeDestinoField.setColumns(10);

        JLabel lblDescricaoDestino = new JLabel("Descrição do Destino:");
        lblDescricaoDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDescricaoDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblDescricaoDestino.setBounds(251, 200, 431, 27);
        contentPane.add(lblDescricaoDestino);

        descricaoDestinoField = new JTextField();
        descricaoDestinoField.setBounds(251, 230, 431, 27);
        contentPane.add(descricaoDestinoField);
        descricaoDestinoField.setColumns(10);

        JLabel lblFotoDestino = new JLabel("Foto do Destino:");
        lblFotoDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFotoDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblFotoDestino.setBounds(251, 270, 431, 27);
        contentPane.add(lblFotoDestino);

        fotoDestinoField = new JTextField();
        fotoDestinoField.setBounds(251, 300, 431, 27);
        contentPane.add(fotoDestinoField);
        fotoDestinoField.setColumns(10);

        JLabel lblPais = new JLabel("País:");
        lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPais.setForeground(UIManager.getColor("Button.foreground"));
        lblPais.setBounds(251, 340, 431, 27);
        contentPane.add(lblPais);

        paisField = new JTextField();
        paisField.setBounds(251, 370, 431, 27);
        contentPane.add(paisField);
        paisField.setColumns(10);

        JLabel lblRegiao = new JLabel("Região:");
        lblRegiao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblRegiao.setForeground(UIManager.getColor("Button.foreground"));
        lblRegiao.setBounds(251, 410, 431, 27);
        contentPane.add(lblRegiao);

        regiaoField = new JTextField();
        regiaoField.setBounds(251, 440, 431, 27);
        contentPane.add(regiaoField);
        regiaoField.setColumns(10);

        JButton btnCadastrar = new JButton("Cadastrar Destino");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setBounds(251, 480, 431, 27);
        contentPane.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeDestino = nomeDestinoField.getText();
                String descricaoDestino = descricaoDestinoField.getText();
                String fotoDestino = fotoDestinoField.getText();
                String pais = paisField.getText();
                String regiao = regiaoField.getText();

                Destino destino = new Destino(nomeDestino, descricaoDestino, fotoDestino, pais, regiao);
                destinoController.create(destino);
                JOptionPane.showMessageDialog(null, "Destino cadastrado com sucesso!");

                if (parent != null) {
                    parent.setVisible(true);
                }
                dispose();
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(251, 520, 431, 27);
        contentPane.add(btnVoltar);
        
        JPanel panel = new JPanel();
        panel.setBounds(229, 120, 471, 445);
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
