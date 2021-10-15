package com.company;

public class King {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //Générer toutes les positions possibles à partir de l'ancienne position
        return false;
    }

    public String toString() {
        String lettre = "K";
        return lettre;
    }
}
