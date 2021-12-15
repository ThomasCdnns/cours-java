package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private ArrayList<Pokemon> pokemonsTravel = new ArrayList<>(6);
    private ArrayList<Pokemon> pokemonsCenter = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void pokemonUpdate(Pokemon pokemon, int indexInList){
        pokemonsTravel.remove(indexInList);
        pokemonsTravel.add(indexInList, pokemon);
    }

    public void setPokemonsTravel(Pokemon newPokemon) {
        //newPokemon.askNickname();
        if (this.pokemonsTravel.size() == 6){
            Scanner sc = new Scanner(System.in);
            System.out.println("Whick pokemon do you want to put in the healing center?");
            int i = 0;
            for (Pokemon pokemon : this.pokemonsTravel){
                System.out.println(i + ": " + pokemon.getName());
                i+=1;
            }
            int saisie;
            do{
                saisie = sc.nextInt();
            }while(saisie>=i);
            pokemonsCenter.add(pokemonsTravel.get(saisie));
            pokemonsTravel.set(saisie, newPokemon);
        }
        else {
            pokemonsTravel.add(newPokemon);
        }
        System.out.println("New pokemon added to the pokedex: " + newPokemon.getName() + " !");
    }

    public ArrayList<Pokemon> getPokemonsTravel() {
        return pokemonsTravel;
    }

    public ArrayList<Pokemon> getpokemonsCenter() {
        return pokemonsCenter;
    }

    public void setpokemonsCenter(ArrayList<Pokemon> pokemonsCenter) {
        this.pokemonsCenter = pokemonsCenter;
    }
}
