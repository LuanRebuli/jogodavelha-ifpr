# Jogo da Velha (Tic-Tac-Toe) 🕹️

Este é um jogo da velha clássico implementado em Java, desenvolvido como um **trabalho acadêmico para o curso de Análise e Desenvolvimento de Sistemas (TADS) no IFPR**. Ele permite que você desafie um amigo ou teste suas habilidades contra uma inteligência artificial simples! ✨

---

## 🧾 Descrição

O objetivo principal deste projeto é recriar o famoso jogo da velha (ou "tic-tac-toe" para os íntimos) em Java. É um exercício prático para consolidar conceitos de lógica de programação, manipulação de arrays (para o tabuleiro) e criação de uma inteligência artificial básica. Simples, mas viciante! 😉

---

## 🖥️ Funcionalidades

Com o nosso Jogo da Velha, você pode:

- 🫂 **Modo Jogador vs. Jogador:** Chame um amigo e divirtam-se em uma partida clássica.
- 🤖 **Modo Jogador vs. Computador:** Desafie uma IA que tenta bloquear suas jogadas e busca a vitória!
- 🔠 **Escolha de Símbolo:** Decida se você quer ser 'X' ou 'O' no início do jogo.
- 🔢 **Tabuleiro Numerado:** O tabuleiro é exibido com posições de 1 a 9, facilitando a escolha da sua jogada.
- 🏆 **Verificação Automática:** O jogo detecta automaticamente se alguém venceu ou se a partida terminou em empate.

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído usando:

- **Java Development Kit (JDK) 8+** ☕

---

## 📦 Como Rodar o Projeto Localmente

Quer jogar o nosso Jogo da Velha na sua máquina? É super simples!

1.  **Clone o repositório** (ou baixe o arquivo `Jogo_da_Velha.java`):

    ```bash
    git clone [https://github.com/LuanRebuli/jogodavelha-ifpr.git](https://github.com/LuanRebuli/jogodavelha-ifpr.git)
    cd jogodavelha-ifpr
    ```

2.  **Compile o código-fonte:**

    ```bash
    javac Jogo_da_Velha.java
    ```

3.  **Execute o jogo:**

    ```bash
    java Jogo_da_Velha
    ```

    O jogo iniciará no seu terminal! 🎮

---

## 🔗 Como Jogar

1.  **Inicie o Jogo:** Após executar o programa, você verá as opções de modo de jogo.
2.  **Escolha o Modo:** Digite `1` para Jogador vs. Jogador ou `2` para Jogador vs. Computador.
3.  **Defina os Símbolos:** Se estiver jogando contra a máquina, escolha seu símbolo ('X' ou 'O'). Se for contra outro jogador, o Jogador 1 escolhe primeiro.
4.  **Comece a Partida:** Digite `start` para iniciar o jogo.
5.  **Faça sua Jogada:** O tabuleiro será exibido com números de 1 a 9. Digite o número da posição onde deseja colocar seu símbolo e pressione Enter.
    ```
    | 1 | 2 | 3 |
    -------------
    | 4 | 5 | 6 |
    -------------
    | 7 | 8 | 9 |
    -------------
    ```
6.  **Divirta-se!** O tabuleiro será atualizado a cada jogada até que um vencedor seja declarado ou haja um empate.

---

## 📁 Estrutura do Código

O projeto é bem conciso, contido em um único arquivo `Jogo_da_Velha.java`, que inclui:

* `public class Jogo_da_Velha`: A classe principal que gerencia o fluxo do jogo.
    * `public static void main(String[] args)`: O método principal, onde tudo começa.
    * `public static void exibirTabuleiro(char[][] tabuleiro)`: Mostra o tabuleiro atualizado.
    * `public static void exibirTabuleiroNumerico()`: Exibe a referência numérica das posições do tabuleiro.
    * `public static void fazerJogada(char[][] tabuleiro, int posicao, char simbolo)`: Coloca o símbolo do jogador ou da máquina na posição escolhida.
    * `public static int verificaPosicao(char[][] tabuleiro, int posicao)`: Checa se a posição é válida e está vazia.
    * `public static void jogadaMaquina(char[][] tabuleiro, char simboloMaquina, char simboloHumano)`: A lógica da nossa "IA", que tenta jogar inteligentemente.
    * `public static boolean verificarVitoria(char[][] tabuleiro, char simbolo)`: Verifica se um jogador alcançou a vitória.
    * `public static char[][] copiarTabuleiro(char[][] tabuleiroOriginal)`: Cria uma cópia do tabuleiro, útil para a IA simular movimentos.

---

## 📚 Conclusão do Curso

Este jogo é um marco no aprendizado do **curso de TADS no IFPR**, reforçando conceitos fundamentais de programação e lógica, como estruturas de controle, arrays e implementação de algoritmos simples (como a IA). É um projeto prático que demonstra a aplicação dos conhecimentos adquiridos! 🎓

---

## 👨‍💻 Desenvolvido por

[Luan Rebuli](https://github.com/LuanRebuli) ✨
