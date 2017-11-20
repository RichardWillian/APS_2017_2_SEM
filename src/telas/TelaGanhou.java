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
public class TelaGanhou extends JanelaBaseSwing {

	private JPanel contentPane;
	private JButton botaoJogarNovamente;
	private JButton botaoSair;
	private JLabel lblBackground;
	private MenuPrincipal menuPrincipal;
	
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

	public TelaGanhou() {
		
		instanciarComponentes();
		setPropriedadesjanela();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}

	private void setPropriedadesComponentes() {

		botaoSair.setIcon(new ImageIcon(TelaGanhou.class.getResource("/novasImagens/button_sair.png")));
		botaoSair.setBounds(391, 360, 150, 40);
		botaoSair.addActionListener(this);
		
		botaoJogarNovamente.setIcon(new ImageIcon(TelaGanhou.class.getResource("/novasImagens/button_jogar-novamente.png")));
		botaoJogarNovamente.setBounds(120, 360, 200, 40);
		botaoJogarNovamente.addActionListener(this);
		
		lblBackground.setIcon(new ImageIcon(TelaGanhou.class.getResource("/novasImagens/telaGanhou.jpg")));
		lblBackground.setBounds(0, 0, 640, 450);
	}

	private void adicionarComponentesTela() {

		contentPane.add(botaoSair);
		contentPane.add(botaoJogarNovamente);
		contentPane.add(lblBackground);
	}

	private void setPropriedadesjanela() {
		
		setTitle("Parabens - Ecoman");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void instanciarComponentes() {
		botaoJogarNovamente = new JButton();
		botaoSair = new JButton();
		lblBackground = new JLabel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botaoJogarNovamente) {
			
			ControleIniciarJogo.IniciarJogo();
			this.dispose(); 
		} else if (e.getSource() == botaoSair) {

			menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible(true);
			this.dispose();
		}
	}
}
