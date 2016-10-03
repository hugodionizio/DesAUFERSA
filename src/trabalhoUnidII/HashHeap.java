/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoUnidII;

/**
 *
 * @author hugo
 */
class HashHeap {

    protected int listaHeap[];

    public HashHeap() {

    }

    public int encontrarK(int a) {
        return 0;

    }
    
    public static int array_hash_horner(int v[], int m) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int i, h = v[0];

        for (i = 1; i < v.length; i++) // método de Horner
        {
            h = (h * 10 + v[i]) % m;  /* Ex.: "AB" = (65 * 256 + 66) % m */

        }

        return h;

    }

    public static int string_hash_horner(String v, int m) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int i, h = v.charAt(0);

        for (i = 1; i < v.length(); i++) // método de Horner
        {
            h = (h * 256 + v.charAt(i)) % m;  /* Ex.: "AB" = (65 * 256 + 66) % m */
        }

        return h;

    }

    //Implementação da Heap Máxima
    public static void ordenacaoHeap(int[] v) {
        constroiHeap(v);
        int n = v.length;

        for (int i = v.length - 1; i > 0; i--) {
            troca(v, i, 0);
            heapficando(v, 0, --n);
        }
    }

    private static void constroiHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            heapficando(v, i, v.length);
        }
        System.out.print("Heap inicial: ");
        resultado(v);
    }

    private static void heapficando(int[] vetor, int pos, int tamanhoVetor) {

        int max = 2 * pos + 1, direita = max + 1;
        if (max < tamanhoVetor) {
            if (direita < tamanhoVetor && vetor[max] < vetor[direita]) {
                max = direita;
            }

            if (vetor[max] > vetor[pos]) {
                troca(vetor, max, pos);
                heapficando(vetor, max, tamanhoVetor);
            }
        }
    }

    public static void troca(int[] v, int j, int aposJ) {
        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }

    private static void resultado(int v[]) {
        int aux;
        for (int i = 0; i < v.length; i++) {

            System.out.print(v[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] v = {2, 5, 3, 8, 6, 4, 7, 1};

        ordenacaoHeap(v);
        resultado(v);

        int[] v2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("\nEm ordem crescente...");
        ordenacaoHeap(v2);
        resultado(v2);

        int[] v3 = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("\nEm ordem decrescente...");
        ordenacaoHeap(v3);
        resultado(v3);

        String chave1 = "ufersa";
        String chave2 = "computação";
        String chave3 = "dcen";

        int c = string_hash_horner(chave1, 50);
        int c2 = string_hash_horner(chave2, 50);
        int c3 = string_hash_horner(chave3, 50);
        
        System.out.println(chave1 + ": " + c);
        System.out.println(chave2 + ": " + c2);
        System.out.println(chave3 + ": " + c3);
        
        int hash[] = new int[v.length];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = array_hash_horner(v, 5);
            System.out.print(v[i]+" ");
        }
    }
}