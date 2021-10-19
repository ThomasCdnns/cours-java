package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Retrieve inputs
        //Scanner scanner = new Scanner(System.in);
        //int unEntier = scanner.nextInt();
//        float unReel = scanner.nextFloat();
//        System.out.println("J’ai recupere un entier: " + unEntier);
//        System.out.println("J’ai aussi recupere un reel: " + unReel);

        // Print Bonjour
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour, quel est votre prénom ?");
        String name = scanner.nextLine();
        System.out.println("Bonjour,  " + name);
        //somme();
        volume();
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

    public static void volume() {
        // Nous avons besoin de trois variables : L*l*h
        // Problèmes de ce programme : les unités ne sont pas prises en compte, nombres entiers uniquement
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir la largeur : ");
        int l = scanner.nextInt();
        System.out.println("Veuillez saisir la longueur : ");
        int L = scanner.nextInt();
        System.out.println("Veuillez saisie la hauteur : ");
        int h = scanner.nextInt();
        float result = l*L*h;
        System.out.println("Voici le volume de ce pavé : " + result);
    }
}
