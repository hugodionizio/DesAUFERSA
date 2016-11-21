/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoUnidIII;

/**
 *
 * @author hugo
 */
public class KirkmanAux {
    String[][] tabela;
    int numAlunas;
    
    public void initTabela(int numAlunas) {
        this.numAlunas = numAlunas;
        tabela = new String[numAlunas][numAlunas];
    }

    public void particionarIniciais(String alunas[]) {
        for (int i = 0; i < numAlunas; i += 3) {
            System.out.println(alunas[i].charAt(0) + "" + alunas[i + 1].charAt(0) + "" + alunas[i + 2].charAt(0));
        }
    }

    /**
     * Busca em um vetor ordenado por inserção
     */
    public void inserirAluna(String a, String alunas[]) {
        int i = 0;
        while (!alunas[i].isEmpty()) {
            i++;
        }
        alunas[i] = a;
    }


    public void quasiGrupo() {
        for (int i = 0; i < numAlunas - 1; i++) {
            for (int j = 0; j < numAlunas - 1; j++) {
                tabela[i][j] = "" + 1 + (i + j) % numAlunas;
            }
        }
    }

    public String mostrarTrio(int dia, int linha, String escala[][]) {
        return escala[linha][dia];
    }

    public static boolean inserirTrio(String trio) {
        boolean sucesso = false;
        (new problema15Alunas).inserirTrio(trio.charAt(0), trio.charAt(1), trio.charAt(2));
        return sucesso;
    }


    public void preencherTabela() {
        for (int i = 0; i < numAlunas; i++) {
            for (int j = 0; j < numAlunas; j++) {
                tabela[i][j] = "" + (i + j) % numAlunas;
            }
        }
    }

    public void particionar() {
        for (int i = 0; i < numAlunas; i += 3) {
            System.out.println((new problema15Alunas).alunas[i] + ", " + (new problema15Alunas).alunas[i + 1] + ", " + (new problema15Alunas).alunas[i + 2]);
        }
    }

    public void escalarIterativo() {
        int j = 0;
        int LINHA = 5;
        int novaLinha;
        int linhaTer;
        for (int i = 0; i < (new problema15Alunas).alunas.length; i += 3) {
            (new problema15Alunas).escala[j][0] = (new problema15Alunas).alunas[i].charAt(0) + "" + (new problema15Alunas).alunas[i + 1].charAt(0) + "" + (new problema15Alunas).alunas[i + 2].charAt(0);
            j++;
        }
        for (int dia = 1; dia < (new problema15Alunas).getDias().length; dia++) {
            novaLinha = 0;
            for (int i = 0; i < LINHA; i++) {
                int segT = (LINHA) + novaLinha + (dia - 1);
                int terT = segT + 1;
                if (segT >= (new problema15Alunas).alunas.length) {
                    int estouro = segT - (new problema15Alunas).alunas.length;
                    segT = LINHA + estouro;
                    terT = segT + 1;
                }
                if (terT >= (new problema15Alunas).alunas.length) {
                    int estouro = terT - (new problema15Alunas).alunas.length;
                    terT = LINHA + estouro;
                }
                if (segT > terT) {
                    int aux = terT;
                    terT = segT;
                    segT = aux;
                }
                (new problema15Alunas).escala[i][dia] = (new problema15Alunas).alunas[i].charAt(0) + "" + (new problema15Alunas).alunas[segT].charAt(0) + "" + (new problema15Alunas).alunas[terT].charAt(0);
                novaLinha += 2;
            }
        }
    }

    public boolean eAceitavel(int x, int y, int z) {
        boolean result = x < y && y < z;
        if (result) {
            for (int i = 0; i < (new problema15Alunas).getComb() / 7; i++) {
                for (int j = 0; j < 3; j++) {
                    char al = (new problema15Alunas).alunas[x].charAt(0);
                    char es = (new problema15Alunas).escala[i][(new problema15Alunas).getComb() % 7].charAt(j);
                    result = (al != es);
                    if (result) {
                        al = (new problema15Alunas).alunas[y].charAt(0);
                        if (al != es) {
                            al = (new problema15Alunas).alunas[z].charAt(0);
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

    public void mostrarTabela() {
        for (int i = 0; i < numAlunas; i++) {
            for (int j = 0; j < numAlunas; j++) {
                System.out.print(tabela[i][j] + "|");
            }
            System.out.println("");
        }
    }


    public void organizarEscala() {
        for (int i = 0; i < (new problema15Alunas).alunas.length - 2; i++) {
            for (int j = 1; j < (new problema15Alunas).alunas.length - 1; j++) {
                for (int k = 2; k < (new problema15Alunas).alunas.length; k++) {
                    if (i != j && i != k && j != k) {
                        if (((new problema15Alunas).getComb()) % 5 == 0 && ((new problema15Alunas).getComb()) % 7 == 0) {
                            System.out.println("");
                            (new problema15Alunas).imprimirDiasSemana();
                            (new problema15Alunas).incrementSemanas();
                        }
                        System.out.print((new problema15Alunas).alunas[i].charAt(0) + "" + (new problema15Alunas).alunas[j].charAt(0) + "" + (new problema15Alunas).alunas[k].charAt(0));
                        if (((new problema15Alunas).getComb() + 1) % 7 != 0) {
                            System.out.print("|");
                        } else {
                            System.out.println("");
                        }
                        (new problema15Alunas).incrementComb();
                    }
                }
            }
        }
    }
    
    public void testeExemplo() {
        inserirTrio("ABC");
        inserirTrio("ADG");
        inserirTrio("AEJ");
        inserirTrio("AFO");
        inserirTrio("AHK");
        inserirTrio("AIM");
        inserirTrio("ALN");
        inserirTrio("DEF");
        inserirTrio("BEH");
        inserirTrio("BFL");
        inserirTrio("BDM");
        inserirTrio("BGN");
        inserirTrio("BKO");
        inserirTrio("BIJ");
        inserirTrio("GHI");
        inserirTrio("CJM");
        inserirTrio("CHO");
        inserirTrio("CGL");
        inserirTrio("CFI");
        inserirTrio("CEN");
        inserirTrio("CDK");
        inserirTrio("JKL");
        inserirTrio("FKN");
        inserirTrio("DIN");
        inserirTrio("EIK");
        inserirTrio("DJO");
        inserirTrio("DHL");
        inserirTrio("EGO");
        inserirTrio("MNO");
    }    
}
