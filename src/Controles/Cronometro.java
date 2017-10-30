package Controles;

import Telas.TelaPrincipal;

public class Cronometro extends Thread {

	TelaPrincipal telaPrincipal;

	public int tempo;
	private static Cronometro instancia;

	public Cronometro() {

		tempo = 6;
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
		ControleEncerrarJogo ctrlEncerrarJogo = new ControleEncerrarJogo();
		ctrlEncerrarJogo.encerrarJogo();
	}

	public static void iniciarCronometro() {

		Cronometro cronometro = new Cronometro();
		cronometro.start();
	}

	public static Cronometro getInstance() {

		if (instancia == null)
			instancia = new Cronometro();

		return instancia;
	}
}
