package Personagens;

import javax.swing.JLabel;

import Telas.TelaPrincipal;

public class Dirtyman implements Validavel {

	private int posicaoX;
	private int posicaoY;
	private int largura;
	private int altura;
	private int tamanhoPasso;
	public JLabel dirtyImage;
	private static Dirtyman instancia;
	private TelaPrincipal telaPrincipal;

	public Dirtyman() {
		posicaoX = 0;
		posicaoY = 0;
		largura = 18;
		altura = 32;
		tamanhoPasso = 10;
		dirtyImage = new JLabel();
		dirtyImage.setBounds(300, 300, 10, 10);
		dirtyImage.setVisible(true);
	}

	public void mudarPosicao() {
		dirtyImage.setBounds(posicaoX, posicaoY, largura, altura);
		
		telaPrincipal = TelaPrincipal.getInstance();
		
		Integer x = getTamanhoPassoCompensadoEixoX();
		telaPrincipal.eixoX.setText(x.toString());

		Integer y = getTamanhoPassoCompensadoEixoY();
		telaPrincipal.eixoY.setText(y.toString());
	}

	public static Dirtyman getInstance() {

		if (instancia == null)
			instancia = new Dirtyman();

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

		Integer posicaoX = this.getPosicaoX();
		Integer posicaoY = this.getPosicaoY();

		while (posicaoX % 10 != 0) {
			posicaoX++;
		}

		while (posicaoY % 10 != 0) {
			posicaoY++;
		}

		telaPrincipal = TelaPrincipal.getInstance();
		telaPrincipal.jogarLixo(posicaoX, posicaoY);
	}

	public static void setInstance(Dirtyman novoDirtyMan) {

		instancia = novoDirtyMan;
	}

	public int getTamanhoPasso() {
		return tamanhoPasso;
	}

	public void setTamanhoPasso(int tamanhoPasso) {

		this.tamanhoPasso = tamanhoPasso;
	}

	public int getTamanhoPassoCompensadoEixoY() {

		int passoCompensado = posicaoY + (altura + 8) + tamanhoPasso;

		while (passoCompensado % 10 != 0) {

			passoCompensado++;
		}
		return passoCompensado;
	}

	public int getTamanhoPassoCompensadoEixoX() {

		int passoCompensado = posicaoX + (largura + 2) + tamanhoPasso;

		while (passoCompensado % 10 != 0) {

			passoCompensado++;
		}
		return passoCompensado;
	}
}
