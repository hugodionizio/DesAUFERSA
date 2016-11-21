/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos.backtracking;

/**
 *
 * @author flavia
 */
public class PasseioDoCavalo {
//dx e dy usados para calcular as coordenadas dos movimentos possíveis

    final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    final int n; //número de posições do tabuleiro
    final int nCasas; //número total de casas
    int[][] tabuleiro;

    public PasseioDoCavalo(int n) {
        this.n = n;
        this.nCasas = n * n;
        this.tabuleiro = new int[n][n];
    }

    boolean ehAceitavel(int x, int y) {
//é aceitável se estiver dentro do tabuleiro e a se casa não foi visitada
        boolean result = (x >= 0 && x <= n - 1);
        result = result && (y >= 0 && y <= n - 1);
        result = result && (tabuleiro[x][y] == 0);
        return result;
    }
//tenta o i-ésimo movimento em (x, y)

    boolean tentaMovimento(int i, int x, int y) {
//Verifica a quantidade de movimentos
        boolean done = (i > nCasas);
        int k = 0;
        int u, v; //<u, v> é posição de destino e <x, y> é a posição atual
        while (!done && k < 8) {
//u e v são as coordenadas dos 8 movimentos possíveis em volta do cavalo
            u = x + dx[k];
            v = y + dy[k];
            if (ehAceitavel(u, v)) {
                tabuleiro[u][v] = i;
                done = tentaMovimento(i + 1, u, v); //tenta outro movimento
                if (!done) {
                    tabuleiro[u][v] = 0; //sem sucesso. Descarta movimento
                }
            }
            k = k + 1; //passa ao próximo movimento possível
        }
        return done;
    }

    void mostraPasseio(int x, int y) {
//mostra todos os movimentos a partir de (x, y)
        tabuleiro[x][y] = 1;
        boolean done = tentaMovimento(2, x, y);
        if (done) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Não há passeio possível");
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        new PasseioDoCavalo(n).mostraPasseio(x, y);
    }

    public void resetSemanas(Problema15Alunas problema15Alunas) {
        problema15Alunas.semanas = 0;
    }

    public void resetCombinacoes(Problema15Alunas problema15Alunas) {
        problema15Alunas.comb = 0;
    }

    public int getCombinacoes(Problema15Alunas problema15Alunas) {
        return problema15Alunas.comb;
    }

    public int getSemanas(Problema15Alunas problema15Alunas) {
        return problema15Alunas.semanas;
    }
}
