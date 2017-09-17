package Controles;

import Telas.TelaPrincipal;

public class Cronometro extends Thread {
	// TA ERRADO SAPORRA
	TelaPrincipal telaPrincipal;
	
	public int cronometro;

	public Cronometro() {

		cronometro = 60;
	}

	@Override
	public void run() {
		telaPrincipal = TelaPrincipal.getInstance();
		while (cronometro > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cronometro--;

			telaPrincipal.lblTempo.setText("TEMPO: "+cronometro+"s");
		}
	}

}
