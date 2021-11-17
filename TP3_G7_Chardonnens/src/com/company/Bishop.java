package com.company;

import java.util.ArrayList;

public class Bishop extends Piece {

    public String toString() {
        String lettre = "B";
        return lettre;
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        ArrayList<Position> possibleMoves = new ArrayList();

        // Generate all possible moves from the current position
        int currentRow = 8 - this.position.getRow();
        int currentColumn = this.position.getColumn() - 97;
        // Déplacements Diagonaux

        // Faire une fonction récursive plutot qu'une boucle for.
        for (int i = 0; i <= board.length - 1; i++) {
            possibleMoves = tryCell(possibleMoves, board, currentRow + i, currentColumn + i);
            possibleMoves = tryCell(possibleMoves, board, currentRow - i, currentColumn + i);
            possibleMoves = tryCell(possibleMoves, board, currentRow + i, currentColumn - i);
            possibleMoves = tryCell(possibleMoves, board, currentRow - i, currentColumn - i);

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
}
