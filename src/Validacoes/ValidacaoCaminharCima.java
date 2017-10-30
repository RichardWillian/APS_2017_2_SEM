package Validacoes;

import ImagemData.SilhuetaImagemData;
import Personagens.Validavel;

public class ValidacaoCaminharCima implements IValidadorCaminhada {

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

		validarMostrarSilhueta(localizacaoEixoX, localizacaoEixoY);
	}

	private void ValidarSextoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY == 630) {

			if (localizacaoEixoX >= 890 && localizacaoEixoX <= 930)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 950 && localizacaoEixoX <= 970)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 1000 && localizacaoEixoX <= 1010)
				contadorDeValidacoes++;
		} else if (localizacaoEixoY == 640) {

			if (localizacaoEixoX >= 980 && localizacaoEixoX <= 990)
				contadorDeValidacoes++;
		}
	}

	private void ValidarQuintoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY == 540) {
			if (localizacaoEixoX >= 780 && localizacaoEixoX <= 790)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 530) {

			if (localizacaoEixoX > 290 && localizacaoEixoX < 340)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 530 && localizacaoEixoX <= 590)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 610 && localizacaoEixoX == 620)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 550) {

			if (localizacaoEixoX >= 520 && localizacaoEixoX <= 550)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 630 && localizacaoEixoX <= 670)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 560) {

			if (localizacaoEixoX >= 560 && localizacaoEixoX <= 570)
				contadorDeValidacoes++;

			else if (localizacaoEixoX == 680)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 580) {

			if (localizacaoEixoX >= 200 && localizacaoEixoX <= 270)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 370 && localizacaoEixoX <= 390)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 520 && localizacaoEixoX <= 530)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 460 && localizacaoEixoX <= 470)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 600) {

			if ((localizacaoEixoX >= 280 && localizacaoEixoX <= 300)
					|| (localizacaoEixoX >= 340 && localizacaoEixoX <= 360))
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 400 && localizacaoEixoX <= 410)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 480 && localizacaoEixoX <= 510)
				contadorDeValidacoes++;

			else if (localizacaoEixoX == 620)
				contadorDeValidacoes++;

			else if (localizacaoEixoX == 680)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 610) {

			if (localizacaoEixoX >= 420 && localizacaoEixoX <= 450)
				contadorDeValidacoes++;

			else if (localizacaoEixoX == 660)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 620) {

			if (localizacaoEixoX >= 690 && localizacaoEixoX <= 730)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 750 && localizacaoEixoX <= 770)
				contadorDeValidacoes++;
		}
		validarMostrarSilhueta(localizacaoEixoX, localizacaoEixoY);
	}

	private void validarMostrarSilhueta(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY > 330 && localizacaoEixoY <= 510) {

			if (localizacaoEixoX >= 210 && localizacaoEixoX <= 300)
				silhuetaImagemData.trocarParaSilhueta(personagem);

			else if (localizacaoEixoX > 440 && localizacaoEixoX <= 530)
				silhuetaImagemData.trocarParaSilhueta(personagem);

			else if (localizacaoEixoX > 700 && localizacaoEixoX <= 790)

				if (localizacaoEixoY < 500)
					silhuetaImagemData.trocarParaSilhueta(personagem);
				else
					retornarImagensPersonagem(personagem);

			if (localizacaoEixoX > 560 && localizacaoEixoX <= 650) {

				if (localizacaoEixoY > 350)
					silhuetaImagemData.trocarParaSilhueta(personagem);
				else
					retornarImagensPersonagem(personagem);
			}

		} else if (localizacaoEixoY >= 530 && localizacaoEixoY <= 540) {

			if (localizacaoEixoX > 290 && localizacaoEixoX < 340)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else
				retornarImagensPersonagem(personagem);
		}

		else if (localizacaoEixoY >= 550 && localizacaoEixoY < 610) {

			if (localizacaoEixoX == 740)
				silhuetaImagemData.trocarParaSilhueta(personagem);
			else
				retornarImagensPersonagem(personagem);

		} else if (localizacaoEixoY > 670 && localizacaoEixoY <= 680) {

			if (localizacaoEixoX > 730 && localizacaoEixoX <= 820)
				silhuetaImagemData.trocarParaSilhueta(personagem);
		} else
			retornarImagensPersonagem(personagem);
	}

	private void ValidarQuartoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY == 490) {

			if (localizacaoEixoX == 70)
				contadorDeValidacoes++;
		} else if (localizacaoEixoY == 500) {

			if (localizacaoEixoX >= 80 && localizacaoEixoX <= 100)
				contadorDeValidacoes++;
		} else if (localizacaoEixoY == 530) {

			if (localizacaoEixoX >= 80 && localizacaoEixoX <= 100)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 560) {

			if (localizacaoEixoX >= 50 && localizacaoEixoX <= 90)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 580) {

			if (localizacaoEixoX >= 20 && localizacaoEixoX <= 40)
				contadorDeValidacoes++;
		} else if (localizacaoEixoY == 350) {

			if (localizacaoEixoX >= 40 && localizacaoEixoX <= 50)
				contadorDeValidacoes++;
		}
	}

	private void ValidarTerceiroQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY == 220) {

			if (localizacaoEixoX >= 970 && localizacaoEixoX <= 980)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 890 && localizacaoEixoX <= 910)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 230) {

			if (localizacaoEixoX >= 900 && localizacaoEixoX <= 970)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 990 && localizacaoEixoX <= 1000)
				contadorDeValidacoes++;

			else if (localizacaoEixoX == 1010)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 240) {

			if (localizacaoEixoX >= 920 && localizacaoEixoX <= 960)
				contadorDeValidacoes++;
		}
	}

	private void ValidarSegundoQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY == 100) {

			if (localizacaoEixoX == 210)
				contadorDeValidacoes++;

			else if (localizacaoEixoX == 780)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 170) {

			if (localizacaoEixoY == 210)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 190) {

			if (localizacaoEixoX >= 300 && localizacaoEixoX <= 330)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 660 && localizacaoEixoX <= 720)
				contadorDeValidacoes++;

			else if (localizacaoEixoX >= 730 && localizacaoEixoX <= 770)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 200) {

			if ((localizacaoEixoX >= 220 && localizacaoEixoX <= 290)
					|| (localizacaoEixoX >= 340 && localizacaoEixoX <= 650))
				contadorDeValidacoes++;
		}
	}

	private void ValidarPrimeiroQuarteirao(int localizacaoEixoX, int localizacaoEixoY) {

		if (localizacaoEixoY == 230) {

			if (localizacaoEixoX >= 20 && localizacaoEixoX <= 90)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 120) {

			if (localizacaoEixoX == 50)
				contadorDeValidacoes++;

		} else if (localizacaoEixoY == 100) {

			if (localizacaoEixoX >= 60 && localizacaoEixoX <= 80)
				contadorDeValidacoes++;

		}
	}
}
