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
    public static int escolhaDec(int r, int n) {
        if (r == 0 || n == r)
            return 1;
        else
            return escolhaDec(r-1, n-1) + escolhaDec(r, n-1);
    }
    
    public static int escolhaPD(int r, int n) {

    int i,j;
    int M[i, j]; // indica o número possível de combinações para escolher j itens dentre i itens

    for(i=0; i < n­r; i++) {
        M[i,0]=1;
    for(i=0; i < r; i++)
        M[i,i]=1;
    for(j=1; j<r; j++) {
        for(i=j + 1; i<n­r+j) {
            M[i, j] = T[i­1, j­1] + T[i­1, j];
        }    
    }
    return M[n, r];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int r = 5, n = 9;
        
        System.out.println(EscolheDeC.escolhaDec(r, n));
    }
    
}
