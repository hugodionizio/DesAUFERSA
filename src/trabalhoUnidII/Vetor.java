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
/*Vetor ordenado por inserção e com busca binária*/
class Vetor {

    protected int v[];

    public Vetor() {

    }

    public static int[] insertionSort(int v[]) {

        for (int i = 1; i < v.length; i++) {
            int aux = v[i];
            for (int j = i - 1; j >= 0 && (v[j] > aux); j--) {
                System.out.println("entrou no laço interno");
                v[j + 1] = v[j];
                v[j] = aux;
            }
            resultado(v);
        }

        return v;
    }

    public static void resultado(int v[]) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static int binarySearch(int v[], int valor) {
        int inf = 0; // primeiro elemento do vetor
        int sup = v.length - 1; // ultimo elemento do vetor
        int meio;

        while (inf <= sup) {
            meio = inf + (sup - inf) / 2;
            if (valor == v[meio]) {
                return meio;
            } else if (valor < v[meio]) {
                sup = meio - 1;
            } else {
                inf = meio + 1;
            }
        }
        return -1; // não encontrado
    }

    /**
     * Busca em um vetor ordenado por inserção
     */
    public static int insertionBSearchControl(int v[], int valor) {

        insertionSort(v);
        binarySearch(v, valor);

        return 0;
    }

    /**
     * Busca em um vetor ordenado por inserção
     */
    public static int insertionBSearchDirect(int v[], int valor) {

        for (int i = 1; i < v.length; i++) {
            int aux = v[i];
            for (int j = i - 1; j >= 0 && (v[j] > aux); j--) {
                System.out.println("entrou no laço interno");
                v[j + 1] = v[j];
                v[j] = aux;
            }
            resultado(v);
        }

        int inf = 0; // primeiro elemento do vetor
        int sup = v.length - 1; // ultimo elemento do vetor
        int meio;

        while (inf <= sup) {
            meio = inf + (sup - inf) / 2;
            if (valor == v[meio]) {
                return meio;
            } else if (valor < v[meio]) {
                sup = meio - 1;
            } else {
                inf = meio + 1;
            }
        }
        return -1; // não encontrado
    }

    public static void main(String[] args) {
        int[] v = {2, 5, 3, 8, 6, 4, 7, 1};

        insertionSort(v);
        resultado(v);

        int[] v2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Em ordem crescente...");
        insertionSort(v2);
        resultado(v2);

        int[] v3 = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Em ordem decrescente...");
        insertionSort(v3);
        resultado(v3);

        int n = 3;
        System.out.println("Valor " + n + " na posição " + binarySearch(v, n));
        n = 5;
        System.out.println("Valor " + n + " na posição " + binarySearch(v, n));
        
        System.out.println("Valor " + n + " na posição " + insertionBSearchControl(v, n));
        System.out.println("Valor " + n + " na posição " + insertionBSearchDirect(v, n));
    }
}
