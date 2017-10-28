package Validacoes;

import Personagens.Validavel;

public interface IValidadorCaminhada {

	boolean autorizarCaminhar(int localizacaoEixoX, int localizacaoEixoY, Validavel personagem);
}
