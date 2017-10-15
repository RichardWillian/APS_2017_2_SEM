package Controles;

import Constantes.ConstantesGerais;

public class ValidacoesMapa {

	public boolean autorizarCaminhadaCima(int posicaoY, int altura) {
		int alturaCompensada = (8 + altura);
		if(posicaoY + alturaCompensada + ConstantesGerais.TAMANHO_PASSO_ECOMAN >= 60){
			
//			if (Encontro(posicaoY, altura))
				return true;
		}
		
		return false;
	}

	public boolean autorizarCaminhadaBaixo(int posicaoY, int altura) {
		
		if(posicaoY - (8 +  altura)  + ConstantesGerais.TAMANHO_PASSO_ECOMAN <= 590)
			return true;
		
		return false;
	}

	public boolean autorizarCaminhadaEsquerda(int posicaoX, int largura) {
		
		if(largura + 2 + ConstantesGerais.TAMANHO_PASSO_ECOMAN + posicaoX >= 30)
			return true;
		
		return false;
	}
	
	public boolean autorizarCaminhadaDireita(int posicaoX, int largura) {
		
		if( (largura + 2) - ConstantesGerais.TAMANHO_PASSO_ECOMAN + posicaoX <= 985)
			return true;
		
		return false;
	}
	
//	private boolean validarPassagemObstaculoEixoX(int posicaoY, int altura) {
//		
//		return false;
//	}
}
