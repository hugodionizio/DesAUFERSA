/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoUnidIII;

/**
 * @function Backtracking do problema das 15 alunas
 * @author hugo
 */
class Problema15Alunas {

    protected String[] alunas;
    protected String[][] escala;
    private int comb;
    private String dias[] = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom"};
    private int semanas;

    public Problema15Alunas() {
        String aux[] = {"Ana", "Beatriz", "Carla", "Diana", "Eva", "Francisca",
            "Geane", "Helga", "Iana", "Jeane", "Katia", "Luiza", "Maria", "Najla",
            "Olívia"};

        int linhas = 5;
        int numSemanas = 7;
        escala = new String[linhas][numSemanas];

        int num = 15;
        alunas = new String[num];
        for (int i = 0; i < num; i++) {
            alunas[i] = aux[i];
        }

    }

    /**
     * Busca em um vetor ordenado por inserção
     */
    public void inserirAluna(String a) {
        int i = 0;
        while (!alunas[i].isEmpty()) {
            i++;
        }
        alunas[i] = a;
    }

    public void resetCombinacoes() {
        comb = 0;
    }

    public int getCombinacoes() {
        return comb;
    }

    public void resetSemanas() {
        semanas = 0;
    }

    public int getSemanas() {
        return semanas;
    }

    public boolean eAceitavel(int x, int y, int z) {
        // é aceitável se o arranjo do trio estiver ordenado de forma crescente
        boolean result = (x < y && y < z);
        if (result) {
            for (int i = 0; i < comb / 7; i++) {
                for (int j = 0; j < 3; j++) {
                    char al = alunas[x].charAt(0);
                    char es = escala[i][comb % 7].charAt(j);
                    result = (al != es);
                    if (result) {
                        al = alunas[y].charAt(0);
                        if (al != es) {
                            al = alunas[z].charAt(0);
                            result = (al != es);
                        } else {
                            result = false;
                            j = 3;
                        }
                    } else {
                        result = false;
                        j = 3;
                    }
                }

            }
        }

        return result;
    }

    public void escalarT(int i, int j, int k) {
        if (k < alunas.length) {
            if (eAceitavel(i, j, k)) {
                if (comb > 34) {
                    comb = 0;
                    mostrarSemana();
                    semanas++;
                }
                int x = (int) comb / 7;
                int y = comb % 7;
                escala[x][y] = alunas[i].charAt(0) + "" + alunas[j].charAt(0)
                        + "" + alunas[k].charAt(0);
                comb++;
            }
            k++;
            escalarT(i, j, k);
        }
    }

    public void escalarS(int i, int j, int k) {
        if (j < alunas.length) {
            escalarT(i, j, k);
            j++;
            k = 0;
            escalarS(i, j, k);
        }
    }

    public void escalarP(int i, int j, int k) {
        if (i < alunas.length) {
            escalarS(i, j, k);
            i++;
            j = 0;
            k = 0;
            escalarP(i, j, k);
        }
    }

    public void escalar() {
        int j = 0, linha = 5, novalinha;
        for (int i = 0; i < alunas.length; i += 3) {
            escala[j][0] = alunas[i].charAt(0) + "" + alunas[i + 1].charAt(0) + "" + alunas[i + 2].charAt(0);
            j++;
        }

        for (int dia = 1; dia < dias.length; dia++) {
            novalinha = 0;
            for (int i = 0; i < linha; i++) {
                int segT = dia+linha-1+novalinha;
                int terT = dia +linha+novalinha;
                
                if (segT >= alunas.length)
                    segT = linha;
                
                if (terT >= alunas.length)
                    terT = linha;
                
                if (segT>terT){
                    int aux = terT;
                    terT = segT;
                    segT = aux;
                }

                escala[i][dia] = alunas[i].charAt(0) + "" + alunas[segT].charAt(0) + "" + alunas[terT].charAt(0);
                novalinha++;
            }
        }
    }

    public void imprimirDiasSemana() {
        for (int d = 0; d < dias.length; d++) {
            System.out.print(dias[d] + "|");
        }
        System.out.println("");
    }

    public void organizarEscala() {
        for (int i = 0; i < alunas.length - 2; i++) {
            for (int j = 1; j < alunas.length - 1; j++) {
                for (int k = 2; k < alunas.length; k++) {
                    if (i != j && i != k && j != k) {
                        if ((comb) % 5 == 0 && (comb) % 7 == 0) {

                            System.out.println("");
                            imprimirDiasSemana();
                            semanas++;
                        }

                        System.out.print(alunas[i].charAt(0) + "" + alunas[j].charAt(0)
                                + "" + alunas[k].charAt(0));
                        if ((comb + 1) % 7 != 0) {
                            System.out.print("|");
                        } else {
                            System.out.println("");
                        }
                        comb++;
                    }
                }
            }
        }
    }

    public void mostrarSemana() {
        imprimirDiasSemana();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(escala[i][j] + "|");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void particionar() {
        for (int i = 0; i < alunas.length; i += 3) {
            System.out.println(alunas[i] + ", " + alunas[i + 1] + ", " + alunas[i + 2]);
        }
    }

    public void particionarIniciais() {
        for (int i = 0; i < alunas.length; i += 3) {
            System.out.println(alunas[i].charAt(0) + "" + alunas[i + 1].charAt(0)
                    + "" + alunas[i + 2].charAt(0));
        }
    }

    public static void main(String[] args) {
        System.out.println("Problema das 15 Alunas");
        Problema15Alunas p = new Problema15Alunas();
        //p.organizarEscala();

        System.out.println("\nNúmero de combinações: " + p.getCombinacoes()
                + "\nNúmero de semanas: " + p.getSemanas());

        p.resetCombinacoes();
        p.resetSemanas();

        int i = 0, j = 0, k = 0;
        p.escalarP(i, j, k);

        p.escalar();
        p.mostrarSemana();
    }
}
