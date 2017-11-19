package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controles.ControleIniciarJogo;

@SuppressWarnings("serial")
public class TelaGameOver extends JanelaBaseSwing {

	private JPanel contentPane;
	private JButton botaoReiniciarJogo;
	private JButton botaoVoltarMenuPrincipal;
	private JLabel lblBackground;
	private MenuPrincipal menuPrincipal;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGameOver frame = new TelaGameOver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaGameOver() {

		instanciarComponentes();
		setPropriedadesjanela();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}

	private void setPropriedadesComponentes() {
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		botaoVoltarMenuPrincipal.setIcon(new ImageIcon(TelaGameOver.class.getResource("/novasImagens/button_sair.png")));
		botaoVoltarMenuPrincipal.setBounds(386, 322, 140, 40);
		botaoVoltarMenuPrincipal.addActionListener(this);
		
		botaoReiniciarJogo.setIcon(new ImageIcon(TelaGameOver.class.getResource("/novasImagens/button_recomecar.png")));
		botaoReiniciarJogo.setBounds(141, 322, 140, 40);
		botaoReiniciarJogo.addActionListener(this);
		
		lblBackground.setIcon(new ImageIcon(TelaGameOver.class.getResource("/novasImagens/telaGameOver.jpg")));
		lblBackground.setBounds(0, 0, 640, 450);
	}

	private void instanciarComponentes() {
		
		contentPane = new JPanel();
		botaoReiniciarJogo = new JButton();
		botaoVoltarMenuPrincipal = new JButton();
		botaoReiniciarJogo = new JButton("Reiniciar Jogo");
		botaoVoltarMenuPrincipal = new JButton("Menu Principal");
		lblBackground = new JLabel();
	}

	private void adicionarComponentesTela() {
		
		contentPane.add(botaoVoltarMenuPrincipal);
		contentPane.add(botaoReiniciarJogo);
		contentPane.add(lblBackground);
	}

	private void setPropriedadesjanela() {

		this.setResizable(false);
		this.setVisible(true);
		this.setFocusable(true);
		this.setTitle("Game Over - Ecoman");
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botaoReiniciarJogo) {
			
			ControleIniciarJogo.IniciarJogo();
			this.dispose();
			
		} else if (e.getSource() == botaoVoltarMenuPrincipal) {

			menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible(true);
			this.dispose();
		}
	}

}
