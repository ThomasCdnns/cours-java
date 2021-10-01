package com.company;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        // Retrieve inputs
        //Scanner scanner = new Scanner(System.in);
        //int unEntier = scanner.nextInt();
//        float unReel = scanner.nextFloat();
//        System.out.println("J’ai recupere un entier: " + unEntier);
//        System.out.println("J’ai aussi recupere un reel: " + unReel);

        // Print Bonjour
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Bonjour, quel est votre prénom ?");
//        String name = scanner.nextLine();
//        System.out.println("Bonjour,  " + name);
        //somme();
        division();
    }

    public static void somme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();
        int somme = premierEntier + deuxiemeEntier;
        System.out.println("La somme de " + premierEntier + " avec " + deuxiemeEntier +
                " est égale a " + somme);


    }

    public static void division() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le premier entier");
        int premierEntier = scanner.nextInt();
        System.out.println("Veuillez saisir le deuxieme entier");
        int deuxiemeEntier = scanner.nextInt();
        float result = premierEntier / deuxiemeEntier;
        System.out.println("La division de " + premierEntier + " avec " + deuxiemeEntier +
                " est égale a " + result);
    }
}
