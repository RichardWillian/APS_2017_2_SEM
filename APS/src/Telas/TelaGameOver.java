package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaGameOver extends JanelaBase{
	
	Button botaoSim;
	Button botaoNao;
	Label lblGameOver;
	
	public TelaGameOver(){
		
		setPropriedadesjanela();
		instanciarComponentes();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}
	
	private void setPropriedadesComponentes() {
		
		botaoSim.setBounds(48, 220, 100,40);
		botaoNao.setBounds(250, 220, 100,40);
		lblGameOver.setBounds(165, 50, 100,40);
	}
	
	private void instanciarComponentes() {
		
		botaoSim = new Button("SIM");
		botaoNao = new Button("NÃO");
		lblGameOver = new Label("GAME OVER");
	}
	
	private void adicionarComponentesTela() {

		this.add(botaoSim);
		this.add(botaoNao);
		this.add(lblGameOver);
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
			
		}
		else if(e.getSource() == botaoNao){
			
		}
	}
}
