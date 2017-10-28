package Personagens;

import javax.swing.JLabel;

public class Ecoman implements Validavel{

	private int posicaoX;
	private int posicaoY;
	private int largura;
	private int altura;
	private int tamanhoPasso;
	private boolean carregandoLixo;
	static Ecoman instancia;
	public JLabel ecoImage;
	public Ecoman() {

		ecoImage = new JLabel();
		posicaoX = 100;
		posicaoY = 100;
		largura = 18;
		altura = 32;
		tamanhoPasso = 10;
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

	public int getTamanhoPasso() {
		return tamanhoPasso;
	}

	public void setTamanhoPasso(int tamanhoPasso) {
		this.tamanhoPasso = tamanhoPasso;
	}
	
	public int getTamanhoPassoCompensadoEixoY() {
		
		return posicaoY + (altura + 8) + tamanhoPasso;
	}
	
	public int getTamanhoPassoCompensadoEixoX() {
		
		return posicaoX + (largura + 2) + tamanhoPasso;
	}
}
