package Objetos;

public class LixeiraData {

	Lixeira lixeira;

	public Lixeira getLixeiraUm() {

		lixeira = new Lixeira();

		lixeira.setPosicaoX(315.4f);
		lixeira.setPosicaoY(175);
		return lixeira;
	}

	public Lixeira getLixeiraDoisA() {

		lixeira = new Lixeira();

		lixeira.setPosicaoX(740);
		lixeira.setPosicaoY(165.8f);
		return lixeira;
	}

	public Lixeira getLixeiraDoisB() {

		lixeira = new Lixeira();

		lixeira.setPosicaoX(770);
		lixeira.setPosicaoY(165.8f);
		return lixeira;
	}

	public Lixeira getLixeiraTresA() {

		lixeira = new Lixeira();

		lixeira.setPosicaoX(425);
		lixeira.setPosicaoY(595);
		return lixeira;
	}

	public Lixeira getLixeiraTresB() {

		lixeira = new Lixeira();

		lixeira.setPosicaoX(455);
		lixeira.setPosicaoY(595);
		return lixeira;   
	}

	public Lixeira getLixeira(int posicaoX, int posicaoY) {

		if (posicaoY > 300) {

			if (posicaoX < 410)
				return this.getLixeiraTresA();

			return this.getLixeiraTresB();

		} else if (posicaoX > 500) {
			if (posicaoX < 740)
				return this.getLixeiraDoisA();

			return this.getLixeiraDoisB();
		}
		return this.getLixeiraUm();
	}
}
