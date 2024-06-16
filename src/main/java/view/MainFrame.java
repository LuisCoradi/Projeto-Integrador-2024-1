package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 875);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 49));
		contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 25));
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		contentPane.add(internalFrame);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(30, 15, 30, 15));
		internalFrame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 8));
		
		JButton btnNewButton_1 = new JButton("Gerenciar Usuarios");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Gerenciar Locais");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Gerenciar Viagens");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("Gerenciar Destinos");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Gerenciar Administradores");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Gerenciar Reservas");
		panel.add(btnNewButton_5);
		internalFrame.setVisible(true);
	}

}
