
package br.com.solutis.jogo.de.adivinhacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Swing extends JFrame {
	private int numeroSorteado;
	private int tentativas = 5;
	private JTextField campoPalpite;
	private JLabel labelResultado;
	private JLabel labelTentativas;

	public Swing() {
		// Configurações da janela
		setTitle("Jogo de Adivinhação");
		setSize(400, 200); // Largura x Altura
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// Gera o número secreto
		Random random = new Random();
		numeroSorteado = random.nextInt(100) + 1;

		// Componentes da interface
		JLabel labelInstrucao = new JLabel("Adivinhe um número entre 1 e 100:");
		campoPalpite = new JTextField(10);
		JButton botaoPalpite = new JButton("Enviar Palpite");
		labelResultado = new JLabel("");
		labelTentativas = new JLabel("Tentativas restantes: " + tentativas);

		// Adiciona os componentes à janela
		add(labelInstrucao);
		add(campoPalpite);
		add(botaoPalpite);
		add(labelResultado);
		add(labelTentativas);

		// Ação do botão
		botaoPalpite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarPalpite();
			}
		});
	}

	// Verifica o palpite do jogador
	private void verificarPalpite() {
		try {
			int palpite = Integer.parseInt(campoPalpite.getText());

			// Verifica se o palpite está no intervalo de 1 a 100
			if (palpite < 1 || palpite > 100) {
				labelResultado.setText("Por favor, insira um número entre 1 e 100.");
				return;
			}

			if (palpite == numeroSorteado) {
				labelResultado.setText("Parabéns! Você acertou!");
				campoPalpite.setEditable(false); // Desativa o campo de texto
			} else if (palpite > numeroSorteado) {
				labelResultado.setText("Too High! Tente um número menor.");
			} else {
				labelResultado.setText("Too Low! Tente um número maior.");
			}

			tentativas--;
			labelTentativas.setText("Tentativas restantes: " + tentativas);

			if (tentativas == 0 && palpite != numeroSorteado) {
				labelResultado.setText("Você perdeu! O número era: " + numeroSorteado);
				campoPalpite.setEditable(false); // Desativa o campo de texto
			}

		} catch (NumberFormatException ex) {
			labelResultado.setText("Por favor, insira um número válido.");
		}
	}

	// Método principal para iniciar a aplicação
	public static void main(String[] args) {
		Swing jogo = new Swing();
		jogo.setVisible(true);
	}
}

