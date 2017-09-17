import java.awt.EventQueue;

import Telas.MenuPincipal;
import Telas.TelaInstrucoes;
import Telas.TelaPrincipal;

public class ProgramaPrincipal {
	
	public static void main (String args[]){
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPincipal frame = new MenuPincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
}
