package Controles;

import Telas.TelaPrincipal;

public class Cronometro extends Thread {
	
	TelaPrincipal telaPrincipal;
	
	public int tempo;

	public Cronometro() {

		tempo = 30;
	}

	@Override
	public void run() {
		
		while (tempo > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			telaPrincipal = TelaPrincipal.getInstance();
			tempo--;
			telaPrincipal.lblTempo.setText("TEMPO: "+ tempo +"s");
		}
		
		ControleGameOver.executarGameOver();
		telaPrincipal.ativarGameOver();
	}
}
