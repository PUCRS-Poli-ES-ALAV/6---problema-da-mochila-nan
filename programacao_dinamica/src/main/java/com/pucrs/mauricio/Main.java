package com.pucrs.mauricio;

import java.util.Arrays;

import com.pucrs.mauricio.fibonacci.FibArray;
import com.pucrs.mauricio.fibonacci.FibMemoizado;
import com.pucrs.mauricio.fibonacci.FibRecursivo;
import com.pucrs.mauricio.mochila.KnapsackMatriz;
import com.pucrs.mauricio.mochila.KnapsackRec;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] fibInputs = {4, 8, 16, 32, 128, 1000, 10000};

        System.out.println("Fibonacci: ");
        for (int nthFibNumber : fibInputs) {
            if (nthFibNumber <= 32) {
                FibRecursivo fibr = new FibRecursivo();
                System.out.printf("Ex. 1, Entrada: %d, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", nthFibNumber, fibr.run(nthFibNumber), fibr.numIteracoes(), fibr.numInstrucoes(), fibr.tempoExecucao() / 1e6);
            }
            
            FibArray fibarr = new FibArray();
            System.out.printf("Ex. 2, ntrada: %d, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", nthFibNumber, fibarr.run(nthFibNumber), fibarr.numIteracoes(), fibarr.numInstrucoes(), fibarr.tempoExecucao() / 1e6);
                    
            FibMemoizado fibmemo = new FibMemoizado();
            System.out.printf("Ex. 3, Entrada: %d, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", nthFibNumber, fibmemo.run(nthFibNumber), fibmemo.numIteracoes(), fibmemo.numInstrucoes(), fibmemo.tempoExecucao() / 1e6);
        }
        
        System.out.println("\nKnapsack");

        KnapsackRec mochilaR = new KnapsackRec();
        int[] val = {50, 50, 64, 46, 50, 05};
        int[] pes = {56, 59, 80, 64, 75, 17};
        int cap = 190;
        System.out.printf("Ex. 4, Entrada: val%s peso%s, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", Arrays.toString(val), Arrays.toString(pes), mochilaR.run(cap, val, pes), mochilaR.numIteracoes(), mochilaR.numInstrucoes(), mochilaR.tempoExecucao() / 1e6);
        
        KnapsackMatriz mochilaM = new KnapsackMatriz();
        System.out.printf("Ex. 5, Entrada: val%s peso%s, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", Arrays.toString(val), Arrays.toString(pes), mochilaM.run(cap, val, pes), mochilaM.numIteracoes(), mochilaM.numInstrucoes(), mochilaM.tempoExecucao() / 1e6);
    }
}