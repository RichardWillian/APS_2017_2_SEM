package Validacoes;

public class ValidacaoCaminharDireita implements IValidadorCaminhada {

	private Integer contadorDeValidacoes = 0;

	public boolean autorizarCaminhar(int localizacaoEixoX, int localizacaoEixoY) {

		CarregarValidacoes(localizacaoEixoX, localizacaoEixoY);

		if (contadorDeValidacoes.equals(0))
			return true;

		return false;
	}

	private void CarregarValidacoes(int localizacaoEixoX, int localizacaoEixoY) {

		/*
		 * Sera dividido em 3 areas a primeira rua horizontal(1º corredor), segunda
		 * rua(2º corredor) 3º(As dos cones com um buraco na rua) e o beco
		 */

		if (localizacaoEixoX <= 150)
			validaPrimeiro_quartoQuarteirao(localizacaoEixoX, localizacaoEixoY);

		if (localizacaoEixoY <= 270) {
			validarSegundo_TerceiroQuarteirao(localizacaoEixoX, localizacaoEixoY);

		} else if (localizacaoEixoY >= 320 && localizacaoEixoX <= 700) {
			validarQuintoQuarteirao(localizacaoEixoX, localizacaoEixoY);
		} else if (localizacaoEixoX >= 820 && localizacaoEixoY >= 300)
			validarSextoQuarteirao(localizacaoEixoX, localizacaoEixoY);

	}

	private void validaPrimeiro_quartoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {
		if (localizacaoEixoX == 30) {
			if (localizacaoEixoY >= 330 && localizacaoEixoY <= 340)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 70 && localizacaoEixoY == 490)
			contadorDeValidacoes++;
	}

	private void validarSegundo_TerceiroQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		/************** para eixo X > 800 Entra o 3º quarteirão ************/

		if (localizacaoEixoX == 210) {
			if (localizacaoEixoY >= 100 && localizacaoEixoY < 200)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 200) {

			if (localizacaoEixoY >= 50 && localizacaoEixoY <= 160)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 330) {
			if (localizacaoEixoY >= 190 && localizacaoEixoY < 200)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 380 || localizacaoEixoX == 560) {
			if (localizacaoEixoY >= 210 && localizacaoEixoY <= 230)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 880) {

			if (localizacaoEixoY >= 60 && localizacaoEixoY <= 220)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 980 && localizacaoEixoY == 220) {
			contadorDeValidacoes++;
		}

	}

	private void validarQuintoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY >= 540 && (localizacaoEixoX >= 520 && localizacaoEixoX <= 770))
			validarQuintoQuarteirao_A(localizacaoEixoX, localizacaoEixoY);

		if (localizacaoEixoX == 190) {
			if (localizacaoEixoY >= 370 && localizacaoEixoY <= 570)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 270 || localizacaoEixoX == 330) {
			if (localizacaoEixoY >= 560 && localizacaoEixoY <= 590)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 320) {
			if (localizacaoEixoY >= 370 && localizacaoEixoY <= 360)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 310) {
			if (localizacaoEixoY >= 370 && localizacaoEixoY <= 360)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 390) {
			if (localizacaoEixoY >= 580 && localizacaoEixoY <= 590)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 410 && localizacaoEixoY == 600) {
			contadorDeValidacoes++;
		} else if (localizacaoEixoX == 430) {
			if (localizacaoEixoY == 370)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 470) {
			if (localizacaoEixoY >= 570 && localizacaoEixoY <= 590)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 550) {
			if (localizacaoEixoY == 370)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 670) {
			if (localizacaoEixoY >= 380 && localizacaoEixoY <= 400)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 680) {
			if (localizacaoEixoY >= 380 && localizacaoEixoY <= 390)
				contadorDeValidacoes++;
		}

	}

	private void validarQuintoQuarteirao_A(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoX == 550 && localizacaoEixoY == 550) {
			contadorDeValidacoes++;

		} else if (localizacaoEixoX == 610) {
			if (localizacaoEixoY >= 570 && localizacaoEixoY <= 580)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 620) {
			if (localizacaoEixoY >= 500 && localizacaoEixoY <= 540)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 650) {
			if (localizacaoEixoY >= 580 && localizacaoEixoY <= 600)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 660 && localizacaoEixoY == 550) {
			contadorDeValidacoes++;

		} else if (localizacaoEixoX == 680) {
			if (localizacaoEixoY >= 560 && localizacaoEixoY <= 610)
				contadorDeValidacoes++;
		}
	}

	private void validarSextoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoX == 1000) {
			if (localizacaoEixoY >= 370 && localizacaoEixoY <= 390)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 880) {
			if (localizacaoEixoY >= 370 && localizacaoEixoY <= 620)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 870) {
			if (localizacaoEixoY >= 440 && localizacaoEixoY <= 460)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 830) {
			if (localizacaoEixoY >= 460 && localizacaoEixoY <= 500)

				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 970 && localizacaoEixoY == 630) {
			contadorDeValidacoes++;
		}

	}

}
