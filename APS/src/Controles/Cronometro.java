package Controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.sun.javafx.font.Disposer;

import Telas.JanelaBase;
import Telas.MenuPrincipal;
import Telas.TelaPrincipal;

public class Cronometro extends Thread {
	// TA ERRADO SAPORRA
	TelaPrincipal telaPrincipal;

	MenuPrincipal menuPrincipal;

	public int cronometro1;

	public Cronometro() {

		cronometro1 = 60;
	}

	@Override
	public void run() {
		telaPrincipal = TelaPrincipal.getInstance();

		while (cronometro1 > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cronometro1--;

			telaPrincipal.lblTempo.setText("TEMPO: " + cronometro1 + "s");
			if (cronometro1 == 0) {
				int result = JOptionPane.showConfirmDialog(null, "Voce PERDEU ! Deseja jogar denovo ?", null,
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					telaPrincipal.dispose();
					


					// for (int cronometro = 0; cronometro < 3; cronometro++) {
					// try {
					// Thread.sleep(1000);
					// } catch (InterruptedException e) {
					// e.printStackTrace();
					// }
					// }

				} else {
					System.exit(0);
				}
			}

		}

	}

}
