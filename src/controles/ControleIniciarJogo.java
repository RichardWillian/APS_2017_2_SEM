package controles;

import javax.swing.ImageIcon;

import data.SilhuetaImagemData;
import personagens.Dirtyman;
import personagens.Ecoman;
import telas.TelaPrincipal;

public class ControleIniciarJogo {

	public static void IniciarJogo() {

		Dirtyman.setInstance(new Dirtyman()); 
		Ecoman.setInstance(new Ecoman());
		ControleDirtyMan.setInstance(new ControleDirtyMan());
		TelaPrincipal.setInstance(new TelaPrincipal());
		ControleEcoman.setInstance(new ControleEcoman());
		Cronometro.setInstance(new Cronometro());
		
		Cronometro.getInstance().restart();
		ControleDirtyMan.getInstance().restart();

		IniciarThreads();
		setBackground();
		setDetalhesBackground();
		setNivelPersonagens();
	}

	private static void setNivelPersonagens() {

		TelaPrincipal.getInstance().iniciarNivelPersonagens();
		SilhuetaImagemData.getInstance().iniciarImagensPersonagem();
	}

	private static void setDetalhesBackground() {

		ImageIcon detalhesBackground = new ImageIcon(ControleIniciarJogo.class.getResource("/data/Detalhes_Background.png"));
		TelaPrincipal.getInstance().setDetalhesBackground(detalhesBackground);
	}

	private static void IniciarThreads() {

		ControleDirtyMan.getInstance().start();
		Cronometro.getInstance().iniciarCronometro();
	}

	private static void setBackground() {

		ImageIcon background = new ImageIcon(ControleIniciarJogo.class.getResource("/data/Background.png"));
		TelaPrincipal.getInstance().setPlanoDeFundo(background);
	}
}
