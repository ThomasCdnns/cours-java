package com.company;

import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean isFirstMove = true;

    public String toString() {
        String lettre = "P";
        return lettre;
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        ArrayList<Position> possibleMoves = new ArrayList();

        // Generate all possible moves from the current position

        int currentColumn = this.position.getColumn() - 97;
        int currentRow = 8 - this.position.getRow();
        int colorIncrement;
        if (this.color == 0) {
            colorIncrement = -1;
        } else {
            colorIncrement = 1;
        }

        if (board[currentRow + colorIncrement][currentColumn].isEmpty()) {
            possibleMoves = tryCell(possibleMoves, board, currentRow + colorIncrement, currentColumn);
            if (isFirstMove) {
                possibleMoves = tryCell(possibleMoves, board, currentRow + (2 * colorIncrement), currentColumn);
            }
        }

        // Déplacement Diagonaux seulement si c'est un adversaire
        if (!board[currentRow + colorIncrement][currentColumn + 1].isEmpty()) {
            if (board[currentRow + colorIncrement][currentColumn + 1].getPiece().getColor() != color){
                possibleMoves.add(board[currentRow + colorIncrement][currentColumn + 1].getPosition());
            }
        }

        if (!board[currentRow + colorIncrement][currentColumn - 1].isEmpty()) {
            if (board[currentRow + colorIncrement][currentColumn - 1].getPiece().getColor() != color){
                possibleMoves.add(board[currentRow + colorIncrement][currentColumn - 1].getPosition());
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

}
