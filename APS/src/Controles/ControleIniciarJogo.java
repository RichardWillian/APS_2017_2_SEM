package Controles;

import Personagens.DirtyMan;
import Personagens.Ecoman;
import Telas.TelaPrincipal;

public class ControleIniciarJogo {

	public static void IniciarJogo(){
		

		DirtyMan.setInstance(new DirtyMan());// 1º pois não haverá problemas na ordem de chamada
		Ecoman.setInstance(new Ecoman());// 2º para não haver problemas na ordem
		ControleDirtyMan.setInstance(new ControleDirtyMan());
		TelaPrincipal.setInstance(new TelaPrincipal());
	}
}
