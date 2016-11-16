package exemplos.progdinamica;

/**
 *
 * @author Hugo Dionizio Santos
 */
public class TrianguloPascal {

    public void imprimePascal(int n) {
        int i, j;

        System.out.println("Triângulo Pascal Recursivo:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(pascal(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("\nTriângulo Pascal Dinâmico:");
        int p[][] = pascalDinamico(n);
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }       
    }

    public int pascal(int linha, int coluna) {

        if ((linha == 1 - 1) || (coluna == 1 - 1)) {         
            return 1;            
        } else {
            return pascal(linha, coluna - 1) + pascal(linha - 1, coluna);
        }
    }

    public int [][]pascalDinamico(int n) {

        int[][] p = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 1 - 1) || (j == 1 - 1)) {
                    p[i][j] = 1;
                } else {
                    p[i][j] = p[i][j - 1] + p[i - 1][j];
                }
            }
        }
        
        return p;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 5;
        TrianguloPascal tp = new TrianguloPascal();

        tp.imprimePascal(n);
    }
}
