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
        int numDias = 7;
        escala = new String[linhas][numDias];

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

    public void resetSemana() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                escala[i][j] = "";
            }
        }
    }

    public int getSemanas() {
        return semanas;
    }

    public int buscar(char ch, String palavra) {
        int l = 0, count = 0;

        if (!palavra.isEmpty()) {
            for (l = 0; l < palavra.length(); l++) {
                if (ch == palavra.charAt(l)) {
                    count = l;
                    l = palavra.length();
                }
            }
            if (ch != palavra.charAt(count)) {
                count = -1;
            }
        }
        else {
            count = -1;
        }

        return count;
    }

    public boolean temInterseccao(String particao, String sequencia) {
        boolean sucesso = false;

        for (int i = 0; i < sequencia.length(); i++) {
            for (int j = 0; j < particao.length(); j++) {
                if (buscar(particao.charAt(j), sequencia) != -1) {
                    sucesso = true;
                    j = particao.length();
                    i = sequencia.length();
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
        
        if(existeDupla(x, y) || existeDupla(x, z) || existeDupla(y, z))
            sucesso = true;
        
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
        }

        if (dia != -1) {
            for (int i = 0; i < 5; i++) {
                if (!temInterseccao(teste, escala[i][dia])) {
                    sucesso = true;
                } else {
                    sucesso = false;
                    i = 5;
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
                    if (escala[j][i].isEmpty()) {
                        escala[j][i] = teste;
                        j = 5;
                        i = 7;
                    }
                }
            }
        }

        return sucesso;
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

    public void escalarInterativo() {
        int j = 0, LINHA = 5, novaLinha, linhaTer;
        for (int i = 0; i < alunas.length; i += 3) {
            escala[j][0] = alunas[i].charAt(0) + "" + alunas[i + 1].charAt(0) + "" + alunas[i + 2].charAt(0);
            j++;
        }

        for (int dia = 1; dia < dias.length; dia++) {
            novaLinha = 0;
            for (int i = 0; i < LINHA; i++) {
                int segT = (LINHA) + novaLinha + (dia - 1);
                int terT = segT + 1;

                if (segT >= alunas.length) {
                    int estouro = segT - alunas.length;
                    segT = LINHA + estouro;
                    terT = segT + 1;
                }

                if (terT >= alunas.length) {
                    int estouro = terT - alunas.length;
                    terT = LINHA + estouro;
                }

                if (segT > terT) {
                    int aux = terT;
                    terT = segT;
                    segT = aux;
                }

                escala[i][dia] = alunas[i].charAt(0) + "" + alunas[segT].charAt(0) + "" + alunas[terT].charAt(0);
                novaLinha += 2;
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

    public String mostrarTrio(int dia, int linha) {
        return escala[linha][dia];
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

        p.escalarInterativo();
        p.mostrarSemana();

        System.out.println("A posição está em " + p.buscar('C', "ABC"));

        System.out.println("A intersecção da partição é " + p.temInterseccao("AD", "ABC"));

        System.out.println("A aceitabilidade é " + p.eAceitavelN('A', 'B', 'C', -1));

        p.resetSemana();
        p.mostrarSemana();
        System.out.println("A aceitabilidade é " + p.eAceitavelN('A', 'B', 'C', -1));

        p.inserirTrio('A', 'B', 'C');
        p.inserirTrio('A', 'D', 'G');
        p.inserirTrio('B', 'E', 'H');
        p.inserirTrio('G', 'H', 'I');
        p.inserirTrio('A', 'B', 'E');
        p.inserirTrio('M', 'N', 'O');
        p.mostrarSemana();

        System.out.println("Existência de duplas " + p.existeDupla('G', 'H'));
        System.out.println("Existência de duplas do trio "+p.existeDuplaTrio('A', 'H', 'O'));
    }
}
