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
		
		DirtyMan.setInstance(new DirtyMan());
		Ecoman.setInstance(new Ecoman());
		ControleDirtyMan.setInstance(new ControleDirtyMan());
		TelaPrincipal.setInstance(new TelaPrincipal());
		ControleEcoman.setInstance(new ControleEcoman());
		
		setImagemTela();
	}

	private static void setImagemTela() {
		
		BufferedImage fundoTelaPrincipal = null;
		try {
			fundoTelaPrincipal = ImageIO.read(new File("C:\\Users\\Seven\\Desktop\\MapaCertoAumentado.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		TelaPrincipal.getInstance().setPlanoDeFundo(fundoTelaPrincipal);
	}
}
