package Controles;

import Telas.TelaPrincipal;

public class Cronometro extends Thread {

	TelaPrincipal telaPrincipal;

	public int tempo;

	public Cronometro() {

		tempo = 5030;
	}

	@Override
	public void run() {
		telaPrincipal = TelaPrincipal.getInstance();
		while (tempo > 0) {

			telaPrincipal.lblTempo.setText("TEMPO: " + tempo + "s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tempo--;
		}
		
		tempo = 0;
		telaPrincipal.lblTempo.setText("TEMPO: " + tempo + "s");
		//ControleGameOver.executarGameOver();
		telaPrincipal.ativarTelaGameOver();
	}
}
