package com.company;

public class Position {
    private char column;
    private int row;

    public void init(char column, int row) {
        this.column = column;
        this.row = row;
    }

    public char getColumn(){
        return this.column;
    }

    public int getRow(){
        return this.row;
    }

    public String toString(char column, int row) {
        return column + String.valueOf(row);
    }

    public String getString() {
        StringBuilder string = new StringBuilder();
        string.append(column);
        string.append(row);
        return string.toString();
    }
}
