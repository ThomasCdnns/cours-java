package com.company;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.time.Year;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import static java.lang.Math.abs;
import static java.lang.Math.atan;

public class Main {

    public static int attack(Pokemon pokemon){
        int finalDamage = 0;
        int baseDamage = pokemon.askAttack();

        Random random = new Random();
        int randomCritical = random.nextInt(100);
        if (randomCritical >= 95){
            finalDamage = baseDamage*2;
        }
        else {
            Random random1 = new Random();
            float randomPercentage = (-10)+random1.nextInt(10-(-10));
            randomPercentage = randomPercentage/100;
            finalDamage = (int) (baseDamage*(1+randomPercentage));
        }
        return finalDamage;
    }

    public static int choosePokemon(ArrayList<Pokemon> pokemons, Player player){
        Scanner sc = new Scanner(System.in);
        int saisie;
        System.out.println(player.getName()+", which pokemon do you choose? : ");
        int i = 0;
        for (Pokemon pokemon : pokemons){
            System.out.println(i + ": " + pokemon.getName() + " — Life: " + pokemon.getCurrentPV()+"/"+pokemon.getMaxPV());
            i+=1;
        }
        do{
            saisie = sc.nextInt();
        }while(saisie>=i);
        Pokemon pokemon = pokemons.get(saisie);
        System.out.println("Changed your in-fight Pokemon to " + pokemon.getName());
        return saisie;
    }

    public static void fight(Player player1, Player player2){
        ArrayList<Pokemon> pokemonsPlayer1 = player1.getPokemonsTravel();
        ArrayList<Pokemon> pokemonsPlayer2 = player2.getPokemonsTravel();

        boolean isOver = false;
        ArrayList<Pokemon> pokemonsOpponent = player2.getPokemonsTravel();
        ArrayList<Pokemon> pokemonsMe = player1.getPokemonsTravel();
        Pokemon currentPlayable = pokemonsPlayer1.get(0);
        Pokemon currentOpponent = pokemonsPlayer2.get(0);
        Player opponentPlayer = player2;
        Player mePlayer = player1;

        ArrayList<Pokemon> oldPokemonsOpponent = null;
        ArrayList<Pokemon> oldPokemonsMe = null;
        Pokemon oldOpponent = null;
        Pokemon oldPlayable = null;
        Player oldMePlayer = null;
        Player oldOpponentPlayer = null;
        int oldIndexCurrentPlayable = 0;
        int oldIndexCurrentOpponent = 0;

        int indexCurrentOpponent = 0;
        int indexCurrentPlayable = 0;
        int totalLife = 0;
        boolean isFirstTurn = true;

        Scanner sc = new Scanner(System.in);
        while (!isOver){
            if (!isFirstTurn){
                pokemonsOpponent = oldPokemonsMe;
                pokemonsMe = oldPokemonsOpponent;
                currentOpponent = oldPlayable;
                currentPlayable = oldOpponent;
                mePlayer = oldOpponentPlayer;
                opponentPlayer = oldMePlayer;
                indexCurrentOpponent = oldIndexCurrentPlayable;
                indexCurrentPlayable = oldIndexCurrentOpponent;
            }

            for (Pokemon pokemon:pokemonsOpponent){
                totalLife += pokemon.getCurrentPV();
            }

            System.out.println(mePlayer.getName() + ", what is your choice: ");
            System.out.println("0: Attack");
            System.out.println("1: Change Pokemon");
            int saisie;
            do{
                saisie = sc.nextInt();
            } while(saisie>1);
            switch (saisie) {
                case 0 -> {
                    int currentOpponentPV = currentOpponent.getCurrentPV();
                    int damage = attack(currentPlayable);
                    currentOpponent.setCurrentPV(currentOpponentPV - damage);
                    System.out.println(currentPlayable.getName() + " did " + damage + " to " + currentOpponent.getName());
                    totalLife -= abs(damage);
                    pokemonsOpponent.set(indexCurrentOpponent, currentOpponent);
                    if (currentOpponent.getCurrentPV() <= 0 && totalLife > 0) {
                        System.out.println(currentOpponent.getName() + " can't fight anymore...");
                        indexCurrentOpponent = choosePokemon(pokemonsOpponent, opponentPlayer);
                        currentOpponent = pokemonsOpponent.get(indexCurrentOpponent);
                    } else if (currentOpponent.getCurrentPV() <= 0 && totalLife <= 0) {
                        isOver = true;
                        System.out.println(player1.getName() + " won the duel.");
                    }
                }
                case 1 -> {
                    indexCurrentPlayable = choosePokemon(pokemonsMe, mePlayer);
                    currentPlayable = pokemonsMe.get(indexCurrentPlayable);
                }
            }
            oldMePlayer = mePlayer;
            oldOpponentPlayer = opponentPlayer;
            oldOpponent = currentOpponent;
            oldPlayable = currentPlayable;
            oldPokemonsOpponent = pokemonsOpponent;
            oldPokemonsMe = pokemonsMe;
            oldIndexCurrentOpponent = indexCurrentOpponent;
            oldIndexCurrentPlayable = indexCurrentPlayable;
            totalLife = 0;
            isFirstTurn = false;

        }
    }

    public static Pokemon[] getAllPokemons()
    {
        Pokemon[] pokemons = new Pokemon[0];
        try {
            FileReader filereader = new FileReader("src/com/company/pokemonsList.csv");
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
                pokemon.initCurrentPV();
                pokemons[i] = pokemon;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pokemons;
    }

    public static void main(String[] args) {

        //Creating Pokemon choices by Professor
        Pokemon[] pokemons = getAllPokemons();
        ArrayList<Pokemon> pokemonSet1 = new ArrayList<>();
        pokemonSet1.add(pokemons[0]);
        pokemonSet1.add(pokemons[1]);
        pokemonSet1.add(pokemons[2]);
        ArrayList<Pokemon> pokemonSet2 = new ArrayList<>();
        pokemonSet2.add(pokemons[3]);
        pokemonSet2.add(pokemons[4]);
        pokemonSet2.add(pokemons[5]);
        ArrayList<Pokemon> pokemonSet3 = new ArrayList<>();
        pokemonSet3.add(pokemons[6]);
        pokemonSet3.add(pokemons[7]);
        pokemonSet3.add(pokemons[8]);

        HashMap<ProfessorEnum.ProfessorName, ArrayList<Pokemon>> profPokemonSets = new HashMap<>();
        profPokemonSets.put(ProfessorEnum.ProfessorName.SORBIER, pokemonSet1);
        profPokemonSets.put(ProfessorEnum.ProfessorName.SEKO, pokemonSet2);
        profPokemonSets.put(ProfessorEnum.ProfessorName.CHEN, pokemonSet3);

        //Meeting the Professor and getting your first Pokemon
        Professor professor = new Professor();
        Player player = new Player();
        player.setName("Alex");
        Scanner sc = new Scanner(System.in);
        System.out.println("Who is your professor?");
        String saisie = sc.nextLine();
        ProfessorEnum.ProfessorName professorValue = null;
        for (int i=0; i < ProfessorEnum.ProfessorName.values().length; i++) {
            professorValue = ProfessorEnum.ProfessorName.values()[i];
            String professorName = professorValue.name();
            if (saisie.equals(professorName)) {
                professor.init(professorValue);
                Pokemon pokemon = professor.choosePokemon(profPokemonSets.get(professorValue));
                pokemon.initCurrentPV();
                //pokemon.askNickname();
                player.setPokemonsTravel(pokemon);
                break;
            }
        }

        //Story
        System.out.println("Exiting professor's lab...");
        System.out.println("On the way to the next Arena, you have to get in bushes.");
        System.out.println("Something moves...");
        System.out.println("It's a pokemon family reunion!");
        System.out.println("They let you catch them: you have new pokemons!");

        //Catching new Pokemons
        Pokemon[] pokemonBushes = getAllPokemons();
        Random random = new Random();
        for(int i = 0; i<6; i++){
            int randomPokemon = random.nextInt(pokemonBushes.length-2);
            Pokemon pokemon = pokemonBushes[randomPokemon];
            System.out.println("You catched a " + pokemon.getName());
            player.setPokemonsTravel(pokemon);
        }

        //Story
        System.out.println("By training all your Pokemons, one of them learned a new attack!");

        ArrayList<Pokemon> pokemonsPlayer = player.getPokemonsTravel();
        int randomIndex = random.nextInt(pokemonsPlayer.size());
        Pokemon newPokemon = pokemonsPlayer.get(randomIndex);
        System.out.println(pokemonsPlayer.get(randomIndex).getName() + "'s attacks : ");
        newPokemon.setAttack("AncientPower", 60);
        player.pokemonUpdate(newPokemon, randomIndex);

        //Story
        System.out.println("You finally arrived at the Arena of Issy-les-Moulino.");
        System.out.println("However, the Team Rocket won't let you get in... It's time to fight!");

        Player teamRocket = new Player();
        teamRocket.setName("Team Rocket");
        teamRocket.setPokemonsTravel(pokemonBushes[9]);
        teamRocket.setPokemonsTravel(pokemonBushes[10]);

        fight(player, teamRocket);

    }
}
