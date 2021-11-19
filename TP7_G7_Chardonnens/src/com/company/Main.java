package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> pokemonSet1 = new ArrayList<>();
        pokemonSet1.add("TIPLOUF");
        pokemonSet1.add("OUISTICRAM");
        pokemonSet1.add("TORTIPOUSS");
        ArrayList<String> pokemonSet2 = new ArrayList<>();
        pokemonSet2.add("ARCKO");
        pokemonSet2.add("POUSSIFEU");
        pokemonSet2.add("GOBOU");
        ArrayList<String> pokemonSet3 = new ArrayList<>();
        pokemonSet3.add("BULBIZARRE");
        pokemonSet3.add("SALAMECHE");
        pokemonSet3.add("CARAPUCE");

        HashMap<ProfessorEnum.ProfessorName, ArrayList<String>> profPokemonSets = new HashMap<>();
        profPokemonSets.put(ProfessorEnum.ProfessorName.SORBIER, pokemonSet1);
        profPokemonSets.put(ProfessorEnum.ProfessorName.SEKO, pokemonSet2);
        profPokemonSets.put(ProfessorEnum.ProfessorName.CHEN, pokemonSet3);
        Professor professor = new Professor();
        Scanner sc = new Scanner(System.in);
        System.out.println("Who is your professor?");
        String saisie = sc.nextLine();
        ProfessorEnum.ProfessorName professorValue = null;
        boolean isValidProfessor = false;
        for (int i=0; i < ProfessorEnum.ProfessorName.values().length; i++){
            professorValue = ProfessorEnum.ProfessorName.values()[i];
            String professorName = professorValue.name();
            if (saisie.equals(professorName)) {
                isValidProfessor = true;
                professor.init(professorValue);
                Pokemon firstPokemon = professor.choosePokemon(profPokemonSets.get(professorValue));
                break;
            }
        }
    }
}
