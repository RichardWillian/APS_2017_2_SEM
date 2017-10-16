package Controles;

import java.util.Random;

import Constantes.ConstantesGerais;
import Imagens.DirtymanImagemData;
import Personagens.DirtyMan;
import Telas.TelaPrincipal;

@SuppressWarnings("unused")
public class ControleDirtyMan extends Thread {

	private ConstantesGerais constantes; // Classe com todas as contantes que ser�o usadas no c�digo
	public TelaPrincipal telaPrincipal;
	private Random sentidoAleatorio; // Indicar� qual dire��o o DirtyMan ir� caminhar
	private Random qtdePassadasAleatorias; // Indicar� a quantidade de passadas do DirtyMan
	private boolean podeSeMovimentar; // Indica se o DirtyMan pode ou n�o se movimentar
	int contadorCriarLixo;
	DirtyMan dirtyman;
	static ControleDirtyMan instancia;
	ValidacoesMapa validacoesMapa;
	int contadorPassosDireita = 0;
	int contadorPassosEsquerda = 0;
	int contadorPassosCima = 0;
	int contadorPassosBaixo = 0;
	DirtymanImagemData imagemData;
	
	public ControleDirtyMan() {

		instanciarObjetos();
		podeSeMovimentar = true;
		contadorCriarLixo = 0;
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
				telaPrincipal.lblAdvertencia.setVisible(false);
			}
		}

	}

	private void movimentarDirtyMan() {

		int sentido = sentidoAleatorio.nextInt(4);
		int qtdePassos = qtdePassadasAleatorias.nextInt(100) + 5;// O "+ 5"
																	// infere
																	// que no
																	// m�nimo o
																	// DirtyMan
																	// andar� 5
																	// passos
																	// para
																	// qualquer
																	// um dos
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
		while (contadorPassos <= qtdePassos) {

			if (validacoesMapa.autorizarCaminhadaCima(dirtyman)) {
				dirtyman.setPosicaoX(dirtyman.getPosicaoX() + 1);
				if (dirtyman.getPosicaoX() >= 960 - dirtyman.getLargura()) {

					andarParaBaixo(qtdePassos, contadorPassos);
					break;
				}
				caminharDirtyMan();
				contadorPassos++;
			}else{
				dirtyman.setPosicaoX(dirtyman.getPosicaoX() - 1);
				andarParaEsquerda(qtdePassos, contadorPassos);
				break;
			}
		}
	}

	private void andarParaEsquerda(int qtdePassos, int contadorPassos) {
		while (contadorPassos <= qtdePassos) {

			if (validacoesMapa.autorizarCaminhadaCima(dirtyman)) {

				dirtyman.setPosicaoX(dirtyman.getPosicaoX() - 1);
				if (dirtyman.getPosicaoX() <= 40) {
					andarParaCima(qtdePassos, contadorPassos);
					break;
				}
				caminharDirtyMan();
				contadorPassos++;
			} else {

				dirtyman.setPosicaoX(dirtyman.getPosicaoX() + 1);
				andarParaDireita(qtdePassos, contadorPassos);
				break;
			}
		}
	}

	private void andarParaBaixo(int qtdePassos, int contadorPassos) {
		while (contadorPassos <= qtdePassos) {

			if (validacoesMapa.autorizarCaminhadaCima(dirtyman)) {

				dirtyman.setPosicaoY(dirtyman.getPosicaoY() + 1);
				if (dirtyman.getPosicaoY() >= 660 - dirtyman.getAltura()) {
					andarParaEsquerda(qtdePassos, contadorPassos);
					break;
				}
				caminharDirtyMan();
				contadorPassos++;
			} else {
				dirtyman.setPosicaoY(dirtyman.getPosicaoY() - 1);
				andarParaCima(qtdePassos, contadorPassos);
				break;
			}
		}
	}

	private void andarParaCima(int qtdePassos, int contadorPassos) {

		while (contadorPassos <= qtdePassos) {

			if (validacoesMapa.autorizarCaminhadaCima(dirtyman)) {

				dirtyman.setPosicaoY(dirtyman.getPosicaoY() - 1);
				if (dirtyman.getPosicaoY() <= 70) {
					andarParaDireita(qtdePassos, contadorPassos);
					break;
				}
				caminharDirtyMan();
				contadorPassos++;
			} else {
				dirtyman.setPosicaoY(dirtyman.getPosicaoY() + 1);
				andarParaBaixo(qtdePassos, contadorPassos);
				break;
			}
		}
	}

	private void caminharDirtyMan() {

		dirtyman.mudarPosicao();
		setTempoEspera();
		contadorCriarLixo++;

		if (contadorCriarLixo % 463 == 0)
			jogarLixo();
	}

	private void jogarLixo() {

		dirtyman.jogarLixo();
		contadorCriarLixo = 0;

	}

	private void setTempoEspera() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void instanciarObjetos() {

		constantes = new ConstantesGerais();
		sentidoAleatorio = new Random();
		qtdePassadasAleatorias = new Random();
		dirtyman = DirtyMan.getInstance();
		validacoesMapa = new ValidacoesMapa();
		imagemData = new DirtymanImagemData();
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
	private void mudarImagemDireita() {

		int passos = contadorPassosDireita % 4;

		switch (passos) {

		case 0:
			dirtyman.dirtyImage.setIcon(imagemData.iconD1);
			break;

		case 1:
			dirtyman.dirtyImage.setIcon(imagemData.iconD2);
			break;

		case 2:
			dirtyman.dirtyImage.setIcon(imagemData.iconD1);
			break;

		case 3:
			dirtyman.dirtyImage.setIcon(imagemData.iconD3);
			break;

		} 
	}

	private void mudarImagemEsquerda() {

		int passos = contadorPassosEsquerda % 4;

		switch (passos) {

		case 0:
			dirtyman.dirtyImage.setIcon(imagemData.iconDL1);
			break;

		case 1:
			dirtyman.dirtyImage.setIcon(imagemData.iconDL2);
			break;

		case 2:
			dirtyman.dirtyImage.setIcon(imagemData.iconDL1);
			break;

		case 3:
			dirtyman.dirtyImage.setIcon(imagemData.iconDL3);
			break;

		}
	}

	private void mudarImagemCima() {

		int passos = contadorPassosCima % 4;

		switch (passos) {

		case 0:
			dirtyman.dirtyImage.setIcon(imagemData.iconDC1);
			break;

		case 1:
			dirtyman.dirtyImage.setIcon(imagemData.iconDC2);
			break;

		case 2:
			dirtyman.dirtyImage.setIcon(imagemData.iconDC1);
			break;

		case 3:
			dirtyman.dirtyImage.setIcon(imagemData.iconDC3);
			break;
		}
	}

	private void mudarImagemBaixo() {

		int passos = contadorPassosBaixo % 4;

		switch (passos) {

		case 0:
			dirtyman.dirtyImage.setIcon(imagemData.iconDB1);
			break;

		case 1:
			dirtyman.dirtyImage.setIcon(imagemData.iconDB2);
			break;

		case 2:
			dirtyman.dirtyImage.setIcon(imagemData.iconDB1);
			break;

		case 3:
			dirtyman.dirtyImage.setIcon(imagemData.iconDB3);
			break;

		}

	}
}
