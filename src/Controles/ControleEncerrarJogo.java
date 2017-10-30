package Controles;

public class ControleEncerrarJogo {

	@SuppressWarnings("deprecation")
	public void encerrarJogo() {

		ControleDirtyMan.getInstance().stop();
		Cronometro.getInstance().stop();
	}
}
