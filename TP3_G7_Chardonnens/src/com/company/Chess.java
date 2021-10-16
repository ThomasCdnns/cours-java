package com.company;

import java.util.Scanner;

public class Chess {
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

        //Initialisation du plateau
        board = new Cell[8][8];

        //Initialisation de toutes les cases du plateau
        Cell[] cell = new Cell[64];
        char column = 'a';
        for (int i = 0; i <= 64; i++) {
            Position i = Position();
            cell[i].init(position, true, null);
        }

        //Initialisation de toutes les pièces du plateau
        King WK = new King();
        Position positionWK = new Position();
        positionWK.init('e', 1);
        WK.init(positionWK, 0);
        board[7][4] =;

        Queen WQ = new Queen();
        Position positionWQ = new Position();
        positionWQ.init('d', 1);
        WQ.init(positionWQ, 0);
        Cell d1 = new Cell();
        d1.setPiece(WQ);
        board[7][3] = d1;

        Pawn[] WP = new Pawn[8];
        Position[] positionWP = new Position[8];
        column = 'a';
        for (int i = 0; i <= 7; i++) {
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


        Knight[] WN = new Knight[2];
        Position[] positionWN = new Position[2];

        positionWN[0].init('b', 1);
        WN[0].init(positionWN[0], 0);
        board[7][1].setPiece(WN[0]);

        positionWN[1].init('g', 1);
        WN[1].init(positionWN[1], 0);
        board[7][6].setPiece(WN[1]);


        Rook[] WR = new Rook[2];
        Position[] positionWR = new Position[2];

        positionWR[0].init('a', 1);
        WR[0].init(positionWR[0], 0);
        board[7][0].setPiece(WR[0]);

        positionWR[1].init('h', 1);
        WR[1].init(positionWR[1], 0);
        board[7][7].setPiece(WR[1]);

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
