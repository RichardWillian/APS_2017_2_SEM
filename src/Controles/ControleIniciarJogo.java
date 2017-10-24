package Controles;

import javax.swing.ImageIcon;

import Personagens.DirtyMan;
import Personagens.Ecoman;
import Telas.TelaPrincipal;

public class ControleIniciarJogo {

	public static void IniciarJogo(){
		
		DirtyMan.setInstance(new DirtyMan());
		Ecoman.setInstance(new Ecoman());
		ControleDirtyMan.setInstance(new ControleDirtyMan());
		TelaPrincipal.setInstance(new TelaPrincipal());
		ControleEcoman.setInstance(new ControleEcoman());
		
		IniciarThreads();
		setImagemTela();
	}

	private static void IniciarThreads() {
		
		ControleDirtyMan.getInstance().start();
		Cronometro.iniciarCronometro();
	}

	private static void setImagemTela() {
		
		ImageIcon fundoTelaPrincipal = new ImageIcon(ControleIniciarJogo.class.getResource("/Imagens/Background.png")); 
		TelaPrincipal.getInstance().setPlanoDeFundo(fundoTelaPrincipal);
	}
}
