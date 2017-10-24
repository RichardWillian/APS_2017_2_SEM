package Imagens;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DirtymanImagemData {

	
	public Icon iconD1, iconD2, iconD3,
	iconDB1, iconDB2, iconDB3, 
	iconDL1, iconDL2, iconDL3,
	iconDC1, iconDC2, iconDC3;

	
	public DirtymanImagemData() {
	
	

    	//Movimentos à direita

    	iconD1  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Direita_1.png"));
    	
    	iconD2  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Direita_2.png"));
 
    	iconD3  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Direita_3.png"));
    	
    	//Movimentos p/ Baixo
    	
    	
    	iconDB1  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Frente_1.png"));
    	
    	iconDB2  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Frente_2.png"));
    	    	
    	iconDB3  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Frente_3.png"));
    	
    	
    	//Movimentos para esquerda
    	
    	
    	iconDL1  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Esquerda_1.png"));
    	
    	iconDL2  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Esquerda_2.png"));
    	
    	iconDL3  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Esquerda_3.png"));
    	
    	
    	//movimentos para cima
    	
    	
    	iconDC1  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Costas_1.png"));
    	
    	iconDC2  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Costas_2.png"));
    	
    	iconDC3  = new ImageIcon(DirtymanImagemData.class.getResource("/spritesDirtyman/Costas_3.png"));	
	}
}
