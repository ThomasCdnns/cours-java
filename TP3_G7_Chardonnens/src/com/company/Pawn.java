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

        if (board[currentRow - 1][currentColumn].isEmpty()) {
            if (isFirstMove) {
                possibleMoves.add(board[currentRow - 2][currentColumn].getPosition());
            }

            if (board[currentRow - 1][currentColumn] != null) {
                possibleMoves.add(board[currentRow - 1][currentColumn].getPosition());
            }
        }

        // Déplacement Diagonaux
        for (int i = 0; i <= board.length - 1; i++) {
            try {
                boolean isEmpty = board[currentRow - 1][currentColumn + 1].isEmpty();
                if (!isEmpty) {
                    possibleMoves.add(board[currentRow - 1][currentColumn + 1].getPosition());
                }
            } catch (Exception e) {

            }
            try {
                boolean isEmpty = board[currentRow - 1][currentColumn - 1].isEmpty();
                if (!isEmpty) {
                    possibleMoves.add(board[currentRow - 1][currentColumn - 1].getPosition());
                }
            } catch (Exception e) {

            }
        }

        // Compare if the newPosition is part of all the possible moves
        boolean isInArray = false;
        for (Position p : possibleMoves) {
            if (p.getString().equals(newPosition.getString())) {
                isInArray = true;

            }
        }
        return isInArray;
    }

    public String toString() {
        String lettre = "P";
        return lettre;
    }
}
