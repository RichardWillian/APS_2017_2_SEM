package Controles;

import Constantes.ConstantesGerais;

public class ValidacoesMapa {

	public boolean autorizarCaminhadaEixoY(int posicaoY) {
		
		if(posicaoY + 2 + ConstantesGerais.TAMANHO_PASSO_ECOMAN > 70 && posicaoY + ConstantesGerais.TAMANHO_PASSO_ECOMAN < 600)
			return true;
		else
			return false;
	}

	public boolean autorizarCaminhadaEixoX(int posicaoX) {
		
		if( posicaoX > 40 && posicaoX < 900)
			return true;
		else
			return false;
	}
}
