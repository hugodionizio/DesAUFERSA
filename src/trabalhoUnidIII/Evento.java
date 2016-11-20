package trabalhoUnidIII;

import java.util.Date;

/**
 * @function Programação Dinâmica de eventos via Problema dos Intervalos
 * Compatíveis de Valor Máximo
 *
 * @author Walter Lucas
 */
class Evento {

    public static int resolve(int inicioA[], int fimB[], int valores[]) {
        int n = valores.length;
        int[] res = new int[n + 1];
        res[0] = 0;
        int k;
        for (int i = 1;
                i <= n;
                i++) {
            k = i - 1;
            while (k >= 1 && fimB[k - 1] > inicioA[i - 1]) {
                k = k - 1;
            }
            if (res[i - 1] > res[k] + valores[i - 1]) {
                res[i] = res[i - 1];
            } else {
                res[i] = res[k] + valores[i - 1];
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        int[] inicioA = {1, 3, 6, 7};
        int[] fimB = {5, 8, 9, 8};
        int[] valores = {30, 50, 60, 120};
        System.out.printf("Periodo maximo de eventos: %d dias\n", resolve(inicioA, fimB, valores));
    }
}
