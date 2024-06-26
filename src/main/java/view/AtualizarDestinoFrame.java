package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.DestinoController;
import model.entities.Destino;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class AtualizarDestinoFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idField;
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
                    AtualizarDestinoFrame frame = new AtualizarDestinoFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AtualizarDestinoFrame(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblId.setForeground(UIManager.getColor("Button.foreground"));
        lblId.setBounds(251, 114, 431, 27);
        contentPane.add(lblId);

        idField = new JTextField();
        idField.setBounds(251, 144, 431, 27);
        contentPane.add(idField);
        idField.setColumns(10);

        JLabel lblNomeDestino = new JLabel("Nome Destino:");
        lblNomeDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNomeDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblNomeDestino.setBounds(251, 194, 431, 27);
        contentPane.add(lblNomeDestino);

        nomeDestinoField = new JTextField();
        nomeDestinoField.setBounds(251, 224, 431, 27);
        contentPane.add(nomeDestinoField);
        nomeDestinoField.setColumns(10);

        JLabel lblDescricaoDestino = new JLabel("Descrição Destino:");
        lblDescricaoDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDescricaoDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblDescricaoDestino.setBounds(251, 264, 431, 27);
        contentPane.add(lblDescricaoDestino);

        descricaoDestinoField = new JTextField();
        descricaoDestinoField.setBounds(251, 294, 431, 27);
        contentPane.add(descricaoDestinoField);
        descricaoDestinoField.setColumns(10);

        JLabel lblFotoDestino = new JLabel("Foto Destino:");
        lblFotoDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFotoDestino.setForeground(UIManager.getColor("Button.foreground"));
        lblFotoDestino.setBounds(251, 334, 431, 27);
        contentPane.add(lblFotoDestino);

        fotoDestinoField = new JTextField();
        fotoDestinoField.setBounds(251, 364, 431, 27);
        contentPane.add(fotoDestinoField);
        fotoDestinoField.setColumns(10);

        JLabel lblPais = new JLabel("País:");
        lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPais.setForeground(UIManager.getColor("Button.foreground"));
        lblPais.setBounds(251, 404, 431, 27);
        contentPane.add(lblPais);

        paisField = new JTextField();
        paisField.setBounds(251, 434, 431, 27);
        contentPane.add(paisField);
        paisField.setColumns(10);

        JLabel lblRegiao = new JLabel("Região:");
        lblRegiao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblRegiao.setForeground(UIManager.getColor("Button.foreground"));
        lblRegiao.setBounds(251, 474, 431, 27);
        contentPane.add(lblRegiao);

        regiaoField = new JTextField();
        regiaoField.setBounds(251, 504, 431, 27);
        contentPane.add(regiaoField);
        regiaoField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Destino");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 554, 431, 27);
        contentPane.add(btnAtualizar);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Long id = Long.parseLong(idField.getText().trim());
                    String nomeDestino = nomeDestinoField.getText().trim();
                    String descricaoDestino = descricaoDestinoField.getText().trim();
                    String fotoDestino = fotoDestinoField.getText().trim();
                    String pais = paisField.getText().trim();
                    String regiao = regiaoField.getText().trim();

                    if (nomeDestino.isEmpty() || descricaoDestino.isEmpty() || fotoDestino.isEmpty() || pais.isEmpty() || regiao.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Destino destinoAtualizado = destinoController.updateDestino(id, nomeDestino, descricaoDestino, fotoDestino, pais, regiao);
                    if (destinoAtualizado != null) {
                        JOptionPane.showMessageDialog(null, "Destino atualizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Destino não encontrado ou atualização falhou.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(251, 594, 431, 27);
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

