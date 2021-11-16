package com.company;

import java.util.ArrayList;

public class Knight extends Piece {

    public String toString() {
        String lettre = "N";
        return lettre;
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        ArrayList<Position> possibleMoves = new ArrayList();

        // Generate all possible moves from the current position

        int currentColumn = this.position.getColumn() - 97;
        int currentRow = 8 - this.position.getRow();

        possibleMoves = tryCell(possibleMoves, board, currentRow + 1, currentColumn + 2);
        possibleMoves = tryCell(possibleMoves, board, currentRow + 2, currentColumn + 1);

        possibleMoves = tryCell(possibleMoves, board, currentRow + 1, currentColumn - 2);
        possibleMoves = tryCell(possibleMoves, board, currentRow + 2, currentColumn - 1);

        possibleMoves = tryCell(possibleMoves, board, currentRow - 1, currentColumn + 2);
        possibleMoves = tryCell(possibleMoves, board, currentRow - 2, currentColumn + 1);

        possibleMoves = tryCell(possibleMoves, board, currentRow - 1, currentColumn - 2);
        possibleMoves = tryCell(possibleMoves, board,currentRow - 2, currentColumn - 1);

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
