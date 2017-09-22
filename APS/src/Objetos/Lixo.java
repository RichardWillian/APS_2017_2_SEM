package Objetos;

import java.awt.Button;

public class Lixo {

	private int posicaoX;
	private int posicaoY;
	private int largura;
	private int altura;
	public Button btnLixo;
	static Lixo instancia;

	public Lixo() {

		posicaoX = 10;
		posicaoY = 30;
		largura = 60;
		altura = 60;
		btnLixo = new Button("LIXO");
		
		btnLixo.setBounds(posicaoX, posicaoY, largura, altura);
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
}
