package Telas;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.util.Vector;

import Controles.ConstantesGerais;
import Controles.ConstantesMensagens;
import Controles.ControleDirtyMan;
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
	Vector<Button> listaLixos;
	Label lblAlertaCarregandoLixo;
	Label lblPontuacao;
	public Label lblAdvertencia;
	public Label lblTempo;
	int pontos = 0;
	static TelaPrincipal instancia = null;
	public static int recomecar;
	
	
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
		lblPontuacao.setBounds(460, 40, 120, 40);
		lblTempo.setBounds(600, 40, 150, 50);
		lblAdvertencia.setBounds(1050, 90, 200, 40);
		lblAlertaCarregandoLixo.setBounds(1050, 140, 200, 40);
	}

	private void instanciarComponentes() {
		lblTempo = new Label("TEMPO: ");
		lblPontuacao = new Label("PONTUAÇÃO: 0");
		lblAdvertencia = new Label();
		lblAlertaCarregandoLixo = new Label("Carregando lixo...");
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
	}

	private void instanciarObjetos() {
		
		dirtyman = DirtyMan.getInstance();
		ecoman = new Ecoman();
		lixeira = new Lixeira();
		ctrlDirtyman = new ControleDirtyMan();
		listaLixos = new Vector<Button>();
		lixo = new Lixo();
		ctrlCronometro = new Cronometro();
		
		
	}

	public static TelaPrincipal getInstance() {

		recomecar = 0;
		if (recomecar  == 1 || instancia == null)
			instancia = new TelaPrincipal();
			
		return instancia;
	}

	public void keyPressed(KeyEvent ke) {

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

		if (ke.getKeyCode() == KeyEvent.VK_Z) {
			if (ecoman.getPosicaoX() == lixeira.getPosicaoX() && ecoman.getPosicaoY() == lixeira.getPosicaoY()) {

				if (ecoman.estaCarregandoLixo()) {
					pontos += 100;
					lblPontuacao.setText("PONTUAÇÃO: " + pontos);
				}
				ecoman.setCarregandoLixo(false);
			}
		}

		if (ecoman.estaCarregandoLixo())
			lblAlertaCarregandoLixo.setVisible(true);
		else
			lblAlertaCarregandoLixo.setVisible(false);
	}

	private void adverterDirtyman() {

		if (checarProximidade(ecoman.getPosicaoX(), dirtyman.getPosicaoX())
				&& checarProximidade(ecoman.getPosicaoY(), dirtyman.getPosicaoY())) {

			ctrlDirtyman.setSituacaoMovimentacao(false);
			mostrarAdvertenciaEcologica();
		}
	}

	private void mostrarAdvertenciaEcologica() {

		lblAdvertencia.setText(ConstantesMensagens.ADVERTENCIA_ECOLOGICA_1);
		lblAdvertencia.setVisible(true);
	}

	private void alterarPosicaoEcoman() {

		ecoman.btnEcoman.setBounds(ecoman.getPosicaoX(), ecoman.getPosicaoY(), ecoman.getLargura(), ecoman.getAltura());
		if (ecoman.estaCarregandoLixo())
			lblAlertaCarregandoLixo.setVisible(true);
		capturarLixo();
	}

	private void capturarLixo() {

		Button lixoCapturado = new Button();
		if (!listaLixos.isEmpty()) {

			for (Button lixo : listaLixos) {

				lixoCapturado = validarCaptura(lixoCapturado, lixo);
			}
			// Limpando a lista para não consumir muita memória
			listaLixos.remove(lixoCapturado);
		}
	}

	private Button validarCaptura(Button lixoCapturado, Button lixo) {

		if (!ecoman.estaCarregandoLixo()) {
			if (checarProximidade(ecoman.getPosicaoX(), lixo.getX())
					&& checarProximidade(ecoman.getPosicaoY(), lixo.getY())) {

				lixoCapturado = lixo;
				this.remove(lixo);
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
}
