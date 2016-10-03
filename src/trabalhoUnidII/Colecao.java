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
/*Coleção de porcas e parafusos*/
class Colecao {
	protected int rosca[];
	protected int parafuso[];

	public Colecao() {
		
	}

	public void ordenarRoscasParafusos (int roscas[], int parafusos[]) {
            int x[] = new int[roscas.length*parafusos.length];
            for (int i = 0; i < roscas.length; i++) {
                for (int j = 0; j < parafusos.length; j++) {
                    if(roscas[i] == parafusos[j])
                        x[i*j] = 1;
                }
            }
		
	}
        
        public static void main(String[] args) {
            
        }

}
