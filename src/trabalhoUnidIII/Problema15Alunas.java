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
    protected String escala;

    public Problema15Alunas() {
    }

    /**
     * Busca em um vetor ordenado por inserção
     */
    public static void inserirAluna(String a) {
    }

    public void organizarEscala() {
    }

    public static void main(String[] args) {
        String alunas[] = {"Ana", "Beatriz", "Carla", "Diana", "Eva", "Francisca",
            "Geane", "Helga", "Iana", "Jeane", "Katia", "Luiza", "Maria", "Najla",
            "Olívia"};
        String dias[] = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom"};
        int comb = 0;
        int semanas = 0;

        System.out.println("Problema das 15 Alunas");
        for (int i = 0; i < alunas.length; i += 3) {
            System.out.println(alunas[i] + ", " + alunas[i + 1] + ", " + alunas[i + 2]);
        }

        for (int i = 0; i < alunas.length; i += 3) {
            System.out.println(alunas[i].charAt(0) + "" + alunas[i + 1].charAt(0)
                    + "" + alunas[i + 2].charAt(0));
        }

        for (int i = 0; i < alunas.length - 2; i++) {
            for (int j = 1; j < alunas.length - 1; j++) {
                for (int k = 2; k < alunas.length; k++) {
                    if (i != j && i != k && j != k) {
                        if ((comb) % 5 == 0 && (comb) % 7 == 0) {
                            for (int d = 0; d < dias.length; d++) {
                                System.out.print(dias[d] + "|");
                            }
                            System.out.println("");
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

        System.out.println("Número de combinações: " + comb
                + "\nNúmero de semanas: " + semanas);
    }
}
