package com.company;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Main {

    public static Pokemon[] readCSV(String file)
    {
        Pokemon[] pokemons = new Pokemon[0];
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            pokemons = new Pokemon[allData.size()];

            for(int i=0;i<allData.size();i++){
                String[] row = allData.get(i);
                Pokemon pokemon = new Pokemon();
                pokemon.init(row[0],row[1],Integer.parseInt(row[2]));
                pokemon.setAttack(row[3], Integer.parseInt(row[4]));
                pokemon.setAttack(row[5], Integer.parseInt(row[6]));
                pokemon.setAttack(row[7], Integer.parseInt(row[8]));
                pokemon.setAttack(row[9], Integer.parseInt(row[10]));
                pokemons[i] = pokemon;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pokemons;
    }

    public static void main(String[] args) {
        Pokemon[] pokemons = readCSV("src/com/company/pokemonsList.csv");
        ArrayList<String> pokemonSet1 = new ArrayList<>();
        pokemonSet1.add(pokemons[1].getName());
        pokemonSet1.add(pokemons[1].getName());
        pokemonSet1.add(pokemons[2].getName());
        ArrayList<String> pokemonSet2 = new ArrayList<>();
        pokemonSet2.add(pokemons[3].getName());
        pokemonSet2.add(pokemons[4].getName());
        pokemonSet2.add(pokemons[5].getName());
        ArrayList<String> pokemonSet3 = new ArrayList<>();
        pokemonSet3.add(pokemons[6].getName());
        pokemonSet3.add(pokemons[7].getName());
        pokemonSet3.add(pokemons[8].getName());

        HashMap<ProfessorEnum.ProfessorName, ArrayList<String>> profPokemonSets = new HashMap<>();
        profPokemonSets.put(ProfessorEnum.ProfessorName.SORBIER, pokemonSet1);
        profPokemonSets.put(ProfessorEnum.ProfessorName.SEKO, pokemonSet2);
        profPokemonSets.put(ProfessorEnum.ProfessorName.CHEN, pokemonSet3);

        Professor professor = new Professor();
        Player player = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.println("Who is your professor?");
        String saisie = sc.nextLine();
        ProfessorEnum.ProfessorName professorValue = null;
        for (int i=0; i < ProfessorEnum.ProfessorName.values().length; i++){
            professorValue = ProfessorEnum.ProfessorName.values()[i];
            String professorName = professorValue.name();
            if (saisie.equals(professorName)) {
                professor.init(professorValue);
                player.setpokemonsTravel(professor.choosePokemon(profPokemonSets.get(professorValue)));
                break;
            }
        }
    }
}
