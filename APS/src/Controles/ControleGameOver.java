package Controles;


public class ControleGameOver {

	@SuppressWarnings("deprecation")
	public static void executarGameOver() {
		
		ControleDirtyMan.getInstance().stop();
	}
}
