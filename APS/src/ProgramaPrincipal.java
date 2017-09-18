import java.awt.EventQueue;

import Telas.MenuPrincipal;
import Telas.TelaInstrucoes;
import Telas.TelaPrincipal;

public class ProgramaPrincipal {
	
	public static void main (String args[]){
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
}
