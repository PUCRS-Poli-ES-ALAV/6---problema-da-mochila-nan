package com.pucrs.mauricio.fibonacci;

public class FibRecursivo {
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
        iteracoes = 0;
        instrucoes = 0;
        long ti = System.nanoTime();
        int res = fib(n);
        this.tempoDeExecucao = System.nanoTime() - ti;
        return res;
    }

    private int fib(int n) {
        iteracoes++;
        instrucoes += 2;
        if (n <= 1) {
            return n;
        }
        instrucoes += 8;
        int a = fib(n - 1);
        int b = fib(n - 2);
        return a + b;
    }
}