package com.company;

import static com.company.Main.wallets;

public class Transaction {
    private Wallet originWallet;
    private Wallet destinationWallet;
    private int isepCoins;
    private boolean payed = false;

    public void pay(int sourceToken, int destinationToken, int amount) {
        this.originWallet = wallets.get(sourceToken);
        this.destinationWallet = wallets.get(destinationToken);
        this.isepCoins = amount;

        if (originWallet.getToken() != destinationWallet.getToken() && originWallet.getIsepCoins() >= amount){
            originWallet.setIsepCoins(originWallet.getIsepCoins()-amount);
            destinationWallet.setIsepCoins(destinationWallet.getIsepCoins()+amount);
            this.payed = true;
        }
    }

    public boolean isPayed(){
        return this.payed;
    }
}
