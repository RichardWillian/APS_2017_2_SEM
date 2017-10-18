package Controles;

import java.awt.Button;
import java.awt.event.KeyEvent;
import java.util.Vector;

import Constantes.ConstantesGerais;
import Imagens.EcomanImagemData;
import Objetos.Lixeira;
import Objetos.Lixo;
import Personagens.DirtyMan;
import Personagens.Ecoman;
import Telas.TelaPrincipal;
import Validacoes.ValidacoesMapa;

public class ControleEcoman {

	DirtyMan dirtyman;
	Ecoman ecoman;
	Lixeira lixeira;
	Lixo lixo;
	Vector<Button> mochila;
	TelaPrincipal telaPrincipal;
	ControleDirtyMan ctrlDirtyMan;
	static ControleEcoman instancia;
	ValidacoesMapa validacoesMapa;
	EcomanImagemData imagemData;
	int contadorPassosDireita = 0;
	int contadorPassosEsquerda = 0;
	int contadorPassosCima = 0;
	int contadorPassosBaixo = 0;

	public ControleEcoman() {

		instanciarObjetos();
	}

	public static ControleEcoman getInstance() {

		if (instancia == null)
			instancia = new ControleEcoman();

		return instancia;
	}

	private void instanciarObjetos() {

		ecoman = Ecoman.getInstance();
		dirtyman = DirtyMan.getInstance();
		ctrlDirtyMan = ControleDirtyMan.getInstance();
		lixeira = new Lixeira();
		lixo = new Lixo();
		telaPrincipal = TelaPrincipal.getInstance();
		mochila = telaPrincipal.listaLixos;
		validacoesMapa = new ValidacoesMapa();
		imagemData = new EcomanImagemData();
	}

	public void movimentarEcoman(KeyEvent ke) {

		if (ke.getKeyCode() == KeyEvent.VK_UP) {

			adverterDirtyman();
			if (validacoesMapa.autorizarCaminhadaCima(ecoman)) {
				ecoman.setPosicaoY(ecoman.getPosicaoY() - ConstantesGerais.TAMANHO_PASSO_ECOMAN);
				mudarImagemCima();
				alterarPosicaoEcoman();
				contadorPassosCima++;
			}

		} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {

			adverterDirtyman();
			if (validacoesMapa.autorizarCaminhadaBaixo(ecoman)) {
				ecoman.setPosicaoY(ecoman.getPosicaoY() + ConstantesGerais.TAMANHO_PASSO_ECOMAN);
				mudarImagemBaixo();
				alterarPosicaoEcoman();
				contadorPassosBaixo++;
			}
		} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {

			adverterDirtyman();
			if (validacoesMapa.autorizarCaminhadaDireita(ecoman)) {
				ecoman.setPosicaoX(ecoman.getPosicaoX() + ConstantesGerais.TAMANHO_PASSO_ECOMAN);
				mudarImagemDireita();
				alterarPosicaoEcoman();
				contadorPassosDireita++;
			}
		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {

			adverterDirtyman();
			if (validacoesMapa.autorizarCaminhadaEsquerda(ecoman)) {
				ecoman.setPosicaoX(ecoman.getPosicaoX() - ConstantesGerais.TAMANHO_PASSO_ECOMAN);
				mudarImagemEsquerda();
				alterarPosicaoEcoman();
				contadorPassosEsquerda++;
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
			if (checarProximidade(ecoman.getPosicaoX(), lixeira.getPosicaoX())
					&& checarProximidade(ecoman.getPosicaoY(), lixeira.getPosicaoY())) {
				if (ecoman.estaCarregandoLixo()) {
					telaPrincipal.pontos += 100;
					telaPrincipal.lblPontuacao.setText("PONTUAÇÃO: " + telaPrincipal.pontos);
				}
				ecoman.setCarregandoLixo(false);
			}
		}
	}

	private void mudarImagemDireita() {

		int passos = contadorPassosDireita % 4;

		switch (passos) {

		case 0:
			ecoman.ecoImage.setIcon(imagemData.icon1);
			break;

		case 1:
			ecoman.ecoImage.setIcon(imagemData.icon2);
			break;

		case 2:
			ecoman.ecoImage.setIcon(imagemData.icon1);
			break;

		case 3:
			ecoman.ecoImage.setIcon(imagemData.icon3);
			break;

		}
	}

	private void mudarImagemEsquerda() {

		int passos = contadorPassosEsquerda % 4;

		switch (passos) {

		case 0:
			ecoman.ecoImage.setIcon(imagemData.iconL1);
			break;

		case 1:
			ecoman.ecoImage.setIcon(imagemData.iconL2);
			break;

		case 2:
			ecoman.ecoImage.setIcon(imagemData.iconL1);
			break;

		case 3:
			ecoman.ecoImage.setIcon(imagemData.iconL3);
			break;

		}
	}

	private void mudarImagemCima() {

		int passos = contadorPassosCima % 4;

		switch (passos) {

		case 0:
			ecoman.ecoImage.setIcon(imagemData.iconC1);
			break;

		case 1:
			ecoman.ecoImage.setIcon(imagemData.iconC2);
			break;

		case 2:
			ecoman.ecoImage.setIcon(imagemData.iconC1);
			break;

		case 3:
			ecoman.ecoImage.setIcon(imagemData.iconC3);
			break;
		}
	}

	private void mudarImagemBaixo() {

		int passos = contadorPassosBaixo % 4;

		switch (passos) {

		case 0:
			ecoman.ecoImage.setIcon(imagemData.iconB1);
			break;

		case 1:
			ecoman.ecoImage.setIcon(imagemData.iconB2);
			break;

		case 2:
			ecoman.ecoImage.setIcon(imagemData.iconB1);
			break;

		case 3:
			ecoman.ecoImage.setIcon(imagemData.iconB3);
			break;

		}
	}

	private void alterarPosicaoEcoman() {

		ecoman.ecoImage.setBounds(ecoman.getPosicaoX(), ecoman.getPosicaoY(), ecoman.getLargura(), ecoman.getAltura());
		if (ecoman.estaCarregandoLixo())
			telaPrincipal.lblAlertaCarregandoLixo.setVisible(true);
		capturarLixo();
	}

	private void capturarLixo() {

		Button lixoCapturado = new Button();
		if (!mochila.isEmpty()) {

			for (Button lixo : mochila) {

				lixoCapturado = validarCaptura(lixoCapturado, lixo);
			}
			// Limpando a lista para não consumir muita memória
			mochila.remove(lixoCapturado);
		}
	}

	private Button validarCaptura(Button lixoCapturado, Button lixo) {

		if (!ecoman.estaCarregandoLixo()) {
			if (checarProximidade(ecoman.getPosicaoX(), lixo.getX())
					&& checarProximidade(ecoman.getPosicaoY(), lixo.getY())) {

				lixoCapturado = lixo;
				telaPrincipal.remove(lixo);
				ecoman.setCarregandoLixo(true);
			}
		}
		return lixoCapturado;
	}

	private boolean checarProximidade(int posicaoEcoman, int posicaoAlvo) {

		// Verifica se a aproximação entre o Ecoman e o Alvo é suficiente para
		// capturá-lo ou pará-lo
		return Math.abs((long) posicaoEcoman - posicaoAlvo) <= ConstantesGerais.DISTANCIA_CAPTURAR_LIXO;
	}

	private void adverterDirtyman() {

		if (checarProximidade(ecoman.getPosicaoX(), dirtyman.getPosicaoX())
				&& checarProximidade(ecoman.getPosicaoY(), dirtyman.getPosicaoY())) {
			ctrlDirtyMan.setSituacaoMovimentacao(false);
			telaPrincipal.mostrarAdvertenciaEcologica();
		}
	}

	public static void setInstance(ControleEcoman novoControleEcoman) {
		instancia = novoControleEcoman;
	}
}
