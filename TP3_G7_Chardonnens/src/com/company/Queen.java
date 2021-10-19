package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        ArrayList<Position> possibleMoves = new ArrayList();

        // Generate all possible moves from the current position

        // Déplacement Vertical
        for (int row = 0; row <= board.length - 1; row++) {
            int columnCharToInt = this.position.getColumn();
            possibleMoves.add(board[row][columnCharToInt].getPosition());
        }
        //Déplacement Horizontal
        for (int column = 0; column <= board.length - 1; column++) {
            int rowBoardToInt = 8 - this.position.getRow();
            possibleMoves.add(board[rowBoardToInt][column].getPosition());
        }

        // Déplacement Diagonaux x+1
        for (int i = 0; i <= board.length - 1; i++) {
            int currentRow = 8 - this.position.getRow();
            int currentColumn = this.position.getColumn() - 97;
            possibleMoves.add(board[currentRow + i][currentColumn + i].getPosition());
            possibleMoves.add(board[currentRow - i][currentColumn - i].getPosition());
            possibleMoves.add(board[currentRow + i][currentColumn - i].getPosition());
            possibleMoves.add(board[currentRow - i][currentColumn + i].getPosition());
        }

        // Compare if the newPosition is part of all the possible moves
        if (Arrays.asList(possibleMoves).contains(newPosition)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String lettre = "Q";
        return lettre;
    }
}
