package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controles.ControleIniciarJogo;

@SuppressWarnings("serial")
public class MenuPrincipal extends JanelaBaseSwing {

	private JPanel contentPane;
	static MenuPrincipal instancia;
	private JButton botaoIniciar;
	private JButton botaoSair;
	private JButton botaoInstrucoes;
	private JLabel lblCriacao;
	private JLabel lblBackground;
	private JLayeredPane layeredPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		
		instanciarComponentes();
		setProriedadesJanela();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}

	private void setPropriedadesComponentes() {

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCriacao.setFont(new Font("Arial", Font.BOLD, 8));
		lblCriacao.setForeground(new Color(255, 255, 255));
		lblCriacao.setBounds(427, 430, 208, 10);
		
		botaoInstrucoes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/novasImagens/button_instrucoes.png")));
		botaoInstrucoes.setBounds(262, 324, 150, 40);
		botaoInstrucoes.addActionListener(this);
		
		botaoIniciar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/novasImagens/iniciar.png")));
		botaoIniciar.setBounds(262, 273, 150, 40);
		botaoIniciar.addActionListener(this);
		
		botaoSair.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/novasImagens/button_sair.png")));
		botaoSair.setBounds(262, 375, 150, 40);
		botaoSair.addActionListener(this);
		
		layeredPane.setBounds(783, 0, -776, 445);
		
		lblBackground.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/novasImagens/telaMenuPrincipal.jpg")));
		lblBackground.setBounds(0, 0, 640, 450);
	}

	private void adicionarComponentesTela() {
		
		contentPane.add(lblCriacao);
		contentPane.add(botaoInstrucoes);
		contentPane.add(botaoIniciar);
		contentPane.add(botaoSair);
		contentPane.add(layeredPane);
		contentPane.add(lblBackground);
	}

	private void setProriedadesJanela() {

		setTitle("Tela Inicial - Ecoman");
	}

	private void instanciarComponentes() {
		
		contentPane = new JPanel();
		lblCriacao = new JLabel("Copyright \u00A9 2017 Obreiros do Bem Developer Company.");
		botaoInstrucoes = new JButton();
		botaoIniciar = new JButton();
		botaoSair = new JButton();
		lblBackground = new JLabel();
		layeredPane = new JLayeredPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == botaoIniciar) {

			dispose();
			ControleIniciarJogo.IniciarJogo();
			
		} else if (ae.getSource() == botaoSair) {
			System.exit(0);
			
		} else if (ae.getSource() == botaoInstrucoes) {

			dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TelaInstrucoes frame = new TelaInstrucoes();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
