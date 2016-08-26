/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergesort;

/**
 *
 * @author Aluno
 */
public class MergeSort {
    
    public int parteInteira(float f) {
        
        return (int)(f);
    }
    
    public void intercala(int v[], int inicio, int fim, int meio) {
        int aux;
        
        if(v[inicio] > v[fim]) {
            aux = v[inicio];
            v[inicio] = v[fim];
            v[fim] = aux;
        }
    }
    
    public void intercalacao(int v[], int i, int f) {
        int m, inicio = i, fim = f, meio = parteInteira((float)(i+f)/2);
        
        if (i < f) {
            m = parteInteira((float)(i+f)/2);
            intercalacao(v, i, m);
            intercalacao(v, m+1, f);
            intercala(v, inicio, fim, meio);
        }        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int v[] = new int[10];
        
        System.out.println("Inicializando vetor...");
        for (int i = 0; i < v.length; i++) {
            v[i] = v.length - i - 1;
        }
        
        System.out.println("Lendo vetor:");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]+ " ");
        }
        
        System.out.println("Ordenando arranjo via Mergesort...");
        MergeSort m = new MergeSort();

        m.intercalacao(v, 0, v.length-1);
        System.out.println("Relendo vetor:");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]+ " ");
        }        
        
    }
    
}
