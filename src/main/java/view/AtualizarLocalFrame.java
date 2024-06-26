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

public class AtualizarLocalFrame extends JFrame {

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
    private LocalController localController = new LocalController();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AtualizarLocalFrame frame = new AtualizarLocalFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AtualizarLocalFrame(JFrame parent) {
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

        JLabel lblNome = new JLabel("Nome Local:");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNome.setForeground(UIManager.getColor("Button.foreground"));
        lblNome.setBounds(251, 194, 431, 27);
        contentPane.add(lblNome);

        nomeField = new JTextField();
        nomeField.setBounds(251, 224, 431, 27);
        contentPane.add(nomeField);
        nomeField.setColumns(10);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDescricao.setForeground(UIManager.getColor("Button.foreground"));
        lblDescricao.setBounds(251, 264, 431, 27);
        contentPane.add(lblDescricao);

        descricaoField = new JTextField();
        descricaoField.setBounds(251, 294, 431, 27);
        contentPane.add(descricaoField);
        descricaoField.setColumns(10);

        JLabel lblLatitudeY = new JLabel("Latitude Y:");
        lblLatitudeY.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLatitudeY.setForeground(UIManager.getColor("Button.foreground"));
        lblLatitudeY.setBounds(251, 334, 431, 27);
        contentPane.add(lblLatitudeY);

        latitudeYField = new JTextField();
        latitudeYField.setBounds(251, 364, 431, 27);
        contentPane.add(latitudeYField);
        latitudeYField.setColumns(10);

        JLabel lblLatitudeX = new JLabel("Latitude X:");
        lblLatitudeX.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLatitudeX.setForeground(UIManager.getColor("Button.foreground"));
        lblLatitudeX.setBounds(251, 404, 431, 27);
        contentPane.add(lblLatitudeX);

        latitudeXField = new JTextField();
        latitudeXField.setBounds(251, 434, 431, 27);
        contentPane.add(latitudeXField);
        latitudeXField.setColumns(10);

        JLabel lblFotoLocal = new JLabel("Foto Local:");
        lblFotoLocal.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFotoLocal.setForeground(UIManager.getColor("Button.foreground"));
        lblFotoLocal.setBounds(251, 474, 431, 27);
        contentPane.add(lblFotoLocal);

        fotoLocalField = new JTextField();
        fotoLocalField.setBounds(251, 504, 431, 27);
        contentPane.add(fotoLocalField);
        fotoLocalField.setColumns(10);

        JLabel lblAvaliacao = new JLabel("Avaliação:");
        lblAvaliacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAvaliacao.setForeground(UIManager.getColor("Button.foreground"));
        lblAvaliacao.setBounds(251, 544, 431, 27);
        contentPane.add(lblAvaliacao);

        avaliacaoField = new JTextField();
        avaliacaoField.setBounds(251, 574, 431, 27);
        contentPane.add(avaliacaoField);
        avaliacaoField.setColumns(10);

        JLabel lblCategoriaLocal = new JLabel("Categoria Local:");
        lblCategoriaLocal.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCategoriaLocal.setForeground(UIManager.getColor("Button.foreground"));
        lblCategoriaLocal.setBounds(251, 614, 431, 27);
        contentPane.add(lblCategoriaLocal);

        categoriaLocalField = new JTextField();
        categoriaLocalField.setBounds(251, 644, 431, 27);
        contentPane.add(categoriaLocalField);
        categoriaLocalField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Local");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 684, 431, 27);
        contentPane.add(btnAtualizar);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                String nomeLocal = nomeField.getText();
                String descricao = descricaoField.getText();
                String latitudeY = latitudeYField.getText();
                String latitudeX = latitudeXField.getText();
                String fotoLocal = fotoLocalField.getText();
                String avaliacao = avaliacaoField.getText();
                String categoriaLocal = categoriaLocalField.getText();

                Local localAtualizado = localController.updateLocal(id, nomeLocal, descricao, latitudeY, latitudeX, fotoLocal, avaliacao, categoriaLocal);
                if (localAtualizado != null) {
                    JOptionPane.showMessageDialog(null, "Local atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Local não encontrado ou atualização falhou.");
                }

                if (parent != null) {
                    parent.setVisible(true);
                }
                dispose();
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(251, 724, 431, 27);
        contentPane.add(btnVoltar);
        
        JPanel panel = new JPanel();
        panel.setBounds(231, 114, 470, 656);
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

