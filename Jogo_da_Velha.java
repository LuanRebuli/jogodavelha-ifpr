import java.util.Random;
import java.util.Scanner;

public class Jogo_da_Velha {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        char[][] tabuleiro = new char[3][3];

        int i, j, posicao, jogadas;
        char simboloJogador1, simboloJogador2, simboloMaquina;
        String escolhaModo, escolhaJogador1;
        Boolean maquina, vezDoJogador, jogoAtivo = false, jogador;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }

        System.out.println("=== JOGO DA VELHA ===");
        System.out.println("Escolha o modo de jogo:");
        System.out.println("1 - Jogador vs Jogador (duas pessoas)");
        System.out.println("2 - Jogador vs Computador (desafie a máquina)");
        System.out.print("Digite sua escolha: ");
        escolhaModo = teclado.nextLine();

        jogador = escolhaModo.equals("1");
        maquina = escolhaModo.equals("2");

        if (maquina) {
            System.out.println("Escolha com qual simbolo você quer jogar (X ou O):");
            escolhaJogador1 = teclado.nextLine().toUpperCase();
            if (escolhaJogador1.equals("X")) {
                simboloJogador1 = 'X';
                simboloMaquina = 'O';
            } else if (escolhaJogador1.equals("O")) {
                simboloJogador1 = 'O';
                simboloMaquina = 'X';
            } else {
                System.out.println("Simbolo inválido. Jogador 1 com X por padrão.");
                simboloJogador1 = 'X';
                simboloMaquina = 'O';
            }
            System.out.println(" ");
            System.out.println("Explicação do Jogo: O tabuleiro é numerado de 1 a 9, como um teclado numérico. Cada número representa uma posição onde você pode jogar. Veja abaixo:");
            exibirTabuleiroNumerico();
            System.out.println("Digite start para começar o jogo contra CPU! você é o: " + simboloJogador1);
            String resposta = teclado.nextLine().toLowerCase();
            if (resposta.equals("start")) {
                jogoAtivo = true;
            } else {
                System.out.println("Jogo não iniciado. Encerrando.");
                return;
            }

            while (jogoAtivo) {
                exibirTabuleiro(tabuleiro);

                vezDoJogador = random.nextBoolean();
                jogadas = 0;
                while (jogadas < 9) {
                    if (vezDoJogador) {
                        System.out.println("Jogador 1: Sua vez! Digite a posição (1-9):");
                        posicao = teclado.nextInt();
                        teclado.nextLine();
                        if (verificaPosicao(tabuleiro, posicao) != 0) {
                            fazerJogada(tabuleiro, posicao, simboloJogador1);
                            if (verificarVitoria(tabuleiro, simboloJogador1)) {
                                exibirTabuleiro(tabuleiro);
                                System.out.println("Jogador com símbolo " + simboloJogador1 + " venceu!");
                                jogoAtivo = false;
                                return;
                            }
                        } else {
                            System.out.println("Posição inválida ou já ocupada. Tente novamente.");
                            continue;
                        }
                    } else {
                        System.out.println("Máquina: Sua vez!");
                        jogadaMaquina(tabuleiro, simboloMaquina, simboloJogador1);
                        if (verificarVitoria(tabuleiro, simboloMaquina)) {
                            exibirTabuleiro(tabuleiro);
                            System.out.println("Jogador com símbolo " + simboloMaquina + " venceu!");
                            jogoAtivo = false;
                            return;
                        }
                    }
                    exibirTabuleiro(tabuleiro);
                    vezDoJogador = !vezDoJogador;
                    jogadas++;
                }
                System.out.println("Empate!");
                return;
            }
        } else if (jogador) {
            System.out.println("Escolha com qual simbolo Jogador 1 jogará: (X ou O)");
            escolhaJogador1 = teclado.nextLine().toUpperCase();
            if (escolhaJogador1.equals("X")) {
                simboloJogador1 = 'X';
                simboloJogador2 = 'O';
            } else if (escolhaJogador1.equals("O")) {
                simboloJogador1 = 'O';
                simboloJogador2 = 'X';
            } else {
                System.out.println("Simbolo inválido. Jogador 1 com X por padrão.");
                simboloJogador1 = 'X';
                simboloJogador2 = 'O';
            }
            System.out.println(" ");
            System.out.println("Explicação do Jogo: O tabuleiro é numerado de 1 a 9, como um teclado numérico. Cada número representa uma posição onde você pode jogar. Veja abaixo:");
            exibirTabuleiroNumerico();
            System.out.println("Digite start para começar o jogo!");
            System.out.println("Simbolo do Jogador 1: " + simboloJogador1);
            System.out.println("Simbolo do Jogador 2: " + simboloJogador2);
            String resposta = teclado.nextLine().toLowerCase();
            if (resposta.equals("start")) {
                jogoAtivo = true;
            } else {
                System.out.println("Jogo não iniciado. Encerrando.");
                return;
            }
            exibirTabuleiro(tabuleiro);
            while (jogoAtivo) {
                vezDoJogador = random.nextBoolean();
                jogadas = 0;
                while (jogadas < 9) {
                    if (vezDoJogador) {
                        System.out.println("Jogador 1: " + simboloJogador1 + " Sua vez! Digite a posição (1-9):");
                        posicao = teclado.nextInt();
                        teclado.nextLine();
                        if (verificaPosicao(tabuleiro, posicao) != 0) {
                            fazerJogada(tabuleiro, posicao, simboloJogador1);
                            if (verificarVitoria(tabuleiro, simboloJogador1)) {
                                System.out.println("Jogador com símbolo " + simboloJogador1 + " venceu!");
                                jogoAtivo = false;
                                return;
                            }
                        } else {
                            System.out.println("Posição inválida ou já ocupada. Tente novamente.");
                            continue;
                        }
                    } else {
                        System.out.println("Jogador 2: " + simboloJogador2 + " Sua vez! Digite a posição (1-9):");
                        posicao = teclado.nextInt();
                        teclado.nextLine();
                        if (verificaPosicao(tabuleiro, posicao) != 0) {
                            fazerJogada(tabuleiro, posicao, simboloJogador2);
                            if (verificarVitoria(tabuleiro, simboloJogador2)) {
                                System.out.println("Jogador com símbolo " + simboloJogador2 + " venceu!");
                                jogoAtivo = false;
                                return;
                            }
                        } else {
                            System.out.println("Posição inválida ou já ocupada. Tente novamente.");
                            continue;
                        }
                    }
                    vezDoJogador = !vezDoJogador;
                    jogadas++;
                    exibirTabuleiro(tabuleiro);
                }
                System.out.println("Empate!");
                return;
            }
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

    public static void exibirTabuleiroNumerico() {
        int num = 1;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(num++ + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static void fazerJogada(char[][] tabuleiro, int posicao, char simbolo) {
        switch (posicao) {
            case 1:
                tabuleiro[0][0] = simbolo;
                break;
            case 2:
                tabuleiro[0][1] = simbolo;
                break;
            case 3:
                tabuleiro[0][2] = simbolo;
                break;
            case 4:
                tabuleiro[1][0] = simbolo;
                break;
            case 5:
                tabuleiro[1][1] = simbolo;
                break;
            case 6:
                tabuleiro[1][2] = simbolo;
                break;
            case 7:
                tabuleiro[2][0] = simbolo;
                break;
            case 8:
                tabuleiro[2][1] = simbolo;
                break;
            case 9:
                tabuleiro[2][2] = simbolo;
                break;
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

    public static void jogadaMaquina(char[][] tabuleiro, char simboloMaquina, char simboloHumano) {
        int[] cantos = {1, 3, 7, 9};

        for (int pos = 1; pos <= 9; pos++) {
            if (verificaPosicao(tabuleiro, pos) != 0) {
                char[][] copia = copiarTabuleiro(tabuleiro);
                fazerJogada(copia, pos, simboloMaquina);
                if (verificarVitoria(copia, simboloMaquina)) {
                    fazerJogada(tabuleiro, pos, simboloMaquina);
                    return;
                }
            }
        }

        for (int pos = 1; pos <= 9; pos++) {
            if (verificaPosicao(tabuleiro, pos) != 0) {
                char[][] copia = copiarTabuleiro(tabuleiro);
                fazerJogada(copia, pos, simboloHumano);
                if (verificarVitoria(copia, simboloHumano)) {
                    fazerJogada(tabuleiro, pos, simboloMaquina);
                    return;
                }
            }
        }

        if (verificaPosicao(tabuleiro, 5) != 0) {
            fazerJogada(tabuleiro, 5, simboloMaquina);
            return;
        }

        for (int canto : cantos) {
            if (verificaPosicao(tabuleiro, canto) != 0) {
                fazerJogada(tabuleiro, canto, simboloMaquina);
                return;
            }
        }

        for (int pos = 1; pos <= 9; pos++) {
            if (verificaPosicao(tabuleiro, pos) != 0) {
                fazerJogada(tabuleiro, pos, simboloMaquina);
                return;
            }
        }
    }

    public static boolean verificarVitoria(char[][] tabuleiro, char simbolo) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == simbolo && tabuleiro[1][i] == simbolo && tabuleiro[2][i] == simbolo) {
                return true;
            }
        }
        if (tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) {
            return true;
        }
        if (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo) {
            return true;
        }
        return false;
    }

    public static char[][] copiarTabuleiro(char[][] tabuleiroOriginal) {
        char[][] copia = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copia[i][j] = tabuleiroOriginal[i][j];
            }
        }
        return copia;
    }
}