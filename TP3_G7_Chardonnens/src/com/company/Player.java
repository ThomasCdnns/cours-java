package com.company;

public class Player {
    private String name;
    private int color;

    public void init(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public int getColor(){
        return this.color;
    }

}
