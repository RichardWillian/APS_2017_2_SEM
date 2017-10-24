package Imagens;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class EcomanImagemData {

	public Icon icon1, icon2, icon3, iconB1, iconB2, iconB3, iconL1, iconL2, iconL3, iconC1, iconC2, iconC3;
	String pacote = "/spritesEcoman/";
	String silhueta = "Silhueta_";
	public EcomanImagemData() {

		// Movimentos à direita

		icon1 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Direita_1.png"));

		icon2 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Direita_2.png"));

		icon3 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Direita_3.png"));

		// Movimentos p/ Baixo

		iconB1 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Frente_1.png"));

		iconB2 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Frente_2.png"));

		iconB3 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Frente_3.png"));

		// Movimentos para esquerda

		iconL1 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Esquerda_1.png"));

		iconL2 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Esquerda_2.png"));

		iconL3 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Esquerda_3.png"));

		// movimentos para cima

		iconC1 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Costas_1.png"));

		iconC2 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Costas_2.png"));

		iconC3 = new ImageIcon(EcomanImagemData.class.getResource(pacote + silhueta + "Costas_3.png"));

	}
}