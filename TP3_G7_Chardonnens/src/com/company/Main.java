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

    public void init(char column, int row) {
        this.column = column;
        this.row = row;
    }

    public String toString(char column, int row) {
        return column + String.valueOf(row);
    }
}

class King {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //Générer toutes les positions possibles à partir de l'ancienne position
        return false;
    }

    public String toString() {
        String lettre = "K";
        return lettre;
    }
}

class Queen {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //Générer toutes les positions possibles à partir de l'ancienne position
        return false;
    }

    public String toString() {
        String lettre = "Q";
        return lettre;
    }
}

class Bishop {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //Générer toutes les positions possibles à partir de l'ancienne position
        return false;
    }

    public String toString() {
        String lettre = "B";
        return lettre;
    }
}

class Knight {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //Générer toutes les positions possibles à partir de l'ancienne position
        return false;
    }

    public String toString() {
        String lettre = "N";
        return lettre;
    }
}

class Rook {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //Générer toutes les positions possibles à partir de l'ancienne position
        return false;
    }

    public String toString() {
        String lettre = "R";
        return lettre;
    }
}

class Pawn {
    private Position position;
    private int color;

    public void init(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //Générer toutes les positions possibles à partir de l'ancienne position
        return false;
    }

    public String toString() {
        String lettre = "P";
        return lettre;
    }
}

class Cell {
    private Position position;
    private boolean isEmpty;
    private Object piece;

    public void setPiece(Object piece) {
        this.piece = piece;
        this.isEmpty = false;
    }

    public void setEmpty() {
        this.piece = null;
        this.isEmpty = true;
    }

    public Object get() {
        if (!isEmpty) {
            return this.piece;
        }
        return null;
    }
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
        board = new Cell[7][7];

        King WK = new King();
        Position positionWK = new Position();
        positionWK.init('e', 1);
        WK.init(positionWK, 0);
        board[7][4].setPiece(WK);

        Queen WQ = new Queen();
        Position positionWQ = new Position();
        positionWQ.init('d', 1);
        WQ.init(positionWQ, 0);
        board[7][3].setPiece(WQ);

        Pawn[] WP = new Pawn[8];
        Position[] positionWP = new Position[8];
        char column = 'a';
        for (int i=0; i<=7; i++){
            positionWP[i].init(column, 2);
            WP[i].init(positionWP[i], 0);
            board[6][i].setPiece(WP[i]);
            column += 1;
        }

        Bishop[] WB = new Bishop[2];
        Position[] positionWB = new Position[2];

        positionWB[0].init('c', 1);
        WB[0].init(positionWB[0], 0);
        board[7][2].setPiece(WB[0]);

        positionWB[1].init('f', 1);
        WB[1].init(positionWB[1], 0);
        board[7][5].setPiece(WB[1]);


        Queen WQ = new Queen();
        Position positionWQ = new Position();
        positionWQ.init('d', 1);
        WQ.init(positionWQ, 0);
        board[7][3].setPiece(WQ);

        King WK = new King();
        Position positionWK = new Position();
        positionWK.init('e', 1);
        WK.init(positionWK, 0);
        board[7][4].setPiece(WK);

        Queen WQ = new Queen();
        Position positionWQ = new Position();
        positionWQ.init('d', 1);
        WQ.init(positionWQ, 0);
        board[7][3].setPiece(WQ);

        King WK = new King();
        Position positionWK = new Position();
        positionWK.init('e', 1);
        WK.init(positionWK, 0);
        board[7][4].setPiece(WK);

        Queen WQ = new Queen();
        Position positionWQ = new Position();
        positionWQ.init('d', 1);
        WQ.init(positionWQ, 0);
        board[7][3].setPiece(WQ);


        Knight WK1 = new Knight();
        Knight WK2 = new Knight();
        Rook WR1 = new Rook();
        Rook WR2 = new Rook();

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





