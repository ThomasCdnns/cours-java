package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Main {

    static HashMap<Integer, Wallet> wallets = new HashMap<Integer, Wallet>();
    String[] noms = {"Elliot", "Thomas", "Bora", "Theo", "Alexandre"};
    public void createWallets() {
        Wallet[] wallet = new Wallet[noms.length];

        for (int i=0; i<noms.length; i++){
            Random r = new Random();
            int token = r.nextInt(1000);
            wallet[i].init(noms[i], token, 10);
            wallets.put(token, wallet[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<Block> blockchain = new ArrayList<>();
    }




}
