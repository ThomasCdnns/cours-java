package com.company;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        initialiserTableau();
        int[] tableauSelection = new int[SIZE];
        // arraycopy(src, startIndex, dest, startIndex, size)
        System.arraycopy(tableau, 0, tableauSelection, 0, SIZE);
    }

    static int SIZE = Integer.MAX_VALUE / 1000 ;
    static int[] tableau = new int[SIZE];
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
}
