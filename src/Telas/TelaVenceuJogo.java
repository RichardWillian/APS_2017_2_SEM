package Telas;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;

import Controles.ControleEncerrarJogo;
import Controles.ControleIniciarJogo;

@SuppressWarnings("serial")
public class TelaVenceuJogo extends JanelaBase {

	private Button botaoReiniciarJogo;
	private Button botaoVoltarMenuPrincipal;
	private Label lblParabens;
	private MenuPincipal menuPrincipal;
	private Label lblFraseAgradecimento;
	TelaPrincipal telaPrincipal;

	public TelaVenceuJogo() {

		setPropriedadesjanela();
		instanciarComponentes();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}

	private void setPropriedadesComponentes() {

		botaoReiniciarJogo.setBounds(48, 220, 100, 40);
		botaoReiniciarJogo.addActionListener(this);

		botaoVoltarMenuPrincipal.setBounds(250, 220, 100, 40);
		botaoVoltarMenuPrincipal.addActionListener(this);

		lblParabens.setBounds(115, 50, 200, 40);

		lblFraseAgradecimento.setBounds(115, 110, 200, 40);
	}

	private void instanciarComponentes() {

		botaoReiniciarJogo = new Button("Reiniciar Jogo");
		botaoVoltarMenuPrincipal = new Button("Menu Principal");

		lblParabens = new Label("PARABÉNS");
		lblFraseAgradecimento = new Label("Obrigado por limpar nossa cidade !!!");
		lblParabens.setFont(new Font("Tahoma", Font.BOLD, 30));
	}

	private void adicionarComponentesTela() {

		this.add(botaoReiniciarJogo);
		this.add(botaoVoltarMenuPrincipal);
		this.add(lblFraseAgradecimento);
		this.add(lblParabens);
	}

	private void setPropriedadesjanela() {

		this.setLocation(450, 200);
		this.setResizable(false);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botaoReiniciarJogo) {

			ControleIniciarJogo.IniciarJogo();
			this.dispose();
		} else if (e.getSource() == botaoVoltarMenuPrincipal) {

			menuPrincipal = new MenuPincipal();
			menuPrincipal.setVisible(true);
			this.dispose();
		}

		ControleEncerrarJogo ctrlEncerrarJogo = new ControleEncerrarJogo();
		ctrlEncerrarJogo.encerrarJogo();
	}
}
