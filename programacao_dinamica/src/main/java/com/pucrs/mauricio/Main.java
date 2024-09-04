package com.pucrs.mauricio;

import com.pucrs.mauricio.fibonacci.FibArray;
import com.pucrs.mauricio.fibonacci.FibMemoizado;
import com.pucrs.mauricio.fibonacci.FibRecursivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int nthFibNumber = 40;
        FibRecursivo fibr = new FibRecursivo();
        System.out.printf("Ex. 1, Entrada: %d, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", nthFibNumber, fibr.run(nthFibNumber), fibr.numIteracoes(), fibr.numInstrucoes(), fibr.tempoExecucao() / 1e6);
        
        FibArray fibarr = new FibArray();
        System.out.printf("Ex. 2, ntrada: %d, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", nthFibNumber, fibarr.run(nthFibNumber), fibarr.numIteracoes(), fibarr.numInstrucoes(), fibarr.tempoExecucao() / 1e6);
                
        FibMemoizado fibmemo = new FibMemoizado();
        System.out.printf("Ex. 3, Entrada: %d, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", nthFibNumber, fibmemo.run(nthFibNumber), fibmemo.numIteracoes(), fibmemo.numInstrucoes(), fibmemo.tempoExecucao() / 1e6);
    }
}