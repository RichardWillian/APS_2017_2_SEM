package Controles;

import Telas.TelaPrincipal;

public class Cronometro extends Thread {

	TelaPrincipal telaPrincipal;

	public int tempo;

	public Cronometro() {

		tempo = 999;
	}

	@Override
	public void run() {
		telaPrincipal = TelaPrincipal.getInstance();
		while (tempo > 0) {

			telaPrincipal.setTextLabelTempo(tempo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tempo--;
		}
		
		telaPrincipal.setTextLabelTempo(tempo);
		telaPrincipal.ativarTelaGameOver();
	}
	
	public static void iniciarCronometro(){
		
		Cronometro cronometro = new Cronometro();
		cronometro.start();
	}
}
