package com.pucrs.mauricio.distanciaedicao;

import java.util.stream.IntStream;

public class DistanciaEDDP {
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
        int res = distanciaEd(a, b);
        tempoExecucao = System.nanoTime() - it;
        return res;
    }

    private int distanciaEd(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] mat = new int[m + 1][n + 1];
        mat[0][0] = 0;

        int[] iRange = IntStream.range(1, m + 1).toArray();
        int[] jRange = IntStream.range(1, n + 1).toArray();
        for (int i : iRange) {
            iteracoes++;
            mat[i][0] = mat[i - 1][0] + 1;
        }
        for (int j : jRange) {  IntStream.range(1, n + 1).toArray();
            iteracoes++;
            mat[0][j] = mat[0][j - 1] + 1;
        }
        for (int i : iRange) {
            for (int j : jRange) {
                iteracoes++;
                int custoExtra = 1;
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    custoExtra = 0;
                }
                mat[i][j] = Math.min(
                    mat[i - 1][j] + 1, Math.min(
                        mat[i][j - 1] + 1, mat[i - 1][j - 1] + custoExtra
                    )
                );
            }
        }
        return mat[m][n];
    }
}
