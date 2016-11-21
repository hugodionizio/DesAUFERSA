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
    private static int comb;
    private String dias[] = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom"};
    private int semanas;

    public Problema15Alunas() {
        String aux[] = {"Ana", "Beatriz", "Carla", "Diana", "Eva", "Francisca",
            "Geane", "Helga", "Iana", "Jeane", "Katia", "Luiza", "Maria", "Najla",
            "Olívia"};

        int linhas = 5;
        int numDias = 7;
        escala = new String[linhas][numDias];

        int num = 15;
        alunas = new String[num];
        for (int i = 0; i < num; i++) {
            alunas[i] = aux[i];
        }

    }

    private int getSemanas() {
        return semanas;
    }

    public void resetSemana() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                escala[i][j] = "";
            }
        }
    }

    public int getComb() {
        return comb;
    }

    private void resetCombinacoes() {
        comb = 0;
    }

    public int buscar(char ch, String palavra) {
        int l = 0, count = 0;

        if (palavra != null && !palavra.isEmpty()) {
            for (l = 0; l < palavra.length(); l++) {
                if (ch == palavra.charAt(l)) {
                    count = l;
                    l = palavra.length();
                }
            }
            if (ch != palavra.charAt(count)) {
                count = -1;
            }
        } else {
            count = -1;
        }

        return count;
    }

    public boolean temInterseccao(String particao, String sequencia) {
        boolean sucesso = false;

        if (sequencia != null && !sequencia.isEmpty()) {
            for (int i = 0; i < sequencia.length(); i++) {
                for (int j = 0; j < particao.length(); j++) {
                    if (buscar(particao.charAt(j), sequencia) != -1) {
                        sucesso = true;
                        j = particao.length();
                        i = sequencia.length();
                    }
                }
            }
        }

        return sucesso;
    }

    public boolean existeDupla(int x, int y) {
        boolean sucesso = false;
        int dupla = 0;

        for (int i = 0; i < 7; i++) {
            if (!sucesso) {
                dupla = 0;
                for (int j = 0; j < 5; j++) {
                    if (buscar((char) x, escala[j][i]) != -1) {
                        dupla++;
                        if (buscar((char) y, escala[j][i]) != -1) {
                            dupla++;
                        }
                        if (dupla > 1) {
                            sucesso = true;
                        }
                        j = 5;
                    }
                }
            }
        }

        return sucesso;
    }

    public boolean existeDuplaTrio(int x, int y, int z) {
        boolean sucesso = false;

        if (existeDupla(x, y) || existeDupla(x, z) || existeDupla(y, z)) {
            sucesso = true;
        }

        return sucesso;
    }

    public boolean eAceitavelN(int x, int y, int z, int dia) {
        boolean sucesso = false;
        int j = 0;
        String teste = "" + (char) x + (char) y + (char) z;

        if (x < y && y < z) {
            for (j = 0; j < 7; j++) {
                if (!sucesso) {
                    for (int i = 0; i < 5; i++) {
                        if (!temInterseccao(teste, escala[i][j])) {
                            sucesso = true;
                        } else {
                            sucesso = false;
                            i = 5;
                        }
                    }
                } else {
                    j = 7;
                }
            }

            if (dia != -1) {
                for (int i = 0; i < 5; i++) {
                    if (!temInterseccao(teste, escala[i][dia])) {
                        if (!existeDuplaTrio(x, y, z)) {
                            sucesso = true;
                        } else {
                            sucesso = false;
                        }
                    } else {
                        sucesso = false;
                        i = 5;
                    }
                }
            }
        }

        return sucesso;
    }

    public boolean inserirTrio(int x, int y, int z) {
        boolean sucesso = false;
        String teste = "" + (char) x + (char) y + (char) z;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (eAceitavelN(x, y, z, i)) {
                    if (escala[j][i] == null || escala[j][i].isEmpty()) {
                        escala[j][i] = teste;
                        j = 5;
                        i = 7;
                        sucesso = true;
                    }
                }
            }
        }

        return sucesso;
    }

    public void escalarT(int i, int j, int k) {
        if (k < alunas.length) {
            if (inserirTrio(alunas[i].charAt(0), alunas[j].charAt(0), alunas[k].charAt(0))) {
                comb++;
                if (comb > 34) {
                    comb = 0;
                    mostrarSemana();
                    semanas++;
                }
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

    public void escalarP(int u, int v, int w) {
        int j = 0;
        for (int i = 0; i < alunas.length; i += 3) {
            escala[j][0] = alunas[i].charAt(0) + "" + alunas[i + 1].charAt(0) + "" + alunas[i + 2].charAt(0);
            j++;
        }

        if (u < alunas.length) {
            escalarS(u, v, w);
            u++;
            v = 0;
            w = 0;
            escalarP(u, v, w);
        }
    }

    public void imprimirDiasSemana() {
        for (int d = 0; d < dias.length; d++) {
            System.out.print(dias[d] + "|");
        }
        System.out.println("");
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

    public static void main(String[] args) {
        System.out.println("Problema das 15 Alunas");
        Problema15Alunas p = new Problema15Alunas();

        int i = 0, j = 0, k = 0;
        p.resetCombinacoes();
        p.resetSemana();
        p.escalarP(i, j, k);
        p.mostrarSemana();

        System.out.println("\nNúmero de combinações: " + p.getComb()
                + "\nNúmero de semanas: " + p.getSemanas());
    }
}
