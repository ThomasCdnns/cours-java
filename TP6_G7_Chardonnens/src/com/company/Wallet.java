package com.company;

public class Wallet {
    private String owner;
    private int token;
    private int isepCoins;

    public void init(String owner, int token, int isepCoins){
        this.owner = owner;
        this.token = token;
        this.isepCoins = isepCoins;
    }

    public int getToken(){
        return this.token;
    }

    public int getIsepCoins(){
        return this.isepCoins;
    }

    public void setIsepCoins(int newAmount) {
        this.isepCoins = newAmount;
    }


}
