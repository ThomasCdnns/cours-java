package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.play();
    }
}

class Player {
    private String name;
    private int color;

    public void init(String name, int color) {
        this.name = name;
        this.color = color;
    }

}

class Position {
    private char column;
    private int row;

    public String toString(char column, int row) {
        return column + String.valueOf(row);
    }
}

class King extends Piece {


}

class Queen extends Piece {

}

class Bishop extends Piece {

}

class Knight extends Piece {

}

class Rook extends Piece {

}

class Pawn extends Piece {

}



class Piece {
    private Position position;
    private int color;
    private char piece;

    public void init(char piece, Position position, int color){
        this.piece = piece;
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //Générer toutes les positions possibles à partir de l'ancienne position

        boolean move;
        return move = true;
    }

    public String toString() {
        String string;
        return string = "test";
    }
}


class Cell {
    private Position position;
    private boolean isEmpty;
    // Quelle pièce occupe cette case ?
}

class Chess {
    private Cell[][] board;
    private Player[][] players;
    private Player currentPlayer;

    public void play() {
        while (true) {
            createPlayers();
            initialiseBoard();
            while (!isCheckMate()) {
                printBoard();
                String move;
                do {
                    move = askMove();
                }
                while (!isValidMove(move));
                updateBoard(move);
                switchPlayer();
            }
        }
    }

    private void createPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quel est le nom du joueur des pions blancs ? : ");
        String nameWhite = scanner.next();
        System.out.print("Quel est le nom du joueur des pions noirs ? : ");
        String nameBlack = scanner.next();
        Player playerWhite = new Player();
        playerWhite.init(nameWhite, 0);
        Player playerBlack = new Player();
        playerBlack.init(nameBlack, 1);
        currentPlayer = playerWhite;
    }

    private void initialiseBoard() {
        board = new Cell[8][8];
        King whiteKing = new King();
        Queen whiteQueen = new Queen();
        Pawn white1Pawn = new Pawn();
        Pawn white2Pawn = new Pawn();
        Pawn white3Pawn = new Pawn();
        Pawn white4Pawn = new Pawn();
        Pawn white5Pawn = new Pawn();
        Pawn white6Pawn = new Pawn();
        Pawn white7Pawn = new Pawn();
        Pawn white8Pawn = new Pawn();
        Bishop white1Bishop = new Bishop();
        Bishop white2Bishop = new Bishop();
        Knight white1Knight = new Knight();
        Knight white2Knight = new Knight();
        Rook white1Rook = new Rook();
        Rook white2Rook = new Rook();

        King blackKing = new King();
        Queen blackQueen = new Queen();
        Pawn black1Pawn = new Pawn();
        Pawn black2Pawn = new Pawn();
        Pawn black3Pawn = new Pawn();
        Pawn black4Pawn = new Pawn();
        Pawn black5Pawn = new Pawn();
        Pawn black6Pawn = new Pawn();
        Pawn black7Pawn = new Pawn();
        Pawn black8Pawn = new Pawn();
        Bishop black1Bishop = new Bishop();
        Bishop black2Bishop = new Bishop();
        Knight black1Knight = new Knight();
        Knight black2Knight = new Knight();
        Rook black1Rook = new Rook();
        Rook black2Rook = new Rook();



    }

    private void printBoard() {

    }

    private String askMove() {
        String test;
        return test = "test";
    }

    private boolean isCheckMate() {
        boolean move;
        return move = true;
    }

    private boolean isValidMove(String move) {
        boolean move1;
        return move1 = true;
    }

    private void updateBoard(String move) {

    }

    private void switchPlayer() {

    }
}





