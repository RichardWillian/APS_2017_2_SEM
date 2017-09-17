package Controles;

import Telas.TelaPrincipal;

public class Cronometro extends Thread {
	
	public int cronometro = 60;

	@Override
	public void run() {
		
		while (cronometro > 0) {
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				// TODO: handle exception
			}
			cronometro --;
			
		}

	}

}
