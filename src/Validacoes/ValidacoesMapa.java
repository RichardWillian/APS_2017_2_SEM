package Validacoes;

import Personagens.Validavel;

public class ValidacoesMapa {

	public boolean autorizarCaminhadaCima(Validavel personagem) {

		if (personagem.getTamanhoPassoCompensadoEixoY() >= 60) {

			ValidacaoCaminharCima validacaoCaminharCima = new ValidacaoCaminharCima();

			if (validacaoCaminharCima.autorizarCaminhar(personagem.getTamanhoPassoCompensadoEixoX(),
					personagem.getTamanhoPassoCompensadoEixoY(), personagem)) {
				return true;
			}
		}

		return false;
	}

	public boolean autorizarCaminhadaBaixo(Validavel personagem) {

		if (personagem.getTamanhoPassoCompensadoEixoY() <= 670) {
			return true;
		}

		if (personagem.getPosicaoX() >= 800)

			if (personagem.getTamanhoPassoCompensadoEixoY() <= 700)
				return true;

		return false;
	}

	public boolean autorizarCaminhadaEsquerda(Validavel personagem) {

		if (personagem.getTamanhoPassoCompensadoEixoX() >= 30) {

			ValidacaoCaminharEsquerda validacaoCaminharEsquerda = new ValidacaoCaminharEsquerda();
			if (validacaoCaminharEsquerda.autorizarCaminhar(personagem.getTamanhoPassoCompensadoEixoX(),
					personagem.getTamanhoPassoCompensadoEixoY(), personagem)) {

				return true;
			} else
				return false;
		} else {

			if (personagem.getPosicaoY() > 520 && personagem.getPosicaoY() < 600) {
				personagem.setPosicaoX(990);
				personagem.setPosicaoY(580);
			} else
				personagem.setPosicaoX(990);
			return true;
		}
	}

	public boolean autorizarCaminhadaDireita(Validavel personagem) {

		if (personagem.getTamanhoPassoCompensadoEixoX() < 1020) {
			ValidacaoCaminharDireita validacaoCaminharDireita = new ValidacaoCaminharDireita();

			if (validacaoCaminharDireita.autorizarCaminhar(personagem.getTamanhoPassoCompensadoEixoX(),
					personagem.getTamanhoPassoCompensadoEixoY(), personagem)) {
				return true;
			} else
				return false;
		} else {

			personagem.setPosicaoX(-20);

			if (personagem.getPosicaoY() >= 590)
				personagem.setPosicaoY(personagem.getPosicaoY() - 30);
			return true;
		}
	}
}
