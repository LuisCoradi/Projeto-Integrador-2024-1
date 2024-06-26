package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.entities.Local;
import model.services.LocalService;
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
    private JTextField fotoField;
    private JTextField avaliacaoField;
    private JTextField categoriaField;
    private LocalService localService = new LocalService();

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
        contentPane.setLayout(null); // Usando layout absoluto

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblId.setForeground(UIManager.getColor("Button.foreground"));
        lblId.setBounds(251, 50, 431, 27);
        contentPane.add(lblId);

        idField = new JTextField();
        idField.setBounds(251, 80, 431, 27);
        contentPane.add(idField);
        idField.setColumns(10);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNome.setForeground(UIManager.getColor("Button.foreground"));
        lblNome.setBounds(251, 120, 431, 27);
        contentPane.add(lblNome);

        nomeField = new JTextField();
        nomeField.setBounds(251, 150, 431, 27);
        contentPane.add(nomeField);
        nomeField.setColumns(10);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDescricao.setForeground(UIManager.getColor("Button.foreground"));
        lblDescricao.setBounds(251, 190, 431, 27);
        contentPane.add(lblDescricao);

        descricaoField = new JTextField();
        descricaoField.setBounds(251, 220, 431, 27);
        contentPane.add(descricaoField);
        descricaoField.setColumns(10);

        JLabel lblLatitudeY = new JLabel("Latitude Y:");
        lblLatitudeY.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLatitudeY.setForeground(UIManager.getColor("Button.foreground"));
        lblLatitudeY.setBounds(251, 260, 431, 27);
        contentPane.add(lblLatitudeY);

        latitudeYField = new JTextField();
        latitudeYField.setBounds(251, 290, 431, 27);
        contentPane.add(latitudeYField);
        latitudeYField.setColumns(10);

        JLabel lblLatitudeX = new JLabel("Latitude X:");
        lblLatitudeX.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblLatitudeX.setForeground(UIManager.getColor("Button.foreground"));
        lblLatitudeX.setBounds(251, 330, 431, 27);
        contentPane.add(lblLatitudeX);

        latitudeXField = new JTextField();
        latitudeXField.setBounds(251, 360, 431, 27);
        contentPane.add(latitudeXField);
        latitudeXField.setColumns(10);

        JLabel lblFoto = new JLabel("Foto:");
        lblFoto.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFoto.setForeground(UIManager.getColor("Button.foreground"));
        lblFoto.setBounds(251, 400, 431, 27);
        contentPane.add(lblFoto);

        fotoField = new JTextField();
        fotoField.setBounds(251, 430, 431, 27);
        contentPane.add(fotoField);
        fotoField.setColumns(10);

        JLabel lblAvaliacao = new JLabel("Avaliação:");
        lblAvaliacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAvaliacao.setForeground(UIManager.getColor("Button.foreground"));
        lblAvaliacao.setBounds(251, 470, 431, 27);
        contentPane.add(lblAvaliacao);

        avaliacaoField = new JTextField();
        avaliacaoField.setBounds(251, 500, 431, 27);
        contentPane.add(avaliacaoField);
        avaliacaoField.setColumns(10);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCategoria.setForeground(UIManager.getColor("Button.foreground"));
        lblCategoria.setBounds(251, 540, 431, 27);
        contentPane.add(lblCategoria);

        categoriaField = new JTextField();
        categoriaField.setBounds(251, 570, 431, 27);
        contentPane.add(categoriaField);
        categoriaField.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar Local");
        btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAtualizar.setBounds(251, 610, 431, 27);
        contentPane.add(btnAtualizar);

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Long id = Long.parseLong(idField.getText());
                String nome = nomeField.getText();
                String descricao = descricaoField.getText();
                String latitudeY = latitudeYField.getText();
                String latitudeX = latitudeXField.getText();
                String foto = fotoField.getText();
                String avaliacao = avaliacaoField.getText();
                String categoria = categoriaField.getText();

                Local localAtualizado = localService.updateLocal(id, nome, descricao, latitudeY, latitudeX, foto, avaliacao, categoria);
                if (localAtualizado != null) {
                    JOptionPane.showMessageDialog(null, "Local atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Local não encontrado ou atualização falhou.");
                }

                if (parent != null) {
                    parent.setVisible(true);
                }
                dispose(); // Fecha a janela atual
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVoltar.setBounds(251, 650, 431, 27);
        contentPane.add(btnVoltar);

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (parent != null) {
                    parent.setVisible(true);
                }
                dispose(); // Fecha a janela atual
            }
        });
    }
}
