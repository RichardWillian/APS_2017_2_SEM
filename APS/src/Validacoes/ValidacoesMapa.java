package Validacoes;

import Constantes.ConstantesGerais;
import Personagens.Ecoman;
import Personagens.Validavel;

public class ValidacoesMapa {

	int passoCompensadoEixoX;
	int passoCompensadoEixoY;

	public boolean autorizarCaminhadaCima(Validavel personagem) {

		passoCompensadoEixoY = personagem.getPosicaoY() + (8 + personagem.getAltura()) - 10
				+ ConstantesGerais.TAMANHO_PASSO_ECOMAN;
		passoCompensadoEixoX = personagem.getPosicaoX() + (2 + personagem.getLargura())
				+ ConstantesGerais.TAMANHO_PASSO_ECOMAN;
		
		if (passoCompensadoEixoY >= 60) {
			
			ValidacaoCaminharCima validacaoCaminharCima = new ValidacaoCaminharCima();
		
			if(validacaoCaminharCima.autorizarCaminhar(passoCompensadoEixoX, passoCompensadoEixoY))
				return true;
			else
				return false;
		}

//			// Quarteirão Cima Meio
//			// //////////////////////////////////////////////////////////////////////////////////////////////////////
//			boolean localizacaoParedeQuarteiraoCimaMeio = passoCompensadoEixoY == 210;
//			boolean entreAsParedesQuarteiraoCimaMeio = (passoCompensadoEixoX >= 220 && passoCompensadoEixoX <= 290)
//					|| (passoCompensadoEixoX >= 340 && passoCompensadoEixoX <= 650);
//
//			boolean localizacaoLixeiraMeioQuarteiraoCimaMeio = passoCompensadoEixoY == 190
//					&& (passoCompensadoEixoX >= 300 && passoCompensadoEixoX <= 330);
//
//			boolean localizacaoLixeiraLadoEsquerdoQuarteiraoCimaMeio = passoCompensadoEixoY == 170
//					&& passoCompensadoEixoX == 210;
//
//			boolean localizacaoDetalheLadoEsquerdoQuarteiraoCimaMeio = passoCompensadoEixoY == 100
//					&& passoCompensadoEixoX == 210;
//
//			boolean localizacaoParedeCasaAoLadoQuarteiraoCimaMeio = passoCompensadoEixoY == 190;
//			boolean entreAsParedesCasaAoLadoQuarteiraoCimaMeio = passoCompensadoEixoX >= 660
//					&& passoCompensadoEixoX <= 720;
//
//			boolean localizacaoLixeiraAoLadoQuarteiraoCimaMeio = passoCompensadoEixoY == 190;
//			boolean entreAsDimensoesLixeiraAoLadoQuarteiraoCimaMeio = passoCompensadoEixoX >= 730
//					&& passoCompensadoEixoX <= 770;
//
//			boolean localizacaoCanoLadoDireitoQuarteiraoCimaMeio = passoCompensadoEixoY == 100
//					&& passoCompensadoEixoX == 780;
//			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//			// Quarteirão Cima Esquerda
//			// ///////////////////////////////////////////////////////////////////////////////////////////////////
//			boolean localizacaoParedeQuarteiraoCimaEsquerda = passoCompensadoEixoY == 230;
//			boolean entreAsParedesQuarteiraoCimaEsquerda = passoCompensadoEixoX >= 20 && passoCompensadoEixoX <= 90;
//
//			boolean localizacaoObjetoQuarteiraoCimaEsquerda = passoCompensadoEixoY == 120 && passoCompensadoEixoX == 50;
//			boolean localizacaoObjetoDoisQuarteiraoCimaEsquerda = passoCompensadoEixoY == 100
//					&& (passoCompensadoEixoX >= 60 && passoCompensadoEixoX <= 80);
//			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//			// Quarteirão Cima Direita
//			// ////////////////////////////////////////////////////////////////////////////////////////////////////
//			boolean localizacaoParedeQuarteiraoCimaDireita = passoCompensadoEixoY == 230;
//			boolean entreAsParedesQuarteiraoCimaDireita = passoCompensadoEixoX >= 890 && passoCompensadoEixoX <= 910;
//
//			boolean localizacaoBancosQuarteiraoCimaDireita = passoCompensadoEixoY == 240
//					&& (passoCompensadoEixoX >= 920 && passoCompensadoEixoX <= 960);
//
//			boolean localizacaoRestoParedeQuarteiraoCimaDireita = passoCompensadoEixoY == 220
//					&& (passoCompensadoEixoX >= 970 && passoCompensadoEixoX <= 980);
//
//			boolean localizacaoBarrilQuarteiraoCimaDireita = passoCompensadoEixoY == 230
//					&& (passoCompensadoEixoX >= 990 && passoCompensadoEixoX <= 1000);
//
//			boolean localizacaoRestoDoisParedeQuarteiraoCimaDireita = passoCompensadoEixoY == 230
//					&& passoCompensadoEixoX == 1010;
//			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//			// Quarteirão Meio Esquerda
//			// ////////////////////////////////////////////////////////////////////////////////////////////////////
//			boolean localizacaoParedeQuarteiraoMeioEsquerda = passoCompensadoEixoY == 580
//					&& (passoCompensadoEixoX >= 20 && passoCompensadoEixoX <= 40);
//
//			boolean localizacaoCarroQuarteiraoMeioEsquerda = passoCompensadoEixoY == 560
//					&& (passoCompensadoEixoX >= 50 && passoCompensadoEixoX <= 90);
//
//			boolean localizacaoRestoParedeQuarteiraoMeioEsquerda = passoCompensadoEixoY == 490
//					&& passoCompensadoEixoX == 70;
//
//			boolean localizacaoDetalheQuarteiraoMeioEsquerda = passoCompensadoEixoY == 530
//					&& (passoCompensadoEixoX >= 80 && passoCompensadoEixoX <= 100);
//
//			boolean localizacaoLixeiraDetalheQuarteiraoMeioEsquerda = passoCompensadoEixoY == 500
//					&& (passoCompensadoEixoX >= 80 && passoCompensadoEixoX <= 100);
//			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//			// Quarteirão
//			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Meio/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//			boolean localizacaoParedeQuarteiraoMeio = passoCompensadoEixoY == 580
//					&& (passoCompensadoEixoX >= 200 && passoCompensadoEixoX <= 270);
//
//			boolean localizacaoPilaresQuarteiraoMeio = passoCompensadoEixoY == 600
//					&& ((passoCompensadoEixoX >= 280 && passoCompensadoEixoX <= 300)
//							|| (passoCompensadoEixoX >= 340 && passoCompensadoEixoX <= 360));
//
//			boolean localizacaoRestoParedeQuarteiraoMeio = passoCompensadoEixoY == 580
//					&& (passoCompensadoEixoX >= 370 && passoCompensadoEixoX <= 390);
//
//			boolean localizacaoBarrilFogoQuarteiraoMeio = passoCompensadoEixoY == 600
//					&& (passoCompensadoEixoX >= 400 && passoCompensadoEixoX <= 410);
//
//			boolean localizacaoLixeiraQuarteiraoMeio = passoCompensadoEixoY == 610
//					&& (passoCompensadoEixoX >= 420 && passoCompensadoEixoX <= 450);
//
//			boolean localizacaoDetalheCasaVermelhaQuarteiraoMeio = passoCompensadoEixoY == 600
//					&& (passoCompensadoEixoX >= 480 && passoCompensadoEixoX <= 510);
//
//			boolean localizacaoMuretinhaLadoDireitoCasaVermelhaQuarteiraoMeio = passoCompensadoEixoY == 580
//					&& (passoCompensadoEixoX >= 520 && passoCompensadoEixoX <= 530);
//
//			boolean localizacaoLixoDetalheLadoDireitoCasaVermelhaQuarteiraoMeio = passoCompensadoEixoY == 550
//					&& (passoCompensadoEixoX >= 520 && passoCompensadoEixoX <= 550);
//
//			boolean localizacaoBarrilFogoDoisQuarteiraoMeio = passoCompensadoEixoY == 560
//					&& (passoCompensadoEixoX >= 560 && passoCompensadoEixoX <= 570);
//
//			boolean localizacaoPredioCinzaQuarteiraoMeio = passoCompensadoEixoY == 530
//					&& (passoCompensadoEixoX >= 530 && passoCompensadoEixoX <= 590);
//
//			boolean localizacaoRestoParedePredioCinzaQuarteiraoMeio = passoCompensadoEixoY == 530
//					&& (passoCompensadoEixoX >= 610 && passoCompensadoEixoX == 620);
//
//			boolean localizacaoConesQuarteiraoMeio = passoCompensadoEixoY == 600 && passoCompensadoEixoX == 620;
//
//			boolean localizacaoGradeQuarteiraoMeio = passoCompensadoEixoY == 550
//					&& (passoCompensadoEixoX >= 630 && passoCompensadoEixoX <= 670);
//
//			boolean localizacaoCanoQuarteiraoMeio = passoCompensadoEixoY == 610 && passoCompensadoEixoX == 660;
//
//			boolean localizacaoCanoDoisQuarteiraoMeio = passoCompensadoEixoY == 600 && passoCompensadoEixoX == 680;
//
//			boolean localizacaoBarrilCinzaQuarteiraoMeio = passoCompensadoEixoY == 560 && passoCompensadoEixoX == 680;
//
//			boolean localizacaoParedePequenaCasaQuarteiraoMeio = passoCompensadoEixoY == 620
//					&& (passoCompensadoEixoX >= 690 && passoCompensadoEixoX <= 730);
//
//			boolean localizacaoRestoParedePequenaCasaQuarteiraoMeio = passoCompensadoEixoY == 620
//					&& (passoCompensadoEixoX >= 750 && passoCompensadoEixoX <= 770);
//
//			boolean localizacaoRestoGradePequenaCasaQuarteiraoMeio = passoCompensadoEixoY == 540
//					&& (passoCompensadoEixoX >= 780 && passoCompensadoEixoX <= 790);
//			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//			// Quarteirão Direita
//			// Baixo/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//			boolean localizacaoParedePredioMarromQuarteiraoBaixoDireita = passoCompensadoEixoY == 630
//					&& (passoCompensadoEixoX >= 890 && passoCompensadoEixoX <= 930);
//
//			boolean localizacaoRestoParedePredioMarromQuarteiraoBaixoDireita = passoCompensadoEixoY == 630
//					&& (passoCompensadoEixoX >= 950 && passoCompensadoEixoX <= 970);
//
//			boolean localizacaoMaquinaPipocaQuarteiraoBaixoDireita = passoCompensadoEixoY == 640
//					&& (passoCompensadoEixoX >= 980 && passoCompensadoEixoX <= 990);
//
//			boolean localizacaoPredioMarromEscuroQuarteiraoBaixoDireita = passoCompensadoEixoY == 630
//					&& (passoCompensadoEixoX >= 1000 && passoCompensadoEixoX <= 1010);
//			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//			boolean localizacaoAreaRestrita = passoCompensadoEixoY == 510
//					&& (passoCompensadoEixoX >= 840 && passoCompensadoEixoX <= 880);
//			if (localizacaoParedeQuarteiraoCimaMeio && entreAsParedesQuarteiraoCimaMeio)
//				return false;
//			else if (localizacaoLixeiraLadoEsquerdoQuarteiraoCimaMeio)
//				return false;
//			else if (localizacaoDetalheLadoEsquerdoQuarteiraoCimaMeio)
//				return false;
//			else if (localizacaoLixeiraMeioQuarteiraoCimaMeio)
//				return false;
//			else if (localizacaoParedeCasaAoLadoQuarteiraoCimaMeio && entreAsParedesCasaAoLadoQuarteiraoCimaMeio)
//				return false;
//			else if (localizacaoLixeiraAoLadoQuarteiraoCimaMeio && entreAsDimensoesLixeiraAoLadoQuarteiraoCimaMeio)
//				return false;
//			else if (localizacaoCanoLadoDireitoQuarteiraoCimaMeio)
//				return false;
//			else if (localizacaoParedeQuarteiraoCimaEsquerda && entreAsParedesQuarteiraoCimaEsquerda)
//				return false;
//			else if (localizacaoObjetoQuarteiraoCimaEsquerda)
//				return false;
//			else if (localizacaoObjetoDoisQuarteiraoCimaEsquerda)
//				return false;
//			else if (localizacaoParedeQuarteiraoCimaDireita && entreAsParedesQuarteiraoCimaDireita)
//				return false;
//			else if (localizacaoBancosQuarteiraoCimaDireita)
//				return false;
//			else if (localizacaoRestoParedeQuarteiraoCimaDireita)
//				return false;
//			else if (localizacaoBarrilQuarteiraoCimaDireita)
//				return false;
//			else if (localizacaoRestoDoisParedeQuarteiraoCimaDireita)
//				return false;
//			else if (localizacaoParedeQuarteiraoMeioEsquerda)
//				return false;
//			else if (localizacaoCarroQuarteiraoMeioEsquerda)
//				return false;
//			else if (localizacaoRestoParedeQuarteiraoMeioEsquerda)
//				return false;
//			else if (localizacaoDetalheQuarteiraoMeioEsquerda)
//				return false;
//			else if (localizacaoLixeiraDetalheQuarteiraoMeioEsquerda)
//				return false;
//			else if (localizacaoParedeQuarteiraoMeio)
//				return false;
//			else if (localizacaoPilaresQuarteiraoMeio)
//				return false;
//			else if (localizacaoRestoParedeQuarteiraoMeio)
//				return false;
//			else if (localizacaoBarrilFogoQuarteiraoMeio)
//				return false;
//			else if (localizacaoLixeiraQuarteiraoMeio)
//				return false;
//			else if (localizacaoDetalheCasaVermelhaQuarteiraoMeio)
//				return false;
//			else if (localizacaoMuretinhaLadoDireitoCasaVermelhaQuarteiraoMeio)
//				return false;
//			else if (localizacaoLixoDetalheLadoDireitoCasaVermelhaQuarteiraoMeio)
//				return false;
//			else if (localizacaoBarrilFogoDoisQuarteiraoMeio)
//				return false;
//			else if (localizacaoPredioCinzaQuarteiraoMeio)
//				return false;
//			else if (localizacaoRestoParedePredioCinzaQuarteiraoMeio)
//				return false;
//			else if (localizacaoConesQuarteiraoMeio)
//				return false;
//			else if (localizacaoGradeQuarteiraoMeio)
//				return false;
//			else if (localizacaoCanoQuarteiraoMeio)
//				return false;
//			else if (localizacaoCanoDoisQuarteiraoMeio)
//				return false;
//			else if (localizacaoParedePequenaCasaQuarteiraoMeio)
//				return false;
//			else if (localizacaoRestoParedePequenaCasaQuarteiraoMeio)
//				return false;
//			else if (localizacaoRestoGradePequenaCasaQuarteiraoMeio)
//				return false;
//			else if (localizacaoBarrilCinzaQuarteiraoMeio)
//				return false;
//			else if (localizacaoParedePredioMarromQuarteiraoBaixoDireita)
//				return false;
//			else if (localizacaoRestoParedePredioMarromQuarteiraoBaixoDireita)
//				return false;
//			else if (localizacaoMaquinaPipocaQuarteiraoBaixoDireita)
//				return false;
//			else if (localizacaoPredioMarromEscuroQuarteiraoBaixoDireita)
//				return false;
//			else if (localizacaoAreaRestrita)
//				return false;
//
//			return true;
//		}

		return false;
	}

	public boolean autorizarCaminhadaBaixo(Ecoman ecoman) {

		passoCompensadoEixoY = ecoman.getPosicaoY() + (8 + ecoman.getAltura()) + ConstantesGerais.TAMANHO_PASSO_ECOMAN;
		passoCompensadoEixoX = (ecoman.getLargura() + 2) + ConstantesGerais.TAMANHO_PASSO_ECOMAN + ecoman.getPosicaoX();

		if (ecoman.getPosicaoY() + (8 + ecoman.getAltura()) + ConstantesGerais.TAMANHO_PASSO_ECOMAN <= 670)
			return true;

		return false;
	}

	public boolean autorizarCaminhadaEsquerda(Ecoman ecoman) {

		passoCompensadoEixoY = ecoman.getPosicaoY() + (8 + ecoman.getAltura()) + ConstantesGerais.TAMANHO_PASSO_ECOMAN;
		passoCompensadoEixoX = (ecoman.getLargura() + 2) + ConstantesGerais.TAMANHO_PASSO_ECOMAN + ecoman.getPosicaoX();

		if (ecoman.getLargura() + 2 + ConstantesGerais.TAMANHO_PASSO_ECOMAN + ecoman.getPosicaoX() >= 30) {
			return true;
		} else {
			ecoman.setPosicaoX(990);
			return true;
		}

	}

	public boolean autorizarCaminhadaDireita(Ecoman ecoman) {

		passoCompensadoEixoY = ecoman.getPosicaoY() + (8 + ecoman.getAltura()) + ConstantesGerais.TAMANHO_PASSO_ECOMAN;
		passoCompensadoEixoX = (ecoman.getLargura() + 2) + ConstantesGerais.TAMANHO_PASSO_ECOMAN + ecoman.getPosicaoX();

		if ((ecoman.getLargura() + 2) + ConstantesGerais.TAMANHO_PASSO_ECOMAN + ecoman.getPosicaoX() <= 1000) {
			ValidacaoCaminharCima validacaoCaminharCima = new ValidacaoCaminharCima();
			
			if(validacaoCaminharCima.autorizarCaminhar(passoCompensadoEixoX, passoCompensadoEixoY))
				return true;
			else
				return false;
		} else {
			ecoman.setPosicaoX(-ConstantesGerais.TAMANHO_PASSO_ECOMAN);
			return true;
		}
	}
}
