package Validacoes;

import Personagens.Validavel;

public class ValidacoesMapa {

	public ValidacoesMapa() {

	}

	public boolean autorizarCaminhadaCima(Validavel personagem) {

		if (personagem.getTamanhoPassoCompensadoEixoY() >= 60) {

			ValidacaoCaminharCima validacaoCaminharCima = new ValidacaoCaminharCima();

			if (validacaoCaminharCima.autorizarCaminhar(personagem.getTamanhoPassoCompensadoEixoX(),
					personagem.getTamanhoPassoCompensadoEixoY()))
				return true;
			else
				return false;
		}

		return false;
	}

	public boolean autorizarCaminhadaBaixo(Validavel personagem) {

		if (personagem.getTamanhoPassoCompensadoEixoY() <= 670) {

			return true;
		}

		if (personagem.getPosicaoX() >= 800)

			if (personagem.getTamanhoPassoCompensadoEixoY() <= 700) {
				return true;
			}
		return false;
	}

	public boolean autorizarCaminhadaEsquerda(Validavel personagem) {

		if (personagem.getTamanhoPassoCompensadoEixoX() >= 30) {
			return true;
		} else {
			personagem.setPosicaoX(990);
			if(personagem.getPosicaoY() >= 600)
			personagem.setPosicaoY(personagem.getPosicaoY() + 30);
			return true;
		}
	}

	public boolean autorizarCaminhadaDireita(Validavel personagem) {

		if (personagem.getTamanhoPassoCompensadoEixoX() <= 1000) {
			ValidacaoCaminharDireita validacaoCaminharDireita = new ValidacaoCaminharDireita();

			if (validacaoCaminharDireita.autorizarCaminhar(personagem.getTamanhoPassoCompensadoEixoX(),
					personagem.getTamanhoPassoCompensadoEixoY()))
				return true;
			else
				return false;
		} else {

			personagem.setPosicaoX(-20);

			if (personagem.getPosicaoY() >= 590)
				personagem.setPosicaoY(personagem.getPosicaoY() - 30);
			return true;
		}
	}
}
