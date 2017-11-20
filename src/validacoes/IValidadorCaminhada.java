package validacoes;

import personagens.IValidavel;

public interface IValidadorCaminhada {

	boolean autorizarCaminhar(int localizacaoEixoX, int localizacaoEixoY, IValidavel personagem);
}
