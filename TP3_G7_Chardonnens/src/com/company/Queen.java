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
        int currentRow = 8 - this.position.getRow();
        int currentColumn = this.position.getColumn() - 97;

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

    public String toString() {
        String lettre = "Q";
        return lettre;
    }

    public ArrayList<Position> tryCell(ArrayList<Position> possibleMoves, Cell[][] board, int indexRow, int indexColumn) {
        try {
            boolean isEmpty = board[indexRow][indexColumn].isEmpty();
            if (!isEmpty) {
                possibleMoves.add(board[indexRow][indexColumn].getPosition());
            }
        } catch (Exception ignored) {
        }
        return possibleMoves;
    }
}
