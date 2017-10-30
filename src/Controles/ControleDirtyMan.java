package Controles;

import java.util.Random;

import Constantes.ConstantesGerais;
import ImagemData.DirtymanImagemData;
import Personagens.Dirtyman;
import Telas.TelaPrincipal;
import Validacoes.ValidacoesMapa;

@SuppressWarnings("unused")
public class ControleDirtyMan extends Thread {

	private ConstantesGerais constantes; // Classe com todas as contantes que
											// serão usadas no código
	private TelaPrincipal telaPrincipal;
	private boolean podeSeMovimentar; // Indica se o DirtyMan pode ou não se
										// movimentar
	private int contadorCriarLixo;
	private Dirtyman dirtyman;
	private static ControleDirtyMan instancia;
	private ValidacoesMapa validacoesMapa;
	private DirtymanImagemData imagemData;
	private int contadorElseDireita = 0;
	private int contadorElseEsquerda = 0;
	private int contadorElseCima = 0;
	private int contadorElseBaixo = 0;
	private static final int TEMPO_ESPERA_CAMINHAR = 60;
	private static final int QTDE_PASSOS_JOGAR_LIXO = 163;

	public ControleDirtyMan() {

		instanciarObjetos();
		podeSeMovimentar = true;
	}

	@Override
	public void run() {

		while (true) {

			if (podeSeMovimentar)
				movimentarDirtyMan();
			else {
				for (int cronometro = 0; cronometro < 3; cronometro++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				telaPrincipal = TelaPrincipal.getInstance();
				podeSeMovimentar = true;
				telaPrincipal.mostrarAdvertenciaEcologica(false);
			}
		}
	}

	private void movimentarDirtyMan() {

		int qtdePassosAleatorios = new Random().nextInt(100) + 5;
		int sentido = new Random().nextInt(4);
		int qtdePassos = new Random().nextInt(70) + 5;// O "+ 5" infere que,
														// no mínimo o DirtyMan
														// andará 5 passos para
														// qualquer um dos
														// sentidos
		int contadorPassos = 0;

		switch (sentido) {
		case ConstantesGerais.CIMA:
			andarParaCima(qtdePassos, contadorPassos);
			break;
		case ConstantesGerais.BAIXO:
			andarParaBaixo(qtdePassos, contadorPassos);
			break;
		case ConstantesGerais.ESQUERDA:
			andarParaEsquerda(qtdePassos, contadorPassos);
			break;
		case ConstantesGerais.DIREITA:
			andarParaDireita(qtdePassos, contadorPassos);
			break;

		default:
			break;
		}
	}

	private void andarParaDireita(int qtdePassos, int contadorPassos) {

		int contadorPassosDireita = 0;
		while (contadorPassos <= qtdePassos) {

			if (podeSeMovimentar) {
				if (validacoesMapa.autorizarCaminhadaDireita(dirtyman)) {

					dirtyman.setPosicaoX(dirtyman.getPosicaoX() + dirtyman.getTamanhoPasso());
					mudarImagemDireita(contadorPassosDireita);
					contadorPassosDireita++;
					if (dirtyman.getPosicaoX() >= 960 - dirtyman.getLargura()) {

						andarParaBaixo(qtdePassos, contadorPassos);
						break;
					}
					caminharDirtyMan();
					contadorPassos++;
					contadorElseDireita = 0;
				} else {
					contadorElseDireita++;
					dirtyman.setPosicaoX(dirtyman.getPosicaoX() - dirtyman.getTamanhoPasso());
					if (contadorElseDireita < 3)
						andarParaBaixo(qtdePassos, contadorPassos);
					else
						andarParaEsquerda(qtdePassos, contadorPassos);

					break;
				}
			} else
				break;
		}
	}

	private void andarParaEsquerda(int qtdePassos, int contadorPassos) {

		int contadorPassosEsquerda = 0;
		while (contadorPassos <= qtdePassos) {

			if (podeSeMovimentar) {
				if (validacoesMapa.autorizarCaminhadaEsquerda(dirtyman)) {

					dirtyman.setPosicaoX(dirtyman.getPosicaoX() - dirtyman.getTamanhoPasso());
					mudarImagemEsquerda(contadorPassosEsquerda);
					contadorPassosEsquerda++;
					if (dirtyman.getPosicaoX() <= 40) {
						andarParaCima(qtdePassos, contadorPassos);
						break;
					}
					caminharDirtyMan();
					contadorPassos++;
					contadorElseEsquerda = 0;
				} else {

					contadorElseEsquerda++;
					dirtyman.setPosicaoX(dirtyman.getPosicaoX() + dirtyman.getTamanhoPasso());

					if (contadorElseEsquerda < 3)
						andarParaCima(qtdePassos, contadorPassos);
					else
						andarParaDireita(qtdePassos, contadorPassos);
					break;
				}
			} else
				break;
		}
	}

	private void andarParaBaixo(int qtdePassos, int contadorPassos) {
		int contadorPassosBaixo = 0;
		while (contadorPassos <= qtdePassos) {

			if (podeSeMovimentar) {
				if (validacoesMapa.autorizarCaminhadaBaixo(dirtyman)) {

					dirtyman.setPosicaoY(dirtyman.getPosicaoY() + dirtyman.getTamanhoPasso());
					mudarImagemBaixo(contadorPassosBaixo);
					contadorPassosBaixo++;
					if (dirtyman.getPosicaoY() >= 660 - dirtyman.getAltura()) {
						andarParaEsquerda(qtdePassos, contadorPassos);
						break;
					}
					caminharDirtyMan();
					contadorPassos++;
					contadorElseBaixo = 0;
				} else {
					contadorElseBaixo++;
					dirtyman.setPosicaoY(dirtyman.getPosicaoY() - dirtyman.getTamanhoPasso());

					if (contadorElseBaixo < 2)
						andarParaDireita(qtdePassos, contadorPassos);
					else
						andarParaCima(qtdePassos, contadorPassos);

					break;
				}
			} else
				break;
		}
	}

	private void andarParaCima(int qtdePassos, int contadorPassos) {

		int contadorPassosCima = 0;
		while (contadorPassos <= qtdePassos) {

			if (podeSeMovimentar) {
				if (validacoesMapa.autorizarCaminhadaCima(dirtyman)) {

					dirtyman.setPosicaoY(dirtyman.getPosicaoY() - dirtyman.getTamanhoPasso());

					mudarImagemCima(contadorPassosCima);
					contadorPassosCima++;
					if (dirtyman.getPosicaoY() <= 70) {
						andarParaDireita(qtdePassos, contadorPassos);
						break;
					}
					caminharDirtyMan();
					contadorPassos++;
					contadorElseCima = 0;
				} else {
					contadorElseCima++;
					dirtyman.setPosicaoY(dirtyman.getPosicaoY() + dirtyman.getTamanhoPasso());

					if (contadorElseCima < 2)
						andarParaDireita(qtdePassos, contadorPassos);
					else
						andarParaBaixo(qtdePassos, contadorPassos);

					break;
				}
			} else
				break;
		}
	}

	private void caminharDirtyMan() {

		dirtyman.mudarPosicao();
		setTempoEspera();
		contadorCriarLixo++;

		if (contadorCriarLixo % QTDE_PASSOS_JOGAR_LIXO == 0)
			jogarLixo();
	}

	private void jogarLixo() {

		dirtyman.jogarLixo();
		contadorCriarLixo = 0;
	}

	private void setTempoEspera() {
		try {
			Thread.sleep(TEMPO_ESPERA_CAMINHAR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void instanciarObjetos() {

		constantes = new ConstantesGerais();
		dirtyman = Dirtyman.getInstance();
		validacoesMapa = new ValidacoesMapa();
		imagemData = DirtymanImagemData.getInstance();
	}

	public boolean recuperarSituacaoMovimentacao() {
		return podeSeMovimentar;
	}

	public void setSituacaoMovimentacao(boolean podeSeMovimentar) {
		this.podeSeMovimentar = podeSeMovimentar;
	}

	public static ControleDirtyMan getInstance() {

		if (instancia == null)
			instancia = new ControleDirtyMan();

		return instancia;
	}

	public static void setInstance(ControleDirtyMan novoControleDirtyMan) {

		instancia = novoControleDirtyMan;
	}

	private void mudarImagemDireita(int contadorPassosDireita) {

		int passos = contadorPassosDireita % 4;

		switch (passos) {

		case 0:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[0]);// Direita
																			// 1
			break;

		case 1:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[1]);// Direita
																			// 2
			break;

		case 2:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[0]);// Direita
																			// 1
			break;

		case 3:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[2]);// Direita
																			// 3
			break;

		}
	}

	private void mudarImagemEsquerda(int contadorPassosEsquerda) {

		int passos = contadorPassosEsquerda % 4;

		switch (passos) {

		case 0:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[6]);// Esquerda
																			// 1
			break;

		case 1:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[7]);// Esquerda
																			// 2
			break;

		case 2:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[6]);// Esquerda
																			// 1
			break;

		case 3:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[8]);// Esquerda
																			// 3
			break;

		}
	}

	private void mudarImagemCima(int contadorPassosCima) {

		int passos = contadorPassosCima % 4;

		switch (passos) {

		case 0:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[9]);// Cima
																			// 1
			break;

		case 1:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[10]);// Cima
																			// 2
			break;

		case 2:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[9]);// Cima
																			// 1
			break;

		case 3:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[11]);// Cima
																			// 3
			break;
		}
	}

	private void mudarImagemBaixo(int contadorPassosBaixo) {

		int passos = contadorPassosBaixo % 4;

		switch (passos) {

		case 0:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[3]);// Baixo
																			// 1
			break;

		case 1:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[4]);// Baixo
																			// 2
			break;

		case 2:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[3]);// Baixo
																			// 1
			break;

		case 3:
			dirtyman.dirtyImage.setIcon(imagemData.recuperarImagens()[5]);// Baixo
																			// 3
			break;

		}

	}
}
