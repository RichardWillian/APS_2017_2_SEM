package Personagens;

import java.awt.Button;

public class Ecoman {

	private int posicaoX;
	private int posicaoY;
	private int largura;
	private int altura;
	public Button btnEcoman;
	private boolean carregandoLixo;
	static Ecoman instancia;

	public Ecoman() {

		posicaoX = 50;
		posicaoY = 80;
		largura = 60;
		altura = 60;
		setCarregandoLixo(false);
		btnEcoman = new Button("ECOMAN");
		btnEcoman.setBounds(posicaoX, posicaoY, largura, altura);
	}
	
	public static Ecoman getInstance() {

		if (instancia == null)
			instancia = new Ecoman();

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

	public boolean estaCarregandoLixo() {
		return carregandoLixo;
	}

	public void setCarregandoLixo(boolean carregandoLixo) {
		this.carregandoLixo = carregandoLixo;
	}

	public static void setInstance(Ecoman novoEcoman) {
		instancia = novoEcoman;
	}
}
