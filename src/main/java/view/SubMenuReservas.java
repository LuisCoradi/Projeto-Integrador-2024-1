package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubMenuReservas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public SubMenuReservas(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 947, 875);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 49));
        contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 25));

        JButton btnCadastrarReserva = new JButton("Cadastrar Reserva");
        contentPane.add(btnCadastrarReserva);

        JButton btnAtualizarReserva = new JButton("Atualizar Reserva");
        contentPane.add(btnAtualizarReserva);

        JButton btnDeletarReserva = new JButton("Deletar Reserva");
        contentPane.add(btnDeletarReserva);

        JButton btnVerReservaPorId = new JButton("Ver Reserva por ID");
        contentPane.add(btnVerReservaPorId);

        JButton btnVerTodasReservas = new JButton("Ver Todas Reservas");
        contentPane.add(btnVerTodasReservas);

        JButton btnVoltar = new JButton("Voltar ao Menu Principal");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainFrame().setVisible(true);
                dispose(); // Fecha a janela atual
            }
        });
        contentPane.add(btnVoltar);
    }
}
