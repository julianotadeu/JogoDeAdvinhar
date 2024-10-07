
package br.com.solutis.jogo.de.adivinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoDeAdivinhacao {

    public static void main(String[] args) {
        
        int tentativas = 5;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numeroSorteado = random.nextInt(100) + 1;
        
        boolean respostaCerta = false;
        
        System.out.println("|-----Jogo de Adivinhação-----|");
        System.out.println("Você tem " + tentativas + " tentativas para acertar o número sorteado (1 a 100)!");
        
        while (tentativas > 0 && !respostaCerta) {
            
            System.out.println("Digite um número: ");
            int tentativa = scanner.nextInt();
            
            // Validação para garantir que o número está entre 1 e 100
            if (tentativa < 1 || tentativa > 100) {
                System.out.println("Por favor, digite um número entre 1 e 100.");
                continue; // Volta ao início do laço
            }

            if (tentativa == numeroSorteado) {
                respostaCerta = true;
                System.out.println("Parabéns! Você conseguiu adivinhar em "+ (5 - tentativas + 1)+" tentativas!");
                break;
            } else if (tentativa > numeroSorteado) {
                System.out.println("(Dica: Tente um número menor)");
            } else {
                System.out.println("(Dica: Tente um número maior)");
            }
            
            tentativas--;
            System.out.println("Tentativas restantes: " + tentativas+"\n");
        }
        
        // Caso as tentativas acabem e a resposta esteja errada
        if (tentativas == 0 && !respostaCerta) {
            System.out.println("Não foi dessa vez! O número sorteado foi: " + numeroSorteado);
        }
        
        scanner.close();
    }
}

