package Personagens;

import java.awt.Button;

import Telas.TelaPrincipal;


public class DirtyMan implements Validavel{

	private int posicaoX;
	private int posicaoY;
	private int largura;
	private int altura;
	public Button btnDirtyman;
	static DirtyMan instancia;
	TelaPrincipal telaPrincipal;
	
	public DirtyMan() {
		posicaoX = 250;
		posicaoY = 300;
		largura = 18;
		altura = 32;
		
		btnDirtyman = new Button("DIRTYMAN");
		btnDirtyman.setBounds(posicaoX, posicaoY, largura, altura);
	}

	public void mudarPosicao(){
		btnDirtyman.setBounds(posicaoX, posicaoY, largura, altura);
	}
	
	public static DirtyMan getInstance() {

		if (instancia == null)
			instancia = new DirtyMan();

		return instancia;
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posixaoY) {
		this.posicaoY = posixaoY;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void jogarLixo() {
		
		telaPrincipal = TelaPrincipal.getInstance();
		telaPrincipal.jogarLixo();
	}

	public static void setInstance(DirtyMan novoDirtyMan) {
		
		instancia = novoDirtyMan;
	}
}
