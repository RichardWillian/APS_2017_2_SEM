package data;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class EcomanImagemData {

	public Icon icon1, icon2, icon3, iconB1, iconB2, iconB3, iconL1, iconL2, iconL3, iconC1, iconC2, iconC3;

	private Icon[] imagensEcoman = new Icon[12];
	private static final String URL = "/spritesEcoman/";
	static EcomanImagemData instancia = null;

	private EcomanImagemData() {

		// Movimentos à direita

		icon1 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Direita_1.png"));

		icon2 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Direita_2.png"));

		icon3 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Direita_3.png"));

		// Movimentos p/ Baixo

		iconB1 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Frente_1.png"));

		iconB2 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Frente_2.png"));

		iconB3 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Frente_3.png"));

		// Movimentos para esquerda

		iconL1 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Esquerda_1.png"));

		iconL2 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Esquerda_2.png"));

		iconL3 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Esquerda_3.png"));

		// movimentos para cima

		iconC1 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Costas_1.png"));

		iconC2 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Costas_2.png"));

		iconC3 = new ImageIcon(EcomanImagemData.class.getResource(URL + "Costas_3.png"));

		preencherVetorImagens();
	}

	public Icon[] recuperarImagens() {

		return imagensEcoman;
	}

	public void preencherVetorImagens() {

		imagensEcoman[0] = icon1;
		imagensEcoman[1] = icon2;
		imagensEcoman[2] = icon3;
		imagensEcoman[3] = iconB1;
		imagensEcoman[4] = iconB2;
		imagensEcoman[5] = iconB3;
		imagensEcoman[6] = iconL1;
		imagensEcoman[7] = iconL2;
		imagensEcoman[8] = iconL3;
		imagensEcoman[9] = iconC1;
		imagensEcoman[10] = iconC2;
		imagensEcoman[11] = iconC3;
	}

	public static EcomanImagemData getInstance() {

		if (instancia == null)
			instancia = new EcomanImagemData();

		return instancia;
	}

	public void trocarParaSilhueta(Icon[] silhuetas) {

		for (int i = 0; i < silhuetas.length; i++) {

			imagensEcoman[i] = silhuetas[i];
		}
	}
}