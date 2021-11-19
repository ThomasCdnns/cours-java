package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Professor {
    ProfessorEnum.ProfessorName professorName;

    public void init(ProfessorEnum.ProfessorName professorName){
        this.professorName = professorName;
    }

    public Pokemon choosePokemon(ArrayList<String> pokemonList){
        int sizePokemonSet = pokemonList.size();
        int randomRemoval = ThreadLocalRandom.current().nextInt(0, sizePokemonSet);
        pokemonList.remove(randomRemoval);
        sizePokemonSet = pokemonList.size();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome young trainer! Which Pokemon do you want to choose?");
        for (int i=0; i < sizePokemonSet; i++){
            System.out.println(i + ": " + pokemonList.get(i));
        }
        int saisie = sc.nextInt();
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonList.get(saisie));
        System.out.println("You chose this pokemon: " + pokemonList.get(saisie));
        return pokemon;
    }
}
