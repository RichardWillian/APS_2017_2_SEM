package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaGanhou extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGanhou frame = new TelaGanhou();
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
	public TelaGanhou() {
		setTitle("Parabens - Ecoman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSair = new JButton();
		btnSair.setIcon(new ImageIcon(TelaGanhou.class.getResource("/novasImagens/button_sair.png")));
		btnSair.setBounds(391, 360, 150, 40);
		contentPane.add(btnSair);
		
		JButton botaoJogarNovamente = new JButton("");
		botaoJogarNovamente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoJogarNovamente.setIcon(new ImageIcon(TelaGanhou.class.getResource("/novasImagens/button_jogar-novamente.png")));
		botaoJogarNovamente.setBounds(120, 360, 200, 40);
		contentPane.add(botaoJogarNovamente);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setIcon(new ImageIcon(TelaGanhou.class.getResource("/novasImagens/telaGanhou.jpg")));
		lblBackground.setBounds(0, 0, 635, 441);
		contentPane.add(lblBackground);
	}

}
