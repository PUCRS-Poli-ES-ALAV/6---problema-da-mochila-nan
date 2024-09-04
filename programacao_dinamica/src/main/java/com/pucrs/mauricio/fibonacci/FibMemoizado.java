package com.pucrs.mauricio.fibonacci;

public class FibMemoizado {
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
        instrucoes = 0;
        iteracoes = 0;
        int[] numbers = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            numbers[i] = -1;
        }
        long ti = System.nanoTime();
        int res = memoFibo(numbers, n);
        this.tempoDeExecucao = System.nanoTime() - ti;
        return res;
    }

    private int memoFibo(int[] numbers, int n) {
        iteracoes++;
        instrucoes += 2;
        if (numbers[n] >= 0) {
            return numbers[n];
        }
        instrucoes+= 9;
        if (n <= 1) {
            numbers[n] = n;
        } else {
            numbers[n] = memoFibo(numbers, n - 1) + memoFibo(numbers, n - 2);
        }
        return numbers[n];
    }
}
