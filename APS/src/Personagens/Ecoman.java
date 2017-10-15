package Personagens;

import javax.swing.JLabel;

public class Ecoman {

	private int posicaoX;
	private int posicaoY;
	private int largura;
	private int altura;
	private boolean carregandoLixo;
	static Ecoman instancia;
	public JLabel ecoImage;

	public Ecoman() {

		ecoImage = new JLabel();
		ecoImage.setBounds(100, 100, 10, 10);
		ecoImage.setVisible(true);
		posicaoX = 100;
		posicaoY = 200;
		largura = 18;
		altura = 32;
		setCarregandoLixo(false);
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
