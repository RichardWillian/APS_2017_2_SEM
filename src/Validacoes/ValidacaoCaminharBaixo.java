package validacoes;

import data.SilhuetaImagemData;
import personagens.Validavel;

public class ValidacaoCaminharBaixo implements IValidadorCaminhada {

	private Integer contadorDeValidacoes = 0;
	private SilhuetaImagemData silhuetaImagemData = SilhuetaImagemData.getInstance();
	Validavel personagem = null;

	public boolean autorizarCaminhar(int localizacaoEixoX, int localizacaoEixoY, Validavel personagem) {

		this.personagem = personagem;
		if (!SilhuetaImagemData.getInstance().isSilhuetaOn(personagem))
			SilhuetaImagemData.getInstance().retornarImagensPersonagem(personagem);
		CarregarValidacoes(localizacaoEixoX, localizacaoEixoY);

		if (contadorDeValidacoes.equals(0))
			return true;

		return false;
	}

	private void CarregarValidacoes(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY <= 300) {

			if (localizacaoEixoX >= 20 && localizacaoEixoX <= 110)
				ValidarPrimeiroQuarteirao(localizacaoEixoX, localizacaoEixoY);

		} else if (localizacaoEixoY < 650) {

			if (localizacaoEixoX >= 20 && localizacaoEixoX <= 110)
				ValidarQuartoQuarteirao(localizacaoEixoX, localizacaoEixoY);

			else if (localizacaoEixoX >= 190 && localizacaoEixoX <= 800)
				ValidarQuintoQuarteirao(localizacaoEixoX, localizacaoEixoY);
			
			else if(localizacaoEixoX >= 880 && localizacaoEixoX <= 1020)
				ValidarSextoQuarteirao(localizacaoEixoX, localizacaoEixoY);

		} else
			validarSetimoQuarteirao(localizacaoEixoX, localizacaoEixoY);

	}

	private void ValidarSextoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {
		
		if(localizacaoEixoY == 360){
			if(localizacaoEixoX >= 890 && localizacaoEixoX <= 980)
				contadorDeValidacoes++;
			else if(localizacaoEixoX >= 1000 && localizacaoEixoX <= 1020)
				contadorDeValidacoes++;
		}
		else if(localizacaoEixoY == 400){
			if(localizacaoEixoX >= 990 && localizacaoEixoX <= 1000)
				contadorDeValidacoes++;
		}
	}

	private void validarSetimoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		validarMostrarSilhueta(localizacaoEixoX, localizacaoEixoY);
	}

	private void validarMostrarSilhueta(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY > 310 && localizacaoEixoY <= 510) {

			if (localizacaoEixoX >= 210 && localizacaoEixoX < 300) {
				silhuetaImagemData.trocarParaSilhueta(personagem);

			} else if (localizacaoEixoX > 430 && localizacaoEixoX < 530) {
				silhuetaImagemData.trocarParaSilhueta(personagem);

			} else if (localizacaoEixoX > 690 && localizacaoEixoX < 790) {

				if (localizacaoEixoY < 480)
					silhuetaImagemData.trocarParaSilhueta(personagem);
				else
					retornarImagensPersonagem(personagem);
			} else if (localizacaoEixoX > 550 && localizacaoEixoX <= 650) {

				if (localizacaoEixoY > 330 && localizacaoEixoY < 500)
					silhuetaImagemData.trocarParaSilhueta(personagem);
				else
					retornarImagensPersonagem(personagem);
			} else
				retornarImagensPersonagem(personagem);
		} else if (localizacaoEixoY >= 520 && localizacaoEixoY < 540) {

			if (localizacaoEixoX > 290 && localizacaoEixoX < 340)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else
				retornarImagensPersonagem(personagem);

		} else if (localizacaoEixoY > 530 && localizacaoEixoY < 590) {

			if (localizacaoEixoX == 740)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else
				retornarImagensPersonagem(personagem);

		} else if (localizacaoEixoY > 650 && localizacaoEixoY <= 680) {

			if (localizacaoEixoX > 730 && localizacaoEixoX <= 820)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else
				retornarImagensPersonagem(personagem);
		} else
			retornarImagensPersonagem(personagem);

	}

	private void ValidarPrimeiroQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY == 60) {
			if (localizacaoEixoX <= 80 && localizacaoEixoY == 60)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 190 && localizacaoEixoX <= 90)
			contadorDeValidacoes++;
	}

	private void ValidarQuartoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY == 320) {
			if (localizacaoEixoX >= 40 && localizacaoEixoX <= 50)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 360) {
			if (localizacaoEixoX <= 100)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 500) {
			if (localizacaoEixoX <= 100)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 530) {

			if (localizacaoEixoX <= 90)
				contadorDeValidacoes++;
		}
	}

	private void ValidarQuintoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {
		if (localizacaoEixoY == 350) {

			if (localizacaoEixoX >= 200 && localizacaoEixoX <= 290)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 360) {

			if (localizacaoEixoX >= 300 && localizacaoEixoX <= 410)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 370) {

			if (localizacaoEixoX >= 420 && localizacaoEixoX <= 430)
				contadorDeValidacoes++;
			
			else if (localizacaoEixoX >= 440 && localizacaoEixoX <= 530)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 540 && localizacaoEixoX <= 550)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 560 && localizacaoEixoX <= 590)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 610 && localizacaoEixoX <= 650)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 680 && localizacaoEixoX <= 730)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 750 && localizacaoEixoX <= 790)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 390) {

			if (localizacaoEixoX >= 660 && localizacaoEixoX <= 670)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 530) {

			if (localizacaoEixoX >= 560 && localizacaoEixoX <= 570)
				contadorDeValidacoes++;
		}

		validarMostrarSilhueta(localizacaoEixoX, localizacaoEixoY);
	}

	private void retornarImagensPersonagem(Validavel personagem) {

		silhuetaImagemData.retornarImagensPersonagem(personagem);
	}
}
