package Controles;

import java.awt.Button;
import java.awt.event.KeyEvent;
import java.util.Vector;

import Constantes.ConstantesGerais;
import ImagemData.EcomanImagemData;
import Objetos.Lixeira;
import Objetos.LixeiraData;
import Personagens.Dirtyman;
import Personagens.Ecoman;
import Telas.TelaPrincipal;
import Validacoes.ValidacoesMapa;

public class ControleEcoman {

	private Dirtyman dirtyman;
	private Ecoman ecoman;
	private LixeiraData lixeiraData;
	private Vector<Button> mochila;
	private TelaPrincipal telaPrincipal;
	private ControleDirtyMan ctrlDirtyMan;
	private static ControleEcoman instancia;
	private ValidacoesMapa validacoesMapa;
	private EcomanImagemData imagemData;
	private int contadorPassosDireita = 0;
	private int contadorPassosEsquerda = 0;
	private int contadorPassosCima = 0;
	private int contadorPassosBaixo = 0;

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
		dirtyman = Dirtyman.getInstance();
		ctrlDirtyMan = ControleDirtyMan.getInstance();
		lixeiraData = new LixeiraData();
		telaPrincipal = TelaPrincipal.getInstance();
		mochila = telaPrincipal.listaLixos;
		validacoesMapa = new ValidacoesMapa();
		imagemData = EcomanImagemData.getInstance();
	}

	public void movimentarEcoman(KeyEvent ke) {

		if (ke.getKeyCode() == KeyEvent.VK_UP) {

			adverterDirtyman();
			if (validacoesMapa.autorizarCaminhadaCima(ecoman)) {
				ecoman.setPosicaoY(ecoman.getPosicaoY() - ecoman.getTamanhoPasso());
				mudarImagemCima();
				alterarPosicaoEcoman();
				contadorPassosCima++;
			}

		} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {

			adverterDirtyman();
			if (validacoesMapa.autorizarCaminhadaBaixo(ecoman)) {
				ecoman.setPosicaoY(ecoman.getPosicaoY() + ecoman.getTamanhoPasso());
				mudarImagemBaixo();
				alterarPosicaoEcoman();
				contadorPassosBaixo++;
			}
		} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {

			adverterDirtyman();
			if (validacoesMapa.autorizarCaminhadaDireita(ecoman)) {
				ecoman.setPosicaoX(ecoman.getPosicaoX() + ecoman.getTamanhoPasso());
				mudarImagemDireita();
				alterarPosicaoEcoman();
				contadorPassosDireita++;
			}
		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {

			adverterDirtyman();
			if (validacoesMapa.autorizarCaminhadaEsquerda(ecoman)) {
				ecoman.setPosicaoX(ecoman.getPosicaoX() - ecoman.getTamanhoPasso());
				mudarImagemEsquerda();
				alterarPosicaoEcoman();
				contadorPassosEsquerda++;
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_SPACE) {

			Lixeira lixeira = lixeiraData.getLixeira(ecoman.getPosicaoX(), ecoman.getPosicaoY());
			if (checarProximidade(ecoman.getTamanhoPassoCompensadoEixoX(), lixeira.getPosicaoX(), false)
					&& checarProximidade(ecoman.getTamanhoPassoCompensadoEixoY(), lixeira.getPosicaoY(), true)) {

				if (ecoman.estaCarregandoLixo()) {

					telaPrincipal.setPontuacao(100);

					if (mochila.isEmpty()) {
						telaPrincipal.ativarTelaVenceuJogo();
					}
				}
				ecoman.setCarregandoLixo(false);
			}
		}
	}

	private void mudarImagemDireita() {

		int passos = contadorPassosDireita % 4;

		switch (passos) {

		case 0:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[0]);
			break;

		case 1:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[1]);
			break;

		case 2:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[0]);
			break;

		case 3:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[2]);
			break;

		}
	}

	private void mudarImagemEsquerda() {

		int passos = contadorPassosEsquerda % 4;

		switch (passos) {

		case 0:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[6]);
			break;

		case 1:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[7]);
			break;

		case 2:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[6]);
			break;

		case 3:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[8]);
			break;

		}
	}

	private void mudarImagemCima() {

		int passos = contadorPassosCima % 4;

		switch (passos) {

		case 0:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[9]);
			break;

		case 1:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[10]);
			break;

		case 2:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[9]);
			break;

		case 3:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[11]);
			break;
		}
	}

	private void mudarImagemBaixo() {

		int passos = contadorPassosBaixo % 4;

		switch (passos) {

		case 0:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[3]);
			break;

		case 1:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[4]);
			break;

		case 2:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[3]);
			break;

		case 3:
			ecoman.ecoImage.setIcon(imagemData.recuperarImagens()[5]);
			break;

		}
	}

	private void alterarPosicaoEcoman() {

		ecoman.ecoImage.setBounds(ecoman.getPosicaoX(), ecoman.getPosicaoY(), ecoman.getLargura(), ecoman.getAltura());
		if (ecoman.estaCarregandoLixo())
			telaPrincipal.mostrarCarregandoLixo(true);

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

	private boolean checarProximidade(float posicaoEcoman, float posicaoAlvo) {

		// Verifica se a aproximação entre o Ecoman e o Alvo é suficiente para
		// capturá-lo ou pará-lo
		return Math.abs((long) posicaoEcoman - posicaoAlvo) <= ConstantesGerais.DISTANCIA_JOGAR_LIXO;
	}

	private boolean checarProximidade(float posicaoEcoman, float posicaoAlvo, boolean distante) {

		if (distante)
			return Math.abs((long) posicaoEcoman - posicaoAlvo) <= 25.5f;

		return Math.abs((long) posicaoEcoman - posicaoAlvo) <= ConstantesGerais.DISTANCIA_JOGAR_LIXO;
	}

	private void adverterDirtyman() {

		if (checarProximidade(ecoman.getPosicaoX(), dirtyman.getPosicaoX())
				&& checarProximidade(ecoman.getPosicaoY(), dirtyman.getPosicaoY())) {
			ctrlDirtyMan.setSituacaoMovimentacao(false);
			telaPrincipal.mostrarAdvertenciaEcologica(true);
		}
	}

	public static void setInstance(ControleEcoman novoControleEcoman) {
		instancia = novoControleEcoman;
	}
}
