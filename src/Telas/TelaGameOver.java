package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;

import Controles.ControleIniciarJogo;

@SuppressWarnings("serial")
public class TelaGameOver extends JanelaBase{
	
	Button botaoSim;
	Button botaoNao;
	Label lblGameOver;
	Label lblReiniciar;
	MenuPincipal menuPrincipal;
	
	public TelaGameOver(){
		
		setPropriedadesjanela();
		instanciarComponentes();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}

	private void setPropriedadesComponentes() {
		
		botaoSim.setBounds(48, 220, 100,40);
		botaoSim.addActionListener(this);
		
		botaoNao.setBounds(250, 220, 100,40);
		botaoNao.addActionListener(this);
		
		lblGameOver.setBounds(115, 50, 200,40);
		lblReiniciar.setBounds(105,150, 250,40);
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
		this.setResizable(false);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setFocusable(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == botaoSim){
			
			ControleIniciarJogo.IniciarJogo();
			this.dispose();
		}
		else if(e.getSource() == botaoNao){
			
			menuPrincipal = new MenuPincipal();
			menuPrincipal.setVisible(true);
			this.dispose();
		}
	}
}
