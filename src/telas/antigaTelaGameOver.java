package telas;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;

import controles.ControleIniciarJogo;

@SuppressWarnings("serial")
public class antigaTelaGameOver extends JanelaBase {

	Button botaoSim;
	Button botaoNao;
	Label lblGameOver;
	Label lblReiniciar;
	MenuPrincipal menuPrincipal;

	public antigaTelaGameOver() {

		setPropriedadesjanela();
		instanciarComponentes();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}

	private void setPropriedadesComponentes() {

		botaoSim.setBounds(48, 220, 100, 40);
		botaoSim.addActionListener(this);

		botaoNao.setBounds(250, 220, 100, 40);
		botaoNao.addActionListener(this);

		lblGameOver.setBounds(115, 50, 200, 40);
		lblReiniciar.setBounds(105, 150, 250, 40);
	}

	private void instanciarComponentes() {

		botaoSim = new Button("SIM");
		botaoNao = new Button("NÃO");

		lblGameOver = new Label("GAME OVER");
		lblGameOver.setFont(new Font("Tahoma", Font.BOLD, 30));

		lblReiniciar = new Label("Deseja Reiniciar ?");
		lblReiniciar.setFont(new Font("Tahoma", Font.BOLD, 25));
	}

	private void adicionarComponentesTela() {

		this.add(botaoSim);
		this.add(botaoNao);
		this.add(lblGameOver);
		this.add(lblReiniciar);
	}

	private void setPropriedadesjanela() {

		this.setLocation(450, 200);
		this.setSize(760, 360);
		this.setVisible(true);
		this.setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botaoSim) {
			ControleIniciarJogo.IniciarJogo();
			this.dispose();
		} else if (e.getSource() == botaoNao) {

			menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible(true);
			this.dispose();
		}
	}
}
