package com.company;

import java.util.ArrayList;

public class Pawn {
    private Position position;
    private int color;
    private boolean isFirstMove = true;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

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
            if (isFirstMove) {
                tryCell(possibleMoves, board, currentRow + (2 * colorIncrement), currentColumn);
            }
            tryCell(possibleMoves, board, currentRow + colorIncrement, currentColumn);
        }

        // Déplacement Diagonaux
        for (int i = 0; i <= board.length - 1; i++) {
            tryCell(possibleMoves, board, currentRow + colorIncrement, currentColumn + 1);
            tryCell(possibleMoves, board, currentRow + colorIncrement, currentColumn - 1);
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

    public ArrayList<Position> tryCell(ArrayList<Position> possibleMoves, Cell[][] board, int indexRow, int indexColumn) {
        try {
            if (indexRow<8 && indexRow>=0 && indexColumn<8 && indexColumn>=0){
                boolean isEmpty = board[indexRow][indexColumn].isEmpty();
                if (isEmpty) {
                    possibleMoves.add(board[indexRow][indexColumn].getPosition());
                }
            }
        } catch (Exception ignored) {
        }
        return possibleMoves;
    }
}
