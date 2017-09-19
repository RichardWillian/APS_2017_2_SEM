package Objetos;

import java.awt.Button;

public class Lixeira {

	private int posicaoX;
	private int posicaoY;
	private int largura;
	private int altura;
	public Button btnLixeira;
	static Lixeira instancia;

	public Lixeira() {

		posicaoX = 600;
		posicaoY = 300;
		largura = 60;
		altura = 60;
		btnLixeira = new Button("LIXEIRA");

		btnLixeira.setBounds(posicaoX, posicaoY, largura, altura);
	}

	public static Lixeira getInstance() {

		if (instancia == null)
			instancia = new Lixeira();

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
}
