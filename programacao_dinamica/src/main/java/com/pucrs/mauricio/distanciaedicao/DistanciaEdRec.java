package com.pucrs.mauricio.distanciaedicao;

public class DistanciaEdRec {
    private int iteracoes = 0;
    private long tempoExecucao = 0;

    public int numIteracoes() {
        return iteracoes;
    }

    public long tempoExecucao() {
        return tempoExecucao;
    }

    public int run(String a, String b) {
        iteracoes = 0;
        long it = System.nanoTime();
        int res = distanciaEd(a, b, a.length() - 1, b.length() - 1);
        tempoExecucao = System.nanoTime() - it;
        return res;
    }

    private int distanciaEd(String a, String b, int i, int j) {
        iteracoes++;
        if (i < 0 && j < 0) {
            return 0;
        }
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (a.charAt(i) == b.charAt(j)) {
            return distanciaEd(a, b, i - 1, j - 1);
        }
        return Math.min(
            distanciaEd(a, b, i - 1, j - 1) + 1, Math.min(
                distanciaEd(a, b, i, j - 1) + 1,
                distanciaEd(a, b, i - 1, j) + 1
            )
        );
    }
}
