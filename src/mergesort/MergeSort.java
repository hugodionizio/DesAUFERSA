/*
 * Classe: MergeSort.java
 * Função : Ordenar, em ordem crescente, um vetor de inteiros 
 *          atraves de intercalaçao (Divisao e conquista)
 * Data : 28-08-2016 07:52:16 
 */
package mergesort;

/**
 *
 * @author Hugo Dionizio Santos
 */
public class MergeSort {

    public int parteInteira(float f) {

        return (int) (f);
    }

    public void intercala(int v[], int inicio, int fim, int meio) {
        int i, j, k;
        int aux[];

        // Dimensionando o vetor e inicializando as variáveis
        aux = new int[v.length];
        i = inicio;
        j = meio + 1;
        k = inicio;
        
        // Registrando os menores elementos de cada parte no vetor auxiliar
        while (i <= meio && j <= fim) {
            if (v[i] < v[j]) {
                aux[k++] = v[i++];
            } else {
                aux[k++] = v[j++];
            }
        }
        
        // Registrando no vetor os maiores elementos restantes
        while (i <= meio || j <= fim) {
            if (i == meio + 1) {
                aux[k++] = v[j++];
            } else {
                aux[k++] = v[i++];
            }
        }

        // Copiando o vetor auxiliar para o vetor original
        for (i = inicio; i <= fim; i++) {
            v[i] = aux[i];
        }
    }

    public void intercalacao(int v[], int i, int f) {
        int m, inicio = i, fim = f, meio = parteInteira((float) (i + f) / 2);

        if (i < f) {
            m = parteInteira((float) (i + f) / 2);
            intercalacao(v, i, m);
            intercalacao(v, m + 1, f);
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
            System.out.print(v[i] + " ");
        }

        System.out.println("\nOrdenando arranjo via Mergesort...");
        MergeSort m = new MergeSort();
        m.intercalacao(v, 0, v.length - 1);

        System.out.println("Relendo vetor:");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("");
    }
}
