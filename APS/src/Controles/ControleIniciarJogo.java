package Controles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Personagens.DirtyMan;
import Personagens.Ecoman;
import Telas.TelaPrincipal;

public class ControleIniciarJogo {

	public static void IniciarJogo(){
		
		DirtyMan.setInstance(new DirtyMan());// 1º pois não haverá problemas na ordem de chamada
		Ecoman.setInstance(new Ecoman());// 2º para não haver problemas na ordem
		ControleDirtyMan.setInstance(new ControleDirtyMan());
		TelaPrincipal.setInstance(new TelaPrincipal());
		ControleEcoman.setInstance(new ControleEcoman());
		
		setImagemTela();
	}

	private static void setImagemTela() {
		
		BufferedImage fundoTelaPrincipal = null;
		try {
			fundoTelaPrincipal = ImageIO.read(new File("C:\\Users\\Seven\\Desktop\\MapaCerto.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		TelaPrincipal.getInstance().setPlanoDeFundo(fundoTelaPrincipal);
	}
}
