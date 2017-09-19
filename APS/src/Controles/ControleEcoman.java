package Controles;

import java.awt.Button;
import java.awt.event.KeyEvent;
import java.util.Vector;

import Constantes.ConstantesGerais;
import Objetos.Lixeira;
import Objetos.Lixo;
import Personagens.DirtyMan;
import Personagens.Ecoman;
import Telas.MenuPincipal;
import Telas.TelaPrincipal;

public class ControleEcoman {

	DirtyMan dirtyman;
	Ecoman ecoman;
	Lixeira lixeira;
	Lixo lixo;
	Vector<Button> mochila;
	TelaPrincipal telaPrincipal;
	ControleDirtyMan ctrlDirtyMan;
	MenuPincipal menuPrincipal;
	static ControleEcoman instancia;

	public ControleEcoman() {

		instanciarObjetos();
	}

	public static ControleEcoman getInstance(){
		
		if(instancia == null)
			instancia = new ControleEcoman();
		
		return instancia;
	}
	
	private void instanciarObjetos() {

		ecoman = Ecoman.getInstance();
		dirtyman = DirtyMan.getInstance();
		ctrlDirtyMan = ControleDirtyMan.getInstance();
		lixeira = Lixeira.getInstance();
		lixo = Lixo.getInstance();
		telaPrincipal = TelaPrincipal.getInstance();
		mochila = telaPrincipal.listaLixos;
		menuPrincipal = MenuPincipal.getInstance();
	}

	public void movimentarEcoman(KeyEvent ke) {
		
		if (ke.getKeyCode() == KeyEvent.VK_UP) {

			adverterDirtyman();
			if (ecoman.getPosicaoY() > 70) {
				ecoman.setPosicaoY(ecoman.getPosicaoY() - ConstantesGerais.TAMANHO_PASSO_ECOMAN);
				alterarPosicaoEcoman();
			}

		} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {

			adverterDirtyman();
			if (ecoman.getPosicaoY() < 600) {
				ecoman.setPosicaoY(ecoman.getPosicaoY() + ConstantesGerais.TAMANHO_PASSO_ECOMAN);
				alterarPosicaoEcoman();
			}
		} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {

			adverterDirtyman();
			if (ecoman.getPosicaoX() < 900) {
				ecoman.setPosicaoX(ecoman.getPosicaoX() + ConstantesGerais.TAMANHO_PASSO_ECOMAN);
				alterarPosicaoEcoman();
			}
		} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {

			adverterDirtyman();
			if (ecoman.getPosicaoX() > 40) {
				ecoman.setPosicaoX(ecoman.getPosicaoX() - ConstantesGerais.TAMANHO_PASSO_ECOMAN);
				alterarPosicaoEcoman();
			}
		}

		if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
			if (ecoman.getPosicaoX() == lixeira.getPosicaoX() && ecoman.getPosicaoY() == lixeira.getPosicaoY()) {

				if (ecoman.estaCarregandoLixo()) {
					telaPrincipal.pontos += 100;
					telaPrincipal.lblPontuacao.setText("PONTUAÇÃO: " + telaPrincipal.pontos);
					verificarFimPartida();
				}
				ecoman.setCarregandoLixo(false);
			}
		}
	}

	private void verificarFimPartida() {
		
		if(mochila.size() == 0){
			menuPrincipal.setVisible(true);

			telaPrincipal.dispose();
		}
		
	}

	private void alterarPosicaoEcoman() {

		ecoman.btnEcoman.setBounds(ecoman.getPosicaoX(), ecoman.getPosicaoY(), ecoman.getLargura(), ecoman.getAltura());
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
}
