package Telas;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

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
	public int pontos = 0;

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
	}

	private void instanciarComponentes() {
		lblTempo = new Label();
		lblPontuacao = new Label("PONTUA��O: 0");
		lblAdvertencia = new Label();
		lblAlertaCarregandoLixo = new Label("CARREGANDO LIXO...");
	}

	private void adicionarComponentesTela() {
		this.add(ecoman.btnEcoman);
		this.add(dirtyman.btnDirtyman);
		this.add(lixeira.btnLixeira);
		this.add(lblPontuacao);
		this.add(lblTempo);
		this.add(lblAlertaCarregandoLixo);
		lblAlertaCarregandoLixo.setVisible(false);

		this.add(lblAdvertencia);
		lblAdvertencia.setVisible(false);
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
	}

	public void mostrarAdvertenciaEcologica() {

		lblAdvertencia.setText(ConstantesMensagens.ADVERTENCIA_ECOLOGICA_1);
		lblAdvertencia.setVisible(true);
	}

	public void jogarLixo() {

		lixo.btnLixo = new Button("LIXO");
		lixo.setPosicaoX(dirtyman.getPosicaoX());
		lixo.setPosicaoY(dirtyman.getPosicaoY());

		// Como o Ecoman tem os passos de tamanho "10" ent�o, a posi��o do lixo
		// precisa
		// ser divis�vel por 10

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

	public void ativarGameOver() {

		telaGameOver = new TelaGameOver();
		telaGameOver.setVisible(true);
	}

	public static void setInstance(TelaPrincipal novaTelaPrincipal) {

		instancia = novaTelaPrincipal;
	}

	public void setPlanoDeFundo(BufferedImage fundoTelaPrincipal) {

		this.fundoTela = fundoTelaPrincipal;
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(fundoTela, 0, 0, 1000, getHeight(), null);
	}
}
