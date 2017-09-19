package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuPincipal extends JFrame {

	private JPanel contentPane;
	static MenuPincipal instancia;

	public MenuPincipal() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Vitor\\Desktop\\ecoman.gif"));
		setForeground(SystemColor.textText);
		setOpacity(1.0f);
		setTitle("ECOMAN");
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(153, 255, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEcoman = new JLabel("ECOMAN ");
		lblEcoman.setForeground(new Color(0, 51, 0));
		lblEcoman.setToolTipText("");
		lblEcoman.setHorizontalAlignment(SwingConstants.CENTER);
		lblEcoman.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblEcoman.setBounds(113, 47, 197, 68);
		contentPane.add(lblEcoman);
		
		final Button botaoStart = new Button("Start Game");
		botaoStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource() == botaoStart) {

					setVisible(false);
					@SuppressWarnings("unused")
					TelaPrincipal tela = TelaPrincipal.getInstance();
				}
			}
		});
		botaoStart.setBounds(174, 153, 70, 22);
		contentPane.add(botaoStart);
		
		final Button botaoInstrucao = new Button("Instructions");
		botaoInstrucao.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botaoInstrucao) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								TelaInstrucoes frame = new TelaInstrucoes();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					TelaInstrucoes telaControle = new TelaInstrucoes();
				}
			}
		});
		botaoInstrucao.setBounds(174, 181, 70, 22);
		contentPane.add(botaoInstrucao);
		
		final Button botaoExit = new Button("Exit");
		botaoExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botaoExit) {
					System.exit(0);
				}
			}
		});
		botaoExit.setBounds(174, 209, 70, 22);
		contentPane.add(botaoExit);
	}

	public static MenuPincipal getInstance() {
		
		if(instancia == null)
			instancia = new MenuPincipal();
		
		return instancia;
	}
}
