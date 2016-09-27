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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int r = 5, n = 9;
        
        System.out.println(EscolheDeC.escolhaDec(r, n));
    }
    
}
