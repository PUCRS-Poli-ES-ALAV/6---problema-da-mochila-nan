package com.pucrs.mauricio.fibonacci;

public class FibArray {
    private int instrucoes = 0;
    private int iteracoes = 0;
    private long tempoDeExecucao = 0;

    public long tempoExecucao() {
        return this.tempoDeExecucao;
    }

    public int numInstrucoes() {
        return this.instrucoes;
    }

    public int numIteracoes() {
        return this.iteracoes;
    }

    public int run(int n) {
        long ti = System.nanoTime();
        instrucoes = 2;
        iteracoes = 0;
        if (n <= 1) {
            return n;
        }
        instrucoes += 3;
        int[] numbers = new int[n];
        numbers[0] = 1;
        numbers[1] = 1;
        for (int i = 2; i < n; i++) {
            instrucoes += 7;
            iteracoes++;
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        instrucoes += 2;
        this.tempoDeExecucao = System.nanoTime() - ti;
        return numbers[n - 1];
    }
}
