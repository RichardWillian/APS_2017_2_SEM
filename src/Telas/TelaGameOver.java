package telas;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controles.ControleIniciarJogo;

@SuppressWarnings("serial")
public class TelaGameOver extends JanelaBaseSwing {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TelaGameOver() {
		setTitle("Game Over - Ecoman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botaoSair = new JButton("");
		botaoSair.setIcon(new ImageIcon(TelaGameOver.class.getResource("/novasImagens/button_sair.png")));
		botaoSair.setBounds(386, 322, 150, 40);
		contentPane.add(botaoSair);
		
		JButton botaoRecomecar = new JButton("");
		botaoRecomecar.setIcon(new ImageIcon(TelaGameOver.class.getResource("/novasImagens/button_recomecar.png")));
		botaoRecomecar.setBounds(141, 322, 150, 40);
		contentPane.add(botaoRecomecar);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setIcon(new ImageIcon(TelaGameOver.class.getResource("/novasImagens/telaGameOver.jpg")));
		lblBackground.setBounds(0, 0, 640, 450);
		contentPane.add(lblBackground);

		setPropriedadesjanela();
		instanciarComponentes();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}
	
	private Button botaoReiniciarJogo;
	private Button botaoVoltarMenuPrincipal;
	private Label lblParabens;
	private MenuPrincipal menuPrincipal;
	private Label lblFraseAgradecimento;
	TelaPrincipal telaPrincipal;

	private void setPropriedadesComponentes() {

		botaoReiniciarJogo.setBounds(48, 220, 100, 40);
		botaoReiniciarJogo.setActionCommand("Reiniciar");

		botaoVoltarMenuPrincipal.setBounds(250, 220, 100, 40);
		botaoVoltarMenuPrincipal.setActionCommand("Voltar");

		lblParabens.setBounds(115, 50, 200, 40);

		lblFraseAgradecimento.setBounds(115, 110, 200, 40);
	}

	private void instanciarComponentes() {

		botaoReiniciarJogo = new Button("Reiniciar Jogo");
		botaoVoltarMenuPrincipal = new Button("Menu Principal");

		lblParabens = new Label("PARABÉNS");
		lblFraseAgradecimento = new Label("Obrigado por limpar nossa cidade !!!");
		lblParabens.setFont(new Font("Tahoma", Font.BOLD, 30));
	}

	private void adicionarComponentesTela() {

		this.add(botaoReiniciarJogo);
		this.add(botaoVoltarMenuPrincipal);
		this.add(lblFraseAgradecimento);
		this.add(lblParabens);
	}

	private void setPropriedadesjanela() {

		this.setLocation(450, 200);
		this.setResizable(false);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "Reiniciar") {
			
			ControleIniciarJogo.IniciarJogo();
			this.dispose(); 
		} else if (e.getActionCommand() == "Voltar") {

			menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible(true);
			this.dispose();
		}
	}

}
