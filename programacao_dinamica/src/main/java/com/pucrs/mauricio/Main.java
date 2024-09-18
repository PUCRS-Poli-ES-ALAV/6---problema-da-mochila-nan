package com.pucrs.mauricio;

import java.util.Arrays;

import com.pucrs.mauricio.distanciaedicao.DistanciaEDDP;
import com.pucrs.mauricio.distanciaedicao.DistanciaEdRec;
import com.pucrs.mauricio.fibonacci.FibArray;
import com.pucrs.mauricio.fibonacci.FibMemoizado;
import com.pucrs.mauricio.fibonacci.FibRecursivo;
import com.pucrs.mauricio.mochila.KnapsackMatriz;
import com.pucrs.mauricio.mochila.KnapsackRec;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] fibInputs = {4, 8, 16, 32, 128, 1000};

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
        
        int[] caps = {165, 190};
        int[][] pesos = {{23, 31, 29, 44, 53, 38, 63, 85, 89, 82},
                         {56, 59, 80, 64, 75, 17}};
        int[][] vals = {{92, 57, 49, 68, 60, 43, 67, 84, 87, 82},
                        {50, 50, 64, 46, 50, 5}};
        
        for (int i = 0; i < caps.length; i++) {
            System.out.printf("Capacidade: %d\n", caps[i]);
            KnapsackRec mochilaR = new KnapsackRec();
            System.out.printf("Ex. 4, Entrada: val%s peso%s, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n", Arrays.toString(vals[i]), Arrays.toString(pesos[i]), mochilaR.run(caps[i], vals[i], pesos[i]), mochilaR.numIteracoes(), mochilaR.numInstrucoes(), mochilaR.tempoExecucao() / 1e6);
            
            KnapsackMatriz mochilaM = new KnapsackMatriz();
            System.out.printf("Ex. 5, Entrada: val%s peso%s, Res: %d, Iteracoes: %d, Instrucoes: %d, Tempo de Execucao: %.4fms\n\n", Arrays.toString(vals[i]), Arrays.toString(pesos[i]), mochilaM.run(caps[i], vals[i], pesos[i]), mochilaM.numIteracoes(), mochilaM.numInstrucoes(), mochilaM.tempoExecucao() / 1e6);
        }
        
        System.out.println("\nDistância de Edição");
        
        String a = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " + //
                        "simplify the build processes in the Jakarta Turbine project. There were several"+ //
                        " projects, each with their own Ant build files, that were all slightly different. " + //
                        "JARs were checked into CVS. We wanted a standard way to build the projects, a clear " + //
                        "definition of what the project consisted of, an easy way to publish project information " + //
                        "and a way to share JARs across several projects. The result is a tool that can now be " + //
                        "used for building and managing any Java-based project. We hope that we have created " + //
                        "something that will make the day-to-day work of Java developers easier and generally help " + //
                        "with the comprehension of any Java-based project.";
        String b = "This post is not about deep learning. But it could be might as well. This is the power of " + //
                        "kernels. They are universally applicable in any machine learning algorithm. Why you might " + //
                        "ask? I am going to try to answer this question in this article. " + //
                        "Go to the profile of Marin Vlastelica Pogančić " + //
                        "Marin Vlastelica Pogančić Jun";
        DistanciaEdRec distR = new DistanciaEdRec();
        // System.out.printf("Ex. 6, Entradas: %s e %s, Res: %d, Iteracoes: %d, Tempo de Execucao: %.4fms\n\n", a, b, distR.run(a, b), distR.numIteracoes(), distR.tempoExecucao() / 1e6);
        
        DistanciaEDDP distDP = new DistanciaEDDP();
        System.out.printf("Ex. 6, Entradas: \"%s\" e \"%s\", Res: %d, Iteracoes: %d, Tempo de Execucao: %.4fms\n\n", a, b, distDP.run(a, b), distDP.numIteracoes(), distDP.tempoExecucao() / 1e6);
    }
}