package com.company;

import com.sun.source.tree.BinaryTree;

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
        board = new Cell['h'][8];

        //Initialisation de toutes les cases du plateau
        Cell[] cell = new Cell[64];
        Position[] position = new Position[64];
        char columnChar = 'a';
        int iteration = 0;
        for (int row = 8; row >= 1; row--) { // Ligne de l'échiquier
            for (int column = 1; column <= 8; column++) { // Colonne de l'échiquier
                position[iteration] = new Position();
                cell[iteration] = new Cell();
                cell[iteration].init(position[iteration], true, null);
                columnChar += 1;
                iteration += 1;
            }
            columnChar = 'a';
        }


        //Initialisation de toutes les pièces du plateau
        //Initialisation des pièces blanches
        King WK = new King();
        Position positionWK = new Position();
        positionWK = position[]
        WK.init(positionWK, 0);

        Queen WQ = new Queen();
        Position positionWQ = new Position();
        positionWQ.init('d', 1);
        WQ.init(positionWQ, 0);
        d1.setPiece(WQ);
        board[7][3] = d1;

        Pawn[] WP = new Pawn[8];
        Position[] positionWP = new Position[8];
        columnChar = 'a';
        for (int i = 0; i <= 7; i++) {
            positionWP[i].init(columnChar, 2);
            WP[i].init(positionWP[i], 0);
            board[6][i].setPiece(WP[i]);
            columnChar += 1;
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

        //Initialisation des pièces noires
        King BK = new King();
        Position positionBK = new Position();
        positionBK.init('e', 1);
        BK.init(positionBK, 0);

        Queen BQ = new Queen();
        Position positionBQ = new Position();
        positionBQ.init('d', 1);
        BQ.init(positionBQ, 0);
        Cell d1 = new Cell();
        d1.setPiece(BQ);
        board[7][3] = d1;

        Pawn[] BP = new Pawn[8];
        Position[] positionBP = new Position[8];
        columnChar = 'a';
        for (int i = 0; i <= 7; i++) {
            positionBP[i].init(columnChar, 2);
            BP[i].init(positionBP[i], 0);
            board[6][i].setPiece(BP[i]);
            columnChar += 1;
        }

        Bishop[] BB = new Bishop[2];
        Position[] positionBB = new Position[2];

        positionBB[0].init('c', 1);
        BB[0].init(positionBB[0], 0);
        board[7][2].setPiece(BB[0]);

        positionBB[1].init('f', 1);
        BB[1].init(positionBB[1], 0);
        board[7][5].setPiece(BB[1]);


        Knight[] BN = new Knight[2];
        Position[] positionBN = new Position[2];

        positionBN[0].init('b', 1);
        BN[0].init(positionBN[0], 0);
        board[7][1].setPiece(BN[0]);

        positionBN[1].init('g', 1);
        BN[1].init(positionBN[1], 0);
        board[7][6].setPiece(BN[1]);


        Rook[] BR = new Rook[2];
        Position[] positionBR = new Position[2];

        positionBR[0].init('a', 1);
        BR[0].init(positionBR[0], 0);
        board[7][0].setPiece(BR[0]);

        positionBR[1].init('h', 1);
        BR[1].init(positionBR[1], 0);
        board[7][7].setPiece(BR[1]);



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
