package com.company;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    static int SIZE = Integer.MAX_VALUE / 10000 ;
    static int[] tableau = new int[SIZE];

    public static void main(String[] args) {
        initialiserTableau();
        int[] tableauSelection = new int[SIZE];
        // arraycopy(src, startIndex, dest, startIndex, size)
        System.arraycopy(tableau, 0, tableauSelection, 0, SIZE);
        triSelection(tableauSelection);
        int[] tableauInsertion = new int[SIZE];
        // arraycopy(src, startIndex, dest, startIndex, size)
        System.arraycopy(tableau, 0, tableauInsertion, 0, SIZE);
        triInsertion(tableauInsertion);
        int[] tableauTriABulles = new int[SIZE];
        // arraycopy(src, startIndex, dest, startIndex, size)
        System.arraycopy(tableau, 0, tableauTriABulles, 0, SIZE);
        triTriABulles(tableauTriABulles);
    }

    public static void initialiserTableau() {
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
    }

    public static void triSelection(int[] tableau) {
        Instant start = Instant.now();
        System.out.println("Debut du tri");
        for (int i = 0; i < tableau.length; i++) {
            int indiceMin= i ;
            for (int j = i; j< tableau.length; j++){
                if (tableau[j] < tableau[indiceMin]){
                    indiceMin = j;
                }
            }
            int swap = tableau[i];
            tableau[i] = tableau[indiceMin];
            tableau[indiceMin] = swap;
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toSeconds();
        System.out.println("Le tri selection a pris " + duration + " s");
    }

    public static void triInsertion(int[] tableau) {
        Instant start = Instant.now();
        System.out.println("Debut du tri");
        for (int i = 0; i < tableau.length; i++) {
            int elementATrier = tableau[i];
            int j = i;
            while (j> 0 && tableau[j-1] > elementATrier){
                tableau[j] = tableau[j-1];
                j--;
            }
            tableau[j] = elementATrier;
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toSeconds();
        System.out.println("Le tri insertion a pris " + duration + " s");
    }

    public static void triTriABulles(int[] tableau) {
        Instant start = Instant.now();
        System.out.println("Debut du tri");
        for (int i = 0; i < tableau.length; i++) {
            int elementATrier = tableau[i];
            int j = i;
            while (j> 0 && tableau[j-1] > elementATrier){
                tableau[j] = tableau[j-1];
                j--;
            }
            tableau[j] = elementATrier;
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toSeconds();
        System.out.println("Le tri à bulles a pris " + duration + " s");
    }
}
