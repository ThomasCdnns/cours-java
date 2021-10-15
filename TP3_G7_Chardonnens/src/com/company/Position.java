package com.company;

public class Position {
    private char column;
    private int row;

    public void init(char column, int row) {
        this.column = column;
        this.row = row;
    }

    public String toString(char column, int row) {
        return column + String.valueOf(row);
    }
}
