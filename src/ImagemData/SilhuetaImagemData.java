package ImagemData;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Personagens.Ecoman;
import Personagens.Validavel;
import Telas.TelaPrincipal;

public class SilhuetaImagemData {

	private Icon icon1, icon2, icon3, iconB1, iconB2, iconB3, iconL1, iconL2, iconL3, iconC1, iconC2, iconC3;

	private Icon[] imagensSilhueta = new Icon[12];
	private static final String URL = "/spritesSilhueta/";
	static SilhuetaImagemData instancia = null;

	public SilhuetaImagemData() {

		// Movimentos à direita

		icon1 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Direita_1.png"));

		icon2 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Direita_2.png"));

		icon3 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Direita_3.png"));

		// Movimentos p/ Baixo

		iconB1 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Frente_1.png"));

		iconB2 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Frente_2.png"));

		iconB3 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Frente_3.png"));

		// Movimentos para esquerda

		iconL1 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Esquerda_1.png"));

		iconL2 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Esquerda_2.png"));

		iconL3 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Esquerda_3.png"));

		// movimentos para cima

		iconC1 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Costas_1.png"));

		iconC2 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Costas_2.png"));

		iconC3 = new ImageIcon(SilhuetaImagemData.class.getResource(URL + "Silhueta_Costas_3.png"));

		preencherVetorImagens();
	}

	private void preencherVetorImagens() {

		imagensSilhueta[0] = icon1;
		imagensSilhueta[1] = icon2;
		imagensSilhueta[2] = icon3;
		imagensSilhueta[3] = iconB1;
		imagensSilhueta[4] = iconB2;
		imagensSilhueta[5] = iconB3;
		imagensSilhueta[6] = iconL1;
		imagensSilhueta[7] = iconL2;
		imagensSilhueta[8] = iconL3;
		imagensSilhueta[9] = iconC1;
		imagensSilhueta[10] = iconC2;
		imagensSilhueta[11] = iconC3;
	}

	public void trocarParaSilhueta(Validavel personagem) {

		if (personagem.equals(Ecoman.getInstance()))
			EcomanImagemData.getInstance().trocarParaSilhueta(imagensSilhueta);
		else
			DirtymanImagemData.getInstance().trocarParaSilhueta(imagensSilhueta);

		TelaPrincipal.getInstance().elevarNivelSilhuetaPersonagem(personagem);
	}

	public static SilhuetaImagemData getInstance() {

		if (instancia == null) {
			instancia = new SilhuetaImagemData();
		}

		return instancia;
	}

	public void retornarImagensPersonagem(Validavel personagem) {

		if (personagem.equals(Ecoman.getInstance())) {
			EcomanImagemData.getInstance().preencherVetorImagens();
			TelaPrincipal.getInstance().descenderNivelSilhuetaPersonagem(personagem);
		} else {
			DirtymanImagemData.getInstance().preencherVetorImagens();
			TelaPrincipal.getInstance().descenderNivelSilhuetaPersonagem(personagem);
		}
	}
}
