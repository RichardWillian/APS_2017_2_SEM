package Controles;

import Telas.TelaPrincipal;

public class Cronometro extends Thread {
	// TA ERRADO SAPORRA
	TelaPrincipal telaPrincipal;
	
	public int cronometro1;

	public Cronometro() {

		cronometro1 = 60;
	}

	@Override
	public void run() {
		telaPrincipal = TelaPrincipal.getInstance();
		while (cronometro1 > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cronometro1--;

			telaPrincipal.lblTempo.setText("TEMPO: "+cronometro1+"s");
		}
	}

}
