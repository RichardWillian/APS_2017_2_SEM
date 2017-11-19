package data;

public class MensagemData {

	private boolean mensagemOn;
	private static MensagemData instancia;
	private String advertencia_ecologica_0 = "PARE DE JOGAR LIXO !!!";
	
	private String advertencia_ecologica_1 = "<html>Do ponto de vista do planeta<br>"
											+ "n�o existe jogar lixo fora:<br>"
											+ "porque n�o existe \"FORA\".</html>";
	
	private String advertencia_ecologica_2 = "<html>Ambiente limpo<br> "
											+ "n�o � o que mais se limpa...<br> "
											+ "e sim o que menos se suja.</html>";
	
	private String advertencia_ecologica_3 = "<html>N�s n�o herdamos a Terra de nossos antecessores<br> "
											+ "n�s a pegamos emprestada de nossas crian�as.<br>"
											+ "Ent�o pense no futuro delas, pare de jogar <strong>lixo</strong> !</html>";
	
	private String advertencia_ecologica_4 = "<html>Lixo n�o � lixo! <br>"
											+ "Ele pode torna-se mat�ria-prima para confec��o de novos artigos<br>"
											+ "se voc� separ�-los e direcion�-los corretamente.</html>";
	
	private String advertencia_ecologica_5 = "<html> <strong>Aprenda a reciclar Dirtyman<strong> !!!</html>";
	
	private String advertencia_ecologica_6 = "<html>54% das cidades<br>"
											+ "depositam seus res�duos em locais<br>"
											+ "considerados inadequados.<br>"
											+ "Lixo � no lixo !</html>";
	
	private String[] mensagens = new String[7]; 
	
	private MensagemData(){
		mensagemOn = false;
		preencherVetorMensagens();
	}

	private void preencherVetorMensagens() {
		
		mensagens[0] = advertencia_ecologica_0;
		mensagens[1] = advertencia_ecologica_1;
		mensagens[2] = advertencia_ecologica_2;
		mensagens[3] = advertencia_ecologica_3;
		mensagens[4] = advertencia_ecologica_4;
		mensagens[5] = advertencia_ecologica_5;
		mensagens[6] = advertencia_ecologica_6;
	}
	
	public String recuperarMensagem(int numeroMensagem) {
		
		mensagemOn = true;
		return mensagens[numeroMensagem];
	}
	
	public boolean isMensagemOn(){
		return mensagemOn;
	}
	
	public static MensagemData getInstance() {

		if (instancia == null)
			instancia = new MensagemData();

		return instancia;
	}

	public void desligarMensagem() {
		mensagemOn = false;
	}
}
