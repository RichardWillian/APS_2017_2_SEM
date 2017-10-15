package Telas;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import Constantes.ConstantesMensagens;
import Controles.ControleDirtyMan;
import Controles.ControleEcoman;
import Controles.Cronometro;
import Objetos.Lixeira;
import Objetos.Lixo;
import Personagens.DirtyMan;
import Personagens.Ecoman;

@SuppressWarnings("serial")
public class TelaPrincipal extends JanelaBase {
	Cronometro ctrlCronometro;
	ControleDirtyMan ctrlDirtyman;
	DirtyMan dirtyman;
	Ecoman ecoman;
	Lixeira lixeira;
	Lixo lixo;
	ControleEcoman ctrlEcoman;
	TelaGameOver telaGameOver;
	BufferedImage fundoTela;
	public Vector<Button> listaLixos;
	public Label lblAlertaCarregandoLixo;
	public Label lblPontuacao;
	public Label lblAdvertencia;
	public Label lblTempo;
	public Label eixoX;
	public Label eixoY;
	public int pontos = 0;
	JLabel background;

	static TelaPrincipal instancia;
	public TelaPrincipal() {

		instanciarObjetos();
		instanciarComponentes();
		setPropriedadesjanela();
		adicionarComponentesTela();
		setPropriedadesComponentes();
		ctrlDirtyman.start();
		ctrlCronometro.start();
	}

	private void setPropriedadesComponentes() {
		lblTempo.setBounds(1065, 40, 70, 12);
		lblPontuacao.setBounds(1000, 90, 110, 15);
		lblAlertaCarregandoLixo.setBounds(1000, 115, 150, 15);
		lblAdvertencia.setBounds(1000, 140, 200, 40);
		background.setBounds(0, 0, 1000, getHeight());
		eixoX.setBounds(1065, 180, 100, 40);
		eixoY.setBounds(1065, 240, 100, 40);
	}

	private void instanciarComponentes() {
		lblTempo = new Label();
		lblPontuacao = new Label("PONTUAÇÃO: 0");
		lblAdvertencia = new Label();
		lblAlertaCarregandoLixo = new Label("CARREGANDO LIXO...");
		background = new JLabel();
		eixoX = new Label();
		eixoY = new Label();
	}

	private void adicionarComponentesTela() {
		this.add(ecoman.ecoImage);
		this.add(dirtyman.btnDirtyman);
		this.add(lixeira.btnLixeira);
		this.add(lblPontuacao);
		this.add(lblTempo);
		this.add(lblAlertaCarregandoLixo);
		lblAlertaCarregandoLixo.setVisible(false);

		this.add(lblAdvertencia);
		lblAdvertencia.setVisible(false);
		
		this.add(background);
		this.add(eixoX);
		this.add(eixoY);
	}

	private void setPropriedadesjanela() {

		this.setLocation(150, 25);
		this.setSize(1200, 700);
		this.setVisible(true);
		this.setFocusable(true);
		this.setResizable(false);
	}

	private void instanciarObjetos() {

		dirtyman = DirtyMan.getInstance();
		ecoman = Ecoman.getInstance();
		ctrlDirtyman = ControleDirtyMan.getInstance();
		lixeira = new Lixeira();
		listaLixos = new Vector<Button>();
		lixo = new Lixo();
		ctrlCronometro = new Cronometro();
	}

	public static TelaPrincipal getInstance() {

		if (instancia == null)
			instancia = new TelaPrincipal();

		return instancia;
	}

	public void keyPressed(KeyEvent ke) {

		ctrlEcoman = ControleEcoman.getInstance();
		ctrlEcoman.movimentarEcoman(ke);

		if (ecoman.estaCarregandoLixo()) {
			lblAlertaCarregandoLixo.setBackground(new Color(100, 230, 133));
			lblAlertaCarregandoLixo.setVisible(true);
		} else
			lblAlertaCarregandoLixo.setVisible(false);
		Integer x = ecoman.ecoImage.getBounds().x;
		eixoX.setText(x.toString());
		
		Integer y = ecoman.ecoImage.getBounds().y;
		eixoY.setText(y.toString());
	}

	public void mostrarAdvertenciaEcologica() {

		lblAdvertencia.setText(ConstantesMensagens.ADVERTENCIA_ECOLOGICA_1);
		lblAdvertencia.setVisible(true);
	}

	public void jogarLixo() {

		lixo.btnLixo = new Button("LIXO");
		lixo.setPosicaoX(dirtyman.getPosicaoX());
		lixo.setPosicaoY(dirtyman.getPosicaoY());

		// Como o Ecoman tem os passos de tamanho "10" então, a posição do lixo
		// precisa
		// ser divisível por 10

		while (lixo.getPosicaoX() % 10 != 0) {
			lixo.setPosicaoX(lixo.getPosicaoX() + 1);
		}

		while (lixo.getPosicaoY() % 10 != 0) {
			lixo.setPosicaoY(lixo.getPosicaoY() + 1);
		}

		lixo.btnLixo.setBounds(lixo.getPosicaoX(), lixo.getPosicaoY(), lixo.getLargura(), lixo.getAltura());

		listaLixos.add(lixo.btnLixo);
		this.add(lixo.btnLixo);
	}

	public void ativarTelaGameOver() {

		telaGameOver = new TelaGameOver();
		telaGameOver.setVisible(true);
	}

	public static void setInstance(TelaPrincipal novaTelaPrincipal) {

		instancia = novaTelaPrincipal;
	}

	public void setPlanoDeFundo(BufferedImage fundoTelaPrincipal) {

		Image img = fundoTelaPrincipal;
		background.setIcon(new ImageIcon(img));
	}
}
