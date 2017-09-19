package Telas;

import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaInstrucoes extends JFrame {

	private JPanel contentPane;

	public TelaInstrucoes() {
		setTitle("Controles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton botaoUp = new JButton("");
		botaoUp.setIcon(new ImageIcon("C:\\Users\\Vitor\\Desktop\\sprite\\^.png"));
		botaoUp.setBackground(new Color(51, 102, 0));
		botaoUp.setToolTipText("");
		botaoUp.setFont(new Font("Tahoma", Font.PLAIN, 8));
		botaoUp.setBounds(310, 142, 39, 36);
		contentPane.add(botaoUp);

		JButton botaoDown = new JButton("");
		botaoDown.setIcon(new ImageIcon("C:\\Users\\Vitor\\Desktop\\sprite\\baixo.png"));
		botaoDown.setBounds(310, 189, 39, 36);
		contentPane.add(botaoDown);

		JButton botaoLeft = new JButton("");
		botaoLeft.setIcon(new ImageIcon("C:\\Users\\Vitor\\Desktop\\sprite\\esquerda.png"));
		botaoLeft.setBounds(261, 189, 39, 36);
		contentPane.add(botaoLeft);

		JButton botaoRight = new JButton("");
		botaoRight.setIcon(new ImageIcon("C:\\Users\\Vitor\\Desktop\\sprite\\direita.png"));
		botaoRight.setBounds(359, 189, 39, 36);
		contentPane.add(botaoRight);

		Button botaoZ = new Button("Z");
		botaoZ.setBounds(47, 142, 39, 36);
		contentPane.add(botaoZ);

		Button botaoX = new Button("X");
		botaoX.setBounds(96, 142, 39, 36);
		contentPane.add(botaoX);

		Button botaoC = new Button("C");
		botaoC.setBounds(145, 142, 39, 36);
		contentPane.add(botaoC);

		JButton btnSpaceBar = new JButton("SPACE BAR");
		btnSpaceBar.setBounds(10, 189, 219, 36);
		contentPane.add(btnSpaceBar);

		JLabel lblControloes = new JLabel("CONTROLES");
		lblControloes.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblControloes.setBounds(142, 11, 137, 29);
		contentPane.add(lblControloes);

		JLabel lblDireo = new JLabel("MOVIMENTADOR");
		lblDireo.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblDireo.setBounds(261, 92, 139, 19);
		contentPane.add(lblDireo);

		JLabel lblZUtiliza = new JLabel("ESPACO - DESCARREGA O LIXO");
		lblZUtiliza.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblZUtiliza.setBounds(10, 232, 227, 18);
		contentPane.add(lblZUtiliza);

		JLabel label = new JLabel("Z - UTILIZA O PODER 1");
		label.setFont(new Font("Rockwell", Font.BOLD, 15));
		label.setBounds(10, 67, 174, 19);
		contentPane.add(label);

		JLabel lblCUtiliza = new JLabel("C - UTILIZA O PODER 3");
		lblCUtiliza.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblCUtiliza.setBounds(10, 117, 176, 19);
		contentPane.add(lblCUtiliza);

		JLabel lblXUtiliza = new JLabel("X - UTILIZA O PODER 2");
		lblXUtiliza.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblXUtiliza.setBounds(10, 92, 175, 19);
		contentPane.add(lblXUtiliza);

		final JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnVoltar) {
					dispose();
				}
			}
		});
		btnVoltar.setIcon(
				new ImageIcon(TelaInstrucoes.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnVoltar.setBounds(377, 11, 47, 23);
		contentPane.add(btnVoltar);
	}

}
