package telas;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;

import controles.ControleIniciarJogo;

@SuppressWarnings("serial")
public class TelaVenceuJogo extends JanelaBase {

	private Button botaoReiniciarJogo;
	private Button botaoVoltarMenuPrincipal;
	private Label lblParabens;
	private MenuPrincipal menuPrincipal;
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
		botaoReiniciarJogo.setActionCommand("Reiniciar");

		botaoVoltarMenuPrincipal.setBounds(250, 220, 100, 40);
		botaoVoltarMenuPrincipal.addActionListener(this);
		botaoVoltarMenuPrincipal.setActionCommand("Voltar");

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

		if (e.getActionCommand() == "Reiniciar") {
			
			ControleIniciarJogo.IniciarJogo();
			this.dispose(); 
		} else if (e.getActionCommand() == "Voltar") {

			menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible(true);
			this.dispose();
		}
	}
}
