package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaInstrucoes extends JanelaBaseSwing{

	private JPanel contentPane;

	private JLabel lblControles;
	private JLabel lblDirecao;
	private JLabel lblFuncaoBarraEspaco;

	private JLabel gifCaminharCima;
	private JLabel gifCaminharBaixo;
	private JLabel gifCaminharDireita;
	private JLabel gifCaminharEsquerda;
	private JLabel lblObjetivoJogo;

	private JLabel botaoCima;
	private JLabel botaoBaixo;
	private JLabel botaoEsquerda;
	private JLabel botaoDireita;
	private JButton barraEspaco;
	private JButton botaoVoltar;
	private JLabel lblBackground;
	private JLabel lblObjetivo;
	private JLabel lblDica;
	private JLabel lblaoEsbarrarCom;

	public TelaInstrucoes() {

		setPropriedadesjanela();
		instanciarComponentes();
		setPropriedadesComponentes();
		adicionarComponentesTela();
	}

	private void setPropriedadesComponentes() {

		contentPane.setLayout(null);

		lblaoEsbarrarCom.setForeground(new Color(255, 255, 255));
		lblaoEsbarrarCom.setText("<html>Ao esbarrar com o DirtyMan voce ir\u00E1 adverti-lo sobre os problemas gerados com o descarte de lixo da forma incorreta, e isso far\u00E1 com que ele reflita sobre o assunto por alguns segundos dando tempo para o Ecoman recolher os lixos rapidame</html>");
		lblaoEsbarrarCom.setFont(new Font("Calibri", Font.BOLD, 14));
		lblaoEsbarrarCom.setBounds(31, 272, 283, 111);
		
		botaoCima.setBounds(474, 224, 39, 36);
		botaoCima.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/imagensTelaInformacoes/BotaoCima.png")));

		botaoBaixo.setBounds(474, 271, 39, 36);
		botaoBaixo.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/imagensTelaInformacoes/BotaoBaixo.png")));

		botaoEsquerda.setBounds(425, 271, 39, 36);
		botaoEsquerda.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/imagensTelaInformacoes/BotaoEsquerdo.png")));

		botaoDireita.setBounds(523, 271, 39, 36);
		botaoDireita.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/imagensTelaInformacoes/BotaoDireito.png")));

		gifCaminharCima.setBounds(474, 133, 50, 50);
		gifCaminharCima.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/gifsEcoman/Caminhar_Cima_GIF.gif")));

		gifCaminharBaixo.setBounds(474, 133, 50, 50);
		gifCaminharBaixo.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/gifsEcoman/Caminhar_Baixo_GIF.gif")));

		gifCaminharEsquerda.setBounds(474, 133, 50, 50);
		gifCaminharEsquerda.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/gifsEcoman/Caminhar_Esquerda_GIF.gif")));

		gifCaminharDireita.setBounds(474, 133, 50, 50);
		gifCaminharDireita.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/gifsEcoman/Caminhar_Direita_GIF.gif")));

		barraEspaco.setBounds(382, 318, 219, 36);
		barraEspaco.setEnabled(false);

		lblControles.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/novasImagens/instrucoes.png")));
		lblControles.setBounds(53, 58, 505, 50);
		lblControles.setFont(new Font("Rockwell", Font.BOLD, 20));

		lblDirecao.setBounds(440, 194, 139, 19);
		lblDirecao.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblDirecao.setForeground(new Color(0, 255, 0));
		
		botaoVoltar.setBounds(576, 11, 47, 23);
		botaoVoltar.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		botaoVoltar.addActionListener(this);

		lblFuncaoBarraEspaco.setBounds(400, 365, 227, 18);
		lblFuncaoBarraEspaco.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblFuncaoBarraEspaco.setForeground(new Color(0, 255, 0));

		lblBackground.setIcon(new ImageIcon(TelaInstrucoes.class.getResource("/novasImagens/telaInstrucoes.jpg")));
		lblBackground.setBounds(0, 0, 633, 410);

		lblObjetivo.setBounds(31, 126, 100, 100);
		lblObjetivo.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblObjetivo.setForeground(new Color(0, 0, 0));
		
		lblObjetivoJogo.setForeground(new Color(255, 255, 255));
		lblObjetivoJogo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblObjetivoJogo.setText("<html>Coletar todo lixo que \u00E9 lan\u00E7ado pelo DirtyMan e despejar nas lixeiras antes que o tempo acabe.</html>");
		lblObjetivoJogo.setBounds(31, 194, 250, 51);

		lblDica.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblDica.setBounds(31, 256, 64, 19);
		lblDica.setForeground(new Color(0, 0, 0));

		contentPane.add(lblaoEsbarrarCom);

		desativarImagens(false);
	}

	private void adicionarComponentesTela() {

		contentPane.add(lblDica);

		contentPane.add(lblObjetivo);

		contentPane.add(botaoCima);
		
		contentPane.add(botaoBaixo);
		
		contentPane.add(botaoEsquerda);
		
		contentPane.add(botaoDireita);
		
		contentPane.add(barraEspaco);
		
		contentPane.add(lblControles);
		
		contentPane.add(lblDirecao);
		
		contentPane.add(botaoVoltar);
		
		contentPane.add(lblFuncaoBarraEspaco);

		contentPane.add(gifCaminharCima);
		
		contentPane.add(gifCaminharBaixo);
		
		contentPane.add(gifCaminharEsquerda);
		
		contentPane.add(gifCaminharDireita);

		contentPane.add(lblObjetivo);
		
		contentPane.add(lblObjetivoJogo);
		
		contentPane.add(lblBackground);
	}

	private void instanciarComponentes() {

		botaoCima = new JLabel();
		lblBackground = new JLabel();
		botaoBaixo = new JLabel();
		lblDica = new JLabel("Dica");
		botaoEsquerda = new JLabel();
		botaoDireita = new JLabel();
		barraEspaco = new JButton("Barra de Espaço");
		lblControles = new JLabel();
		lblDirecao = new JLabel("Movimentador");
		botaoVoltar = new JButton();
		gifCaminharCima = new JLabel();
		gifCaminharBaixo = new JLabel();
		gifCaminharDireita = new JLabel();
		gifCaminharEsquerda = new JLabel();
		lblFuncaoBarraEspaco = new JLabel("Espaço - Descarrega o Lixo");
		lblObjetivoJogo = new JLabel();
		lblaoEsbarrarCom = new JLabel();
		lblObjetivo = new JLabel("Objetivo");
	}

	private void setPropriedadesjanela() {

		setTitle("Instru\u00E7\u00F5es - Ecoman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(20, 80, 649, 449);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.addKeyListener(this);
		contentPane.setFocusable(true);
	}

	@Override
	public void keyPressed(KeyEvent ke) {

		desativarImagens(true);

		switch (ke.getKeyCode()) {

		case KeyEvent.VK_UP:
			gifCaminharCima.setVisible(true);
			break;

		case KeyEvent.VK_RIGHT:

			gifCaminharDireita.setVisible(true);
			break;

		case KeyEvent.VK_LEFT:

			gifCaminharEsquerda.setVisible(true);
			break;

		case KeyEvent.VK_DOWN:

			gifCaminharBaixo.setVisible(true);
			break;
			
		default:
			lblObjetivoJogo.setVisible(true);
			break;

		}
	}

	private void desativarImagens(boolean desativarObjetivo) {

		gifCaminharCima.setVisible(false);
		gifCaminharBaixo.setVisible(false);
		gifCaminharDireita.setVisible(false);
		gifCaminharEsquerda.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		desativarImagens(true);

		if (ae.getSource() == botaoCima) {
			gifCaminharCima.setVisible(true);

		} else if (ae.getSource() == botaoBaixo) {
			gifCaminharBaixo.setVisible(true);

		} else if (ae.getSource() == botaoDireita) {
			gifCaminharDireita.setVisible(true);

		} else if (ae.getSource() == botaoEsquerda) {
			gifCaminharEsquerda.setVisible(true);

		} else if (ae.getSource() == botaoVoltar) {
			dispose();
			MenuPrincipal menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible(true);
		}
	}
}
