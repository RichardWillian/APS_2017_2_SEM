package data;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LixoImgData {

	String prefixo = "/lixoImg/";

	private Icon icone[];

	public LixoImgData() {
		
		icone = new Icon[7];
		
		icone[0] = new ImageIcon(LixoImgData.class.getResource(prefixo + "iconeLata.png"));
		
		icone[1] = new ImageIcon(LixoImgData.class.getResource(prefixo + "iconeGarrafa.png"));
		
		icone[2] = new ImageIcon(LixoImgData.class.getResource(prefixo + "iconeGarrafa2.png"));
		
		icone[3] = new ImageIcon(LixoImgData.class.getResource(prefixo + "iconePapel.png"));
		
		icone[4] = new ImageIcon(LixoImgData.class.getResource(prefixo + "iconeLivro.png"));
		
		icone[5] = new ImageIcon(LixoImgData.class.getResource(prefixo + "iconeCaixa.png"));
		
		icone[6] = new ImageIcon(LixoImgData.class.getResource(prefixo + "iconeSacola.png"));
	}
	
	
	public Icon getIconeLixo(int iconeSorteado) {
		
		return icone[iconeSorteado % 7];
	}

}
