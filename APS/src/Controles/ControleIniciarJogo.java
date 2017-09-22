package Controles;

import Personagens.DirtyMan;
import Personagens.Ecoman;
import Telas.TelaPrincipal;

public class ControleIniciarJogo {

	public static void IniciarJogo(){
		

		DirtyMan.setInstance(new DirtyMan());// 1� pois n�o haver� problemas na ordem de chamada
		Ecoman.setInstance(new Ecoman());// 2� para n�o haver problemas na ordem
		ControleDirtyMan.setInstance(new ControleDirtyMan());
		TelaPrincipal.setInstance(new TelaPrincipal());
	}
}
