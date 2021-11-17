package com.company;

import java.util.ArrayList;

public class Piece {
    protected Position position;
    protected int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public void setPosition(Position newPosition){
        this.position = newPosition;
    }

    public ArrayList<Position> tryCell(ArrayList<Position> possibleMoves, Cell[][] board, int indexRow, int indexColumn) {
        try {
            if (indexRow<8 && indexRow>=0 && indexColumn<8 && indexColumn>=0){
                boolean isEmpty = board[indexRow][indexColumn].isEmpty();

                if (isEmpty) {
                    possibleMoves.add(board[indexRow][indexColumn].getPosition());
                }

                //Pièce adverse
                else if (board[indexRow][indexColumn].getPiece().getColor() != color){
                    possibleMoves.add(board[indexRow][indexColumn].getPosition());
                }
            }
        } catch (Exception ignored) {
        }
        return possibleMoves;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board){
        return false;
    }
}
