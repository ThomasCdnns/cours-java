package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Pawn {
    private Position position;
    private int color;
    private boolean isFirstMove = true;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        ArrayList<Position> possibleMoves = new ArrayList();

        // Generate all possible moves from the current position

        int currentColumn = this.position.getColumn() - 97;
        int currentRow = 8 - this.position.getRow();

        if (board[currentRow + 1][currentColumn].isEmpty()){
            if (isFirstMove) {
                possibleMoves.add(board[currentRow + 2][currentColumn].getPosition());
            }

            if (board[currentRow + 1][currentColumn] != null) {
                possibleMoves.add(board[currentRow + 1][currentColumn].getPosition());
            }
        }

        // Déplacement Diagonaux
        for (int i = 0; i <= board.length; i++) {
            boolean isEmpty = board[currentRow + i][currentColumn + i].isEmpty();
            if (!isEmpty) {
                possibleMoves.add(board[currentRow + i][currentColumn + i].getPosition());
            }
            isEmpty = board[currentRow + i][currentColumn - i].isEmpty();
            if (!isEmpty) {
                possibleMoves.add(board[currentRow + i][currentColumn - i].getPosition());
            }
        }

        // Compare if the newPosition is part of all the possible moves
        if (Arrays.asList(possibleMoves).contains(newPosition)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String lettre = "P";
        return lettre;
    }
}
