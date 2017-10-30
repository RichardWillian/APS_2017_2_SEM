package Telas;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Constantes.ConstantesMensagens;
import Controles.ControleEcoman;
import Objetos.Lixo;
import Personagens.Dirtyman;
import Personagens.Ecoman;
import Personagens.Validavel;

@SuppressWarnings("serial")
public class TelaPrincipal extends JanelaBase {

	private Dirtyman dirtyman;
	private Ecoman ecoman;
	private Lixo lixo;
	private ControleEcoman ctrlEcoman;
	private TelaGameOver telaGameOver;
	private TelaVenceuJogo telaVenceuJogo;
	public Vector<Button> listaLixos;

	private Label lblPontuacao;

	public Label eixoX;
	public Label eixoY;

	public Label eixoEcoX;
	public Label eixoEcoY;

	private Integer pontuacao = 0;
	private JLabel background;
	private JLabel detalhesBackground;

	private Label lblTempo;
	private Label lblAlertaCarregandoLixo;
	private Label lblAdvertencia;

	private static TelaPrincipal instancia;

	public TelaPrincipal() {

		instanciarObjetos();
		instanciarComponentes();
		setPropriedadesjanela();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}

	private void setPropriedadesComponentes() {
		lblTempo.setBounds(1065, 40, 70, 12);
		lblPontuacao.setBounds(1000, 90, 110, 15);
		lblAlertaCarregandoLixo.setBounds(1000, 115, 150, 15);
		lblAdvertencia.setBounds(1000, 140, 200, 40);
		background.setBounds(0, 0, 1000, getHeight());
		detalhesBackground.setBounds(0, 0, 1000, getHeight());
		ecoman.ecoImage.setBounds(ecoman.getPosicaoX(), ecoman.getPosicaoY(), ecoman.getLargura(), ecoman.getAltura());
		eixoX.setBounds(1065, 180, 100, 40);
		eixoY.setBounds(1065, 240, 100, 40);

		eixoEcoX.setBounds(1065, 300, 100, 40);
		eixoEcoY.setBounds(1065, 360, 100, 40);
	}

	private void instanciarComponentes() {
		lblTempo = new Label();
		lblPontuacao = new Label("PONTUAÇÃO: 0");
		lblAdvertencia = new Label();
		lblAlertaCarregandoLixo = new Label("CARREGANDO LIXO...");
		background = new JLabel();
		detalhesBackground = new JLabel();
		eixoX = new Label();
		eixoY = new Label();

		eixoEcoX = new Label();
		eixoEcoY = new Label();
	}

	private void adicionarComponentesTela() {

		this.add(detalhesBackground);
		this.add(ecoman.ecoImage);
		this.add(dirtyman.dirtyImage);

		this.add(lblPontuacao);
		this.add(lblTempo);

		this.add(lblAlertaCarregandoLixo);
		lblAlertaCarregandoLixo.setVisible(false);

		this.add(lblAdvertencia);
		lblAdvertencia.setVisible(false);

		this.add(background);
		this.setComponentZOrder(background, 5);

		this.add(eixoX);
		this.add(eixoY);

		this.add(eixoEcoX);
		this.add(eixoEcoY);
	}

	private void setPropriedadesjanela() {

		this.setLocation(150, 25);
		this.setSize(1200, 700);
		this.setVisible(true);
		this.setFocusable(true);
		this.setResizable(false);
	}

	private void instanciarObjetos() {

		dirtyman = Dirtyman.getInstance();
		ecoman = Ecoman.getInstance();
		listaLixos = new Vector<Button>();
		lixo = new Lixo();
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

		Integer x = ecoman.ecoImage.getBounds().x + 30;
		eixoEcoX.setText(x.toString());

		Integer y = ecoman.ecoImage.getBounds().y + 50;
		eixoEcoY.setText(y.toString());
	}

	public void mostrarAdvertenciaEcologica(boolean mostrarAdvertencia) {

		if (mostrarAdvertencia)
			lblAdvertencia.setText(ConstantesMensagens.ADVERTENCIA_ECOLOGICA_1);

		lblAdvertencia.setVisible(mostrarAdvertencia);
	}

	public void jogarLixo(int posicaoX, int posicaoY) {

		lixo.btnLixo = new Button("LIXO");
		lixo.btnLixo.setBounds(posicaoX, posicaoY, lixo.getLargura(), lixo.getAltura());

		listaLixos.add(lixo.btnLixo);

		this.add(lixo.btnLixo);
		this.setComponentZOrder(lixo.btnLixo, 0);
	}

	public void ativarTelaGameOver() {

		telaGameOver = new TelaGameOver();
		telaGameOver.setVisible(true);
		this.dispose();
	}

	public static void setInstance(TelaPrincipal novaTelaPrincipal) {

		instancia = novaTelaPrincipal;
	}

	public void setPlanoDeFundo(ImageIcon fundoTelaPrincipal) {

		background.setIcon(fundoTelaPrincipal);
	}

	public void setTextLabelTempo(Integer segundos) {

		lblTempo.setText("TEMPO: " + segundos.toString() + "s");
	}

	public void mostrarCarregandoLixo(boolean carregandoLixo) {

		lblAlertaCarregandoLixo.setVisible(carregandoLixo);
	}

	public void setPontuacao(Integer pontos) {

		pontuacao += pontos;
		lblPontuacao.setText("PONTUAÇÃO: " + pontuacao.toString());
	}

	public void setDetalhesBackground(ImageIcon detalhesBackground) {
		this.detalhesBackground.setIcon(detalhesBackground);
	}

	public void elevarNivelSilhuetaPersonagem(Validavel personagem) {

		if (personagem.equals(Ecoman.getInstance()))
			this.setComponentZOrder(ecoman.ecoImage, 0);
		else
			this.setComponentZOrder(dirtyman.dirtyImage, 0);
	}

	public void descenderNivelSilhuetaPersonagem(Validavel personagem) {

		if (personagem.equals(Ecoman.getInstance()))
			this.setComponentZOrder(ecoman.ecoImage, 3);
		else
			this.setComponentZOrder(dirtyman.dirtyImage, 3);
	}

	public void iniciarNivelPersonagens() {

		this.setComponentZOrder(ecoman.ecoImage, 3);
		this.setComponentZOrder(dirtyman.dirtyImage, 3);
	}

	public void ativarTelaVenceuJogo() {

		telaVenceuJogo = new TelaVenceuJogo();
		telaVenceuJogo.setVisible(true);
		this.dispose();
	}
}
