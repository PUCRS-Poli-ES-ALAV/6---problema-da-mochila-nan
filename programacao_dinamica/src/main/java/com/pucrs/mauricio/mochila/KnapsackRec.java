package com.pucrs.mauricio.mochila;

public class KnapsackRec {
    private int iteracoes;
    private int instrucoes;
    private long tempoExecucao;

    public long tempoExecucao() {
        return this.tempoExecucao;
    }

    public int numIteracoes() {
        return this.iteracoes;
    }

    public int numInstrucoes() {
        return this.instrucoes;
    }

    public int run(int capacidade, int[] valores, int[] pesos) {
        if (valores.length != pesos.length) {
            return -1;
        }
        long ti = System.nanoTime();
        int res = knapsack(capacidade, valores, pesos, valores.length);
        this.tempoExecucao = System.nanoTime() - ti;
        return res;
    }

    private int knapsack(int capacidade, int[] valores, int[] pesos, int n) {
        this.iteracoes++;
        this.instrucoes += 4;
        if (n == 0 || capacidade == 0) {
            this.instrucoes++;
            return 0;
        }

        this.instrucoes += 3;
        if (pesos[n - 1] > capacidade) {
            this.instrucoes += 3;
            return knapsack(capacidade, valores, pesos, n - 1);
        }
        this.instrucoes += 12;
        return Math.max(
            knapsack(capacidade, valores, pesos, n - 1),
            valores[n - 1] + knapsack(capacidade - pesos[n - 1], valores, pesos, n - 1)    
        );
    }
}
