/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplos.progdinamica;

/**
 *
 * @author Aluno
 */
public class EscolhaCombinacao {
    /*
     * Divisao e conquista
    */
    public static int escolhaDeC(int r, int n) {
        if (r == 0 || n == r)
            return 1;
        else
            return escolhaDeC(r-1, n-1) + escolhaDeC(r, n-1);
    }
    
    public static int escolhaPD(int r, int n) {
        int i = n+1, j = r+1;
        int [][]M = new int[i][j];
        int [][]T = new int[n+1][r+1];
        
        for (i = 0; i < n-r; i++) {
            M[i][0] = 1;
        }
        for (i = 0; i < r; i++) {
            M[i][i] = 1;
        }
        for (j = 1; j < r; j++) {
            for (i = j+1; i < n-r+j; i++) {
                M[i][j] = M[i-1][j-1] + M[i-1][j];
            }
        }
            
        
        return M[n][r];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int r = 5, n = 9, out;
        
        out = EscolhaCombinacao.escolhaDeC(r, n);
        System.out.println(out);
        out = EscolhaCombinacao.escolhaPD(r, n);
        System.out.println(out);
    }
    
}
