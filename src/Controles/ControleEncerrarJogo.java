package Controles;

public class ControleEncerrarJogo {

	public void encerrarJogo() {

		ControleDirtyMan.getInstance().interrupt();
		Cronometro.getInstance().interrupt();
		ControleIniciarJogo.IniciarJogo();
	}
}
