package com.pucrs.mauricio.mochila;

public class KnapsackMatriz {
    private int iteracoes;
    private int instrucoes;
    private long tempoExecucao;

    public int numIteracoes() {
        return this.iteracoes;
    }

    public int numInstrucoes() {
        return this.instrucoes;
    }

    public long tempoExecucao() {
        return this.tempoExecucao;
    }

    public int run(int capacidade, int[] valores, int[] pesos) {
        if (valores.length != pesos.length) {
            return -1;
        }
        long ti = System.nanoTime();
        int res = knapsack(capacidade, valores, pesos);
        this.tempoExecucao = System.nanoTime() - ti;
        return res;
    }

    private int knapsack(int capacidade, int[] valores, int[] pesos) {
        int[][] maxTab = new int[valores.length + 1][capacidade + 1];
        for (int i = 0; i < maxTab[0].length; i++) {
            maxTab[0][i] = 0;
        }
        for (int i = 0; i < maxTab.length; i++) {
            maxTab[i][0] = 0;
        }

        this.instrucoes += 3;
        for (int i = 1; i <= valores.length; i++) {
            this.iteracoes++;
            this.instrucoes += 3;
            for (int j = 1; j <= capacidade; j++) {
                this.iteracoes++;
                this.instrucoes += 4;
                if (pesos[i - 1] <= j) {
                    this.instrucoes += 12;
                    maxTab[i][j] = Math.max(maxTab[i - 1][j], valores[i - 1] + maxTab[i - 1][j - pesos[i - 1]]);
                } else {
                    this.instrucoes += 4;
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }
        this.instrucoes += 2;
        return maxTab[valores.length][capacidade];
    }
}
