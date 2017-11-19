package validacoes;

import personagens.Validavel;

public interface IValidadorCaminhada {

	boolean autorizarCaminhar(int localizacaoEixoX, int localizacaoEixoY, Validavel personagem);
}
