package data;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DirtymanImagemData {

	private Icon iconD1, iconD2, iconD3, iconDB1, iconDB2, iconDB3, iconDL1, iconDL2, iconDL3, iconDC1, iconDC2,
			iconDC3;

	private Icon[] imagensDirtyman = new Icon[12];
	private static final String URL = "/spritesDirtyman/";
	static DirtymanImagemData instancia = null;

	private DirtymanImagemData() {

		// Movimentos à direita

		iconD1 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Direita_1.png"));

		iconD2 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Direita_2.png"));

		iconD3 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Direita_3.png"));

		// Movimentos p/ Baixo

		iconDB1 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Frente_1.png"));

		iconDB2 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Frente_2.png"));

		iconDB3 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Frente_3.png"));

		// Movimentos para esquerda

		iconDL1 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Esquerda_1.png"));

		iconDL2 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Esquerda_2.png"));

		iconDL3 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Esquerda_3.png"));

		// movimentos para cima

		iconDC1 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Costas_1.png"));

		iconDC2 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Costas_2.png"));

		iconDC3 = new ImageIcon(DirtymanImagemData.class.getResource(URL + "Costas_3.png"));

		preencherVetorImagens();
	}

	public Icon[] getVetorImagens() {

		return imagensDirtyman;
	}

	public void preencherVetorImagens() {

		imagensDirtyman[0] = iconD1;
		imagensDirtyman[1] = iconD2;
		imagensDirtyman[2] = iconD3;
		imagensDirtyman[3] = iconDB1;
		imagensDirtyman[4] = iconDB2;
		imagensDirtyman[5] = iconDB3;
		imagensDirtyman[6] = iconDL1;
		imagensDirtyman[7] = iconDL2;
		imagensDirtyman[8] = iconDL3;
		imagensDirtyman[9] = iconDC1;
		imagensDirtyman[10] = iconDC2;
		imagensDirtyman[11] = iconDC3;
	}

	public Icon[] recuperarImagens() {

		return imagensDirtyman;
	}

	public static DirtymanImagemData getInstance() {

		if (instancia == null)
			instancia = new DirtymanImagemData();

		return instancia;
	}

	public void trocarParaSilhueta(Icon[] silhuetas) {

		for (int i = 0; i < silhuetas.length; i++) {

			imagensDirtyman[i] = silhuetas[i];
		}
	}
}
