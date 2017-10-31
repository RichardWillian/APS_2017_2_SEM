package Validacoes;

import ImagemData.SilhuetaImagemData;
import Personagens.Validavel;

public class ValidacaoCaminharEsquerda implements IValidadorCaminhada {

	private Integer contadorDeValidacoes = 0;
	private SilhuetaImagemData silhuetaImagemData = SilhuetaImagemData.getInstance();
	Validavel personagem = null;

	@Override
	public boolean autorizarCaminhar(int localizacaoEixoX, int localizacaoEixoY, Validavel personagem) {

		this.personagem = personagem;
		CarregarValidacoes(localizacaoEixoX, localizacaoEixoY);

		if (contadorDeValidacoes.equals(0))
			return true;

		return false;
	}

	private void retornarImagensPersonagem(Validavel personagem) {

		silhuetaImagemData.retornarImagensPersonagem(personagem);
	}

	private void CarregarValidacoes(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY <= 300) {

			if (localizacaoEixoX >= 20 && localizacaoEixoX <= 110)
				ValidarPrimeiroQuarteirao(localizacaoEixoX, localizacaoEixoY);

			else if (localizacaoEixoX >= 190 && localizacaoEixoX <= 800)
				ValidarSegundoQuarteirao(localizacaoEixoX, localizacaoEixoY);

			else if (localizacaoEixoX >= 880 && localizacaoEixoX <= 1010)
				ValidarTerceiroQuarteirao(localizacaoEixoX, localizacaoEixoY);

		} else if (localizacaoEixoY < 650) {

			if (localizacaoEixoX >= 20 && localizacaoEixoX <= 110)
				ValidarQuartoQuarteirao(localizacaoEixoX, localizacaoEixoY);

			else if (localizacaoEixoX >= 190 && localizacaoEixoX <= 800)
				ValidarQuintoQuarteirao(localizacaoEixoX, localizacaoEixoY);

			else if (localizacaoEixoX >= 880 && localizacaoEixoX <= 1010)
				ValidarSextoQuarteirao(localizacaoEixoX, localizacaoEixoY);

		} else if (localizacaoEixoY >= 650)
			validarSetimoQuarteirao(localizacaoEixoX, localizacaoEixoY);
	}

	private void validarSetimoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if(localizacaoEixoX == 830){
			if(localizacaoEixoY > 680 && localizacaoEixoY <= 710)
				contadorDeValidacoes++;
		}
		
		validarMostrarSilhueta(localizacaoEixoX, localizacaoEixoY);
	}

	private void ValidarSextoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {
		if (localizacaoEixoX == 990) {

			if (localizacaoEixoY >= 370 && localizacaoEixoY <= 420)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 1000) {

			if (localizacaoEixoY == 630)
				contadorDeValidacoes++;
		}
	}

	private void ValidarQuintoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {
		if (localizacaoEixoX == 300) {
			if (localizacaoEixoY >= 360 && localizacaoEixoY <= 360)
				contadorDeValidacoes++;

			else if (localizacaoEixoY >= 520 && localizacaoEixoY <= 590)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 420) {
			if (localizacaoEixoY >= 370 && localizacaoEixoY <= 450)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 50) {
			if (localizacaoEixoY >= 340 && localizacaoEixoY <= 360)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 660) {
			if (localizacaoEixoY >= 380 && localizacaoEixoY <= 390)
				contadorDeValidacoes++;

			if (localizacaoEixoY >= 510 && localizacaoEixoY <= 520)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 790) {
			if (localizacaoEixoY >= 380 && localizacaoEixoY <= 530)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 360) {
			if (localizacaoEixoY >= 580 && localizacaoEixoY <= 590)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 460) {
			if (localizacaoEixoY >= 580 && localizacaoEixoY <= 610)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 560) {
			if (localizacaoEixoY == 530)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 580) {
			if (localizacaoEixoY >= 540 && localizacaoEixoY <= 550)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 520) {
			if (localizacaoEixoY >= 550 && localizacaoEixoY <= 590)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 780) {
			if (localizacaoEixoY >= 540 && localizacaoEixoY <= 610)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 680) {
			if (localizacaoEixoY == 600)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 540) {
			
			if (localizacaoEixoY >= 380 && localizacaoEixoY <= 540) {
				contadorDeValidacoes++;

			} else if (localizacaoEixoY >= 560 && localizacaoEixoY <= 570)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 630) {
			if (localizacaoEixoY >= 570 && localizacaoEixoY <= 590)
				contadorDeValidacoes++;
		}else if (localizacaoEixoX == 740) {
		
			if(localizacaoEixoY > 370 && localizacaoEixoY < 620)
				contadorDeValidacoes++;
		}
		else if (localizacaoEixoX == 600) {
			if (localizacaoEixoY > 370 && localizacaoEixoY < 530)
				contadorDeValidacoes++;
		}
		validarMostrarSilhueta(localizacaoEixoX, localizacaoEixoY);
	}

	private void validarMostrarSilhueta(int localizacaoEixoX, int localizacaoEixoY) {
		if (localizacaoEixoX > 210 && localizacaoEixoX <= 300) {

			if (localizacaoEixoY > 320 && localizacaoEixoY <= 350)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else 
				retornarImagensPersonagem(personagem);

		} else if (localizacaoEixoX > 290 && localizacaoEixoX < 340) {

			if (localizacaoEixoY > 510 && localizacaoEixoY < 540)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else 
				retornarImagensPersonagem(personagem);
			
		} else if (localizacaoEixoX > 440 && localizacaoEixoX <= 530) {

			if (localizacaoEixoY <= 370 && localizacaoEixoY > 320)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else 
				retornarImagensPersonagem(personagem);

		} else if (localizacaoEixoX > 560 && localizacaoEixoX <= 650) {

			if (localizacaoEixoY <= 370 && localizacaoEixoY > 340)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else 
				retornarImagensPersonagem(personagem);

		} else if (localizacaoEixoY > 320 && localizacaoEixoY <= 370) {
			
			if(localizacaoEixoX > 700 && localizacaoEixoX <= 790)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else 
				retornarImagensPersonagem(personagem);
			
		} else if(localizacaoEixoY > 660 && localizacaoEixoY <= 680){
			
			if(localizacaoEixoX > 740 && localizacaoEixoX <= 830)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else 
				retornarImagensPersonagem(personagem);
			
		} else
			retornarImagensPersonagem(personagem);
	}

	private void ValidarQuartoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoX == 110) {

			if (localizacaoEixoY >= 370 && localizacaoEixoY <= 490)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 50) {
			if (localizacaoEixoY >= 560 && localizacaoEixoY <= 570)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 70) {
			if (localizacaoEixoY >= 490 && localizacaoEixoY <= 510)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 80) {
			if (localizacaoEixoY == 530)
				contadorDeValidacoes++;
		} else if (localizacaoEixoX == 100) {
			if (localizacaoEixoY >= 540 && localizacaoEixoY <= 550)
				contadorDeValidacoes++;
		}
	}

	private void ValidarTerceiroQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoX == 1010) {

			if (localizacaoEixoY >= 220 && localizacaoEixoY <= 230)
				contadorDeValidacoes++;
			else if (localizacaoEixoY >= 100 && localizacaoEixoY <= 180)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 970) {

			if (localizacaoEixoY == 220)
				contadorDeValidacoes++;

		}
	}

	private void ValidarSegundoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {
		if (localizacaoEixoX == 780) {

			if (localizacaoEixoY >= 50 && localizacaoEixoY <= 60)
				contadorDeValidacoes++;
			else if (localizacaoEixoY >= 100 && localizacaoEixoY <= 180)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 790) {

			if (localizacaoEixoY >= 70 && localizacaoEixoY <= 90)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 660) {

			if (localizacaoEixoY >= 190 && localizacaoEixoY <= 200)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 560) {

			if (localizacaoEixoY == 210)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 460) {

			if (localizacaoEixoY == 210)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 280) {

			if (localizacaoEixoY >= 210 && localizacaoEixoY <= 220)
				contadorDeValidacoes++;

		}

	}

	private void ValidarPrimeiroQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoX == 90) {

			if (localizacaoEixoY >= 70 && localizacaoEixoY <= 90)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 50) {

			if (localizacaoEixoY >= 110 && localizacaoEixoY <= 190)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 60) {

			if (localizacaoEixoY == 100)
				contadorDeValidacoes++;

			else if (localizacaoEixoY == 340)
				contadorDeValidacoes++;

		} else if (localizacaoEixoX == 100) {

			if (localizacaoEixoY >= 200 && localizacaoEixoY <= 210)
				contadorDeValidacoes++;

		}
	}
}
