package controles;

import data.MensagemData;
import telas.TelaPrincipal;

public class Cronometro extends Thread {

	TelaPrincipal telaPrincipal;

	private static final int TEMPO = 5;
	private static final int TEMPO_BONUS = 4;

	public static int tempo;
	private static Cronometro instancia;
	private static boolean ganhou = false;

	Cronometro() {

		tempo = TEMPO;
	}

	public void pararCronometro() {
		ganhou = true;
	}

	public void restart() {
		ganhou = false;
	}

	@Override
	public void run() {
		telaPrincipal = TelaPrincipal.getInstance();
		boolean movimentarSetas = false;
		while (tempo > 0) {

			if (ganhou)
				return;

			telaPrincipal.setTextLabelTempo(tempo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if ((MensagemData.getInstance().isMensagemOn()) && (tempo % 10 == 0)) {
				MensagemData.getInstance().desligarMensagem();
				TelaPrincipal.getInstance().mostrarAdvertenciaEcologica(false, 0);
			}

			if (tempo > TEMPO - 10) {

				if (movimentarSetas) {
					TelaPrincipal.getInstance().movimentarSetaLixeira(movimentarSetas);
					movimentarSetas = false;
				} else{
					
					TelaPrincipal.getInstance().movimentarSetaLixeira(movimentarSetas);
					movimentarSetas = true;
				}
			}else
				TelaPrincipal.getInstance().retirarSetaLixeira();

			tempo--;
		}

		telaPrincipal.setTextLabelTempo(tempo);
		telaPrincipal.ativarTelaGameOver();

		ControleDirtyMan.getInstance().pararDirtyMan();

		return;
	}

	public void iniciarCronometro() {

		Cronometro cronometro = new Cronometro();
		cronometro.start();
	}

	public static Cronometro getInstance() {

		if (instancia == null)
			instancia = new Cronometro();

		return instancia;
	}

	public static void aumentarTempo() {
		tempo += TEMPO_BONUS;
	}

	public static void setInstance(Cronometro cronometro) {
		instancia = cronometro;
	}
}
