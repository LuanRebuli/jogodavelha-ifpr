package JogodaVelha;

import java.util.Random;
import java.util.Scanner;

public class Jogo_da_Velha {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        char[][] tabuleiro = new char[3][3];

        int i, j, posicao, jogadas;
        char simboloJogador1, simboloJogador2, simboloMaquina;
        String escolhaModo, escolhaJogador1, escolhaJogador2;
        Boolean maquina, venceu, empate, vezDoJogador, start, jogador;

        char numero = '1';
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                tabuleiro[i][j] = numero++;
            }
        }

        System.out.println("Jogo da Velha");
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1 - Jogador vs Jogador");
        System.out.println("2 - Jogador vs Computador");
        escolhaModo = teclado.nextLine();

        jogador = escolhaModo.equals("1");
        maquina = escolhaModo.equals("2");

        if(maquina) {
            System.out.println("Escolha com qual simbolo você quer jogar (X ou O):");
            escolhaJogador1 = teclado.nextLine().toUpperCase();
            if (escolhaJogador1.equals("X")) {
                simboloJogador1 = 'X';
                simboloMaquina = 'O';
            } else if(escolhaJogador1.equals("O")) {
                simboloJogador1 = 'O';
                simboloMaquina = 'X';
            } else {
                System.out.println("Simbolo inválido. Jogador 1 com X por padrão.");
                simboloJogador1 = 'X';
                simboloMaquina = 'O';
            }
            System.out.println(" ");
            System.out.println("Explicação do Jogo: Cada número é uma posição no tabuleiro!");
            exibirTabuleiro(tabuleiro);
            System.out.println("Digite start para começar o jogo:");
            String resposta = teclado.nextLine().toLowerCase();
            if(resposta.equals("start")) {
                start = true;
            } else {
                System.out.println("Jogo não iniciado. Encerrando.");
                return;
            }

            while(start) {
                System.out.println(" ");
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        tabuleiro[i][j] = ' ';
                    }
                }
                exibirTabuleiro(tabuleiro);

                vezDoJogador = random.nextBoolean();

                jogadas = 0;
                while(jogadas < 9) {
                    if(vezDoJogador) {
                        System.out.println("Jogador 1: Sua vez! Digite a posição (1-9):");
                        posicao = teclado.nextInt();
                        if (verificaPosicao(tabuleiro, posicao) != 0) { 
                            fazerJogada(tabuleiro, posicao, simboloJogador1);
                            if (verificarVitoria(tabuleiro, simboloJogador1)) {
                                start = false;
                                break;
                            }
                        } else {
                            System.out.println("Posição inválida ou já ocupada. Tente novamente.");
                            continue;
                        }
                    } else {
                        System.out.println("Máquina: Sua vez!");
                        posicao = random.nextInt(9) + 1;
                        while (verificaPosicao(tabuleiro, posicao) == 0) {
                            posicao = random.nextInt(9) + 1;
                        }
                        jogadaMaquina(tabuleiro, posicao, simboloMaquina);
                        if (verificarVitoria(tabuleiro, simboloMaquina)) {
                            start = false;
                            break;
                        }
                    }
                    exibirTabuleiro(tabuleiro);
                    vezDoJogador = !vezDoJogador;
                    jogadas++;
                }
            }
        } else if(jogador) {
            System.out.println("Jogando contra jogador");
        }
    }

    public static void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static void fazerJogada(char[][] tabuleiro, int posicao, char simbolo) {
        switch(posicao) {
            case 1: tabuleiro[0][0] = simbolo; break;
            case 2: tabuleiro[0][1] = simbolo; break;
            case 3: tabuleiro[0][2] = simbolo; break;
            case 4: tabuleiro[1][0] = simbolo; break;
            case 5: tabuleiro[1][1] = simbolo; break;
            case 6: tabuleiro[1][2] = simbolo; break;
            case 7: tabuleiro[2][0] = simbolo; break;
            case 8: tabuleiro[2][1] = simbolo; break;
            case 9: tabuleiro[2][2] = simbolo; break;
        }
    }

    public static int verificaPosicao(char[][] tabuleiro, int posicao) {
        return switch (posicao) {
            case 1 -> (tabuleiro[0][0] == ' ') ? 1 : 0;
            case 2 -> (tabuleiro[0][1] == ' ') ? 2 : 0;
            case 3 -> (tabuleiro[0][2] == ' ') ? 3 : 0;
            case 4 -> (tabuleiro[1][0] == ' ') ? 4 : 0;
            case 5 -> (tabuleiro[1][1] == ' ') ? 5 : 0;
            case 6 -> (tabuleiro[1][2] == ' ') ? 6 : 0;
            case 7 -> (tabuleiro[2][0] == ' ') ? 7 : 0;
            case 8 -> (tabuleiro[2][1] == ' ') ? 8 : 0;
            case 9 -> (tabuleiro[2][2] == ' ') ? 9 : 0;
            default -> 0;
        };
    }

    public static void jogadaMaquina(char[][] tabuleiro, int posicao, char simbolo) {
        fazerJogada(tabuleiro, posicao, simbolo);
    }

    public static boolean verificarVitoria(char[][] tabuleiro, char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) {
                System.out.println("Jogador com símbolo " + simbolo + " venceu!");
                return true;
            }
            if (tabuleiro[0][i] == simbolo && tabuleiro[1][i] == simbolo && tabuleiro[2][i] == simbolo) {
                System.out.println("Jogador com símbolo " + simbolo + " venceu!");
                return true;
            }

            if(tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) {
                System.out.println("Jogador com símbolo " + simbolo + " venceu!");
                return true;
            }
        }

        return false;
    }

}
