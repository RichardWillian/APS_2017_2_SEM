package Controles;

import javax.swing.ImageIcon;

import Personagens.Dirtyman;
import Personagens.Ecoman;
import Telas.TelaPrincipal;

public class ControleIniciarJogo {

	public static void IniciarJogo(){
		
		Dirtyman.setInstance(new Dirtyman());
		Ecoman.setInstance(new Ecoman());
		ControleDirtyMan.setInstance(new ControleDirtyMan());
		TelaPrincipal.setInstance(new TelaPrincipal());
		ControleEcoman.setInstance(new ControleEcoman());
		
		IniciarThreads();
		setBackground();
		setDetalhesBackground();
	}

	private static void setDetalhesBackground() {
		
		ImageIcon detalhesBackground = new ImageIcon(ControleIniciarJogo.class.getResource("/ImagemData/Detalhes_Background.png")); 
		TelaPrincipal.getInstance().setDetalhesBackground(detalhesBackground);
	}

	private static void IniciarThreads() {
		
		ControleDirtyMan.getInstance().start();
		Cronometro.iniciarCronometro();
	}

	private static void setBackground() {
		
		ImageIcon background = new ImageIcon(ControleIniciarJogo.class.getResource("/ImagemData/Background.png")); 
		TelaPrincipal.getInstance().setPlanoDeFundo(background);
	}
}
