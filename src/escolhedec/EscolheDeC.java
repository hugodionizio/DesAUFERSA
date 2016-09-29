/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escolhedec;

/**
 *
 * @author Aluno
 */
public class EscolheDeC {
    public static int escolhaDeC(int r, int n) {
        if (r == 0 || n == r)
            return 1;
        else
            return escolhaDeC(r-1, n-1) + escolhaDeC(r, n-1);
    }
    
    public static int escolharPD(int r, int n) {
        int i, j;
        int [][]M = new int[n][r];
        int [][]T = new int[n+1][r+1];
        
        for (i = 0; i < n-r; i++) {
            M[i][0] = 1;
        }
        for (i = 0; i < r; i++) {
            M[i][i] = 1;
        }
        for (j = 0; j < 10; j++) {
            for (i = 0; i < 10; i++) {
                M[i][j] = T[i-1][j-1] + T[i-1][j];
            }
        }
            
        
        return M[r][n];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int r = 5, n = 9;
        
        System.out.println(EscolheDeC.escolhaDeC(r, n));
    }
    
}
