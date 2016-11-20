/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoUnidIII;

/**
 * @function Método Guloso para Fórmulas Horn
 * @author hugo
 */
class FormulasHorn {
    protected boolean[] afirmacoes;

    public FormulasHorn() {
    }

    public void inserir(int a) {
    }
    
    public int numVariaveis(String formulaHorn) {
        int numVariaveis = 0;
        
        return numVariaveis;
    }
    
    public int numImplicacoes(String formulaHorn) {
        int numImplicacoes = 0;
        
        return numImplicacoes;
    }
    
    public int numClausulaPuramenteNegativas(String formulaHorn) {
        int numClausulaPuramenteNegativas = 0;
        
        return numClausulaPuramenteNegativas;
    }
    
    public boolean verificarFormula (String formulaHorn) {
        boolean sucesso = false;
        
        int numVar = numVariaveis(formulaHorn);
        int numImplic = numImplicacoes(formulaHorn);
        int numClausulasPN = numClausulaPuramenteNegativas(formulaHorn);
        boolean variaveis[] = new boolean[numVar];
        boolean implicacoes[] = new boolean[numImplic];
        boolean clausulaPN[] = new boolean[numClausulasPN];
        
        // Todas variáveis são consideradas falsas
        for (int i = 0; i < numVar; i++) {
            variaveis[i] = false;
        }
        
        for (int i = 0; i < numImplic; i++) {
            implicacoes[i] = false;
        }
        
        for (int i = 0; i < numClausulasPN; i++) {
            clausulaPN[i] = false;
        }
        
        int j = 0;
        // Enquanto existir implicações não satisfeitas
        while(!implicacoes[j]) {
            // Fazer a variável à direita da implicacação verdadeira
            implicacoes[j+1] = true;
            j++;
        }
	
        // Se todas as cláusulas puramente negativas satisfeitas
        for (int i = 0; i < numClausulasPN; i++) {
            if (clausulaPN[i])
        	// Retornar atribuição
                sucesso = true;
            else { // senão
        	//retornar "Esta fórmula Horn não satisfeita"
                sucesso = false;
                i = numClausulasPN;
            }
        }        
        
        return sucesso;
    }
    
    public static void main(String[] args) {
        String formula = "(x^y^z)=>, (x^z)=>w, x=>y, =>x, (x^y)=>w, (~wV~xV~y), (~z)";
        
        FormulasHorn f = new FormulasHorn();
        
        if(f.verificarFormula(formula)) {
            System.out.println(formula);   
        }
        else {
            System.out.println("Esta fórmula Horn não satisfeita");
        }
    }
    
}