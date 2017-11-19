package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controles.ControleIniciarJogo;

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
public class antigoMenuPincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	static MenuPrincipal instancia;
	JLabel lblEcoman;
	Button botaoStart;
	Button botaoExit;
	Button botaoInstrucao;
	TelaInstrucoes telaControle;

	public antigoMenuPincipal() {

		instanciarComponentes();
		setProriedadesJanela();
		adicionarComponentesTela();
		setPropriedadesComponentes();
	}

	private void adicionarComponentesTela() {

		setContentPane(contentPane);
	}

	private void setPropriedadesComponentes() {

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setLayout(null);
		contentPane.add(lblEcoman);
		contentPane.add(botaoInstrucao);
		contentPane.add(botaoExit);
		contentPane.add(botaoStart);

		lblEcoman.setForeground(new Color(0, 51, 0));
		lblEcoman.setToolTipText("");
		lblEcoman.setHorizontalAlignment(SwingConstants.CENTER);
		lblEcoman.setFont(new Font("Tahoma", Font.BOLD, 42));
		botaoInstrucao.addActionListener(this);
		botaoExit.addActionListener(this);
		botaoStart.addActionListener(this);
	}

	private void instanciarComponentes() {

		contentPane = new JPanel();
		lblEcoman = new JLabel("ECOMAN");
		lblEcoman.setBounds(110, 48, 197, 68);
		botaoStart = new Button("Iniciar jogo");
		botaoStart.setBounds(174, 147, 70, 22);
		botaoExit = new Button("Sair");
		botaoExit.setBounds(174, 209, 70, 22);
		botaoInstrucao = new Button("Instruções");
		botaoInstrucao.setBounds(174, 181, 70, 22);

	}

	private void setProriedadesJanela() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Vitor\\Desktop\\ecoman.gif"));
		setForeground(SystemColor.textText);
		setTitle("ECOMAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
	}

	public static MenuPrincipal getInstance() {

		if (instancia == null)
			instancia = new MenuPrincipal();

		return instancia;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == botaoStart) {

			dispose();
			ControleIniciarJogo.IniciarJogo();
		} else if (ae.getSource() == botaoExit) {

			System.exit(0);
		} else if (ae.getSource() == botaoInstrucao) {

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
			
			telaControle = new TelaInstrucoes();
		}
	}
}
