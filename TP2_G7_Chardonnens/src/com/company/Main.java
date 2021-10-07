package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        parite();
    }

    public static void discriminant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();
        System.out.println("Quelle est la valeur de c ?");
        int c = scanner.nextInt();
        double delta = (Math.pow(b, 2) - 4 * a * c);
        if (delta < 0) {
            System.out.println("Ce polynome n’a pas de racine reelle, calcul de la solution complexe : ");
            double real_part = -b / (2*a);
            double complex_part = Math.sqrt(-delta)/(2*a);
            System.out.println("La solution est : " + real_part + "+" + complex_part + "i");
        }

        else if (delta == 0) {
            float result = -b / (2 * a);
            System.out.println("La racine pour Delta nul est : " + result);
        }

        else if (delta > 0) {
            double result_1 = (-b + Math.sqrt(delta)) / (2 * a);
            double result_2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Les racines pour Delta égal à " + delta + " sont : " + result_1 + " et " + result_2);
        }

    }

    public static void parite(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de votre nombre entier ?");
        int entier = scanner.nextInt();
        double evenTest = entier % 2;
        if (evenTest == 0){
            System.out.println(entier + " est pair");
        }

        else if (evenTest != 0){
            System.out.println(entier + " est impair");
        }
    }

    public static void max(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de votre premier nombre entier ?");
        int nombre1 = scanner.nextInt();
        System.out.println("Quelle est la valeur de votre second nombre entier ?");
        int nombre2 = scanner.nextInt();
        double diff = nombre1 - nombre2;
        if (diff > 0) {
            System.out.println(nombre1);
        }
        else {
            System.out.println(nombre2);
        }
    }

    public static void min(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de votre premier nombre entier ?");
        int nombre1 = scanner.nextInt();
        System.out.println("Quelle est la valeur de votre second nombre entier ?");
        int nombre2 = scanner.nextInt();
        double diff = nombre1 - nombre2;
        if (diff > 0) {
            System.out.println(nombre2);
        }
        else {
            System.out.println(nombre1);
        }
    }
}
