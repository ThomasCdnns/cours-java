package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Chess {
    private Cell[][] board;
    private Player[][] players;
    private Player currentPlayer;

    public void play() {
        while (true) {
            createPlayers();
            initialiseBoard();
            printBoard();
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

        // Initialisation du plateau
        // Initialisation de toutes les cases du plateau
        // On crée chaque case du plateau puis on lui attribue une position dans l'échiquier
        board = new Cell[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell();
            }
        }

        Position[][] position = new Position[8][8];
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                position[i][j] = new Position();
            }
        }

        char columnChar = 'a';
        int row = 8;

        for (int i = 0; i <= 7; i++) { // Lignes de l'échiquier
            row -= i;
            for (int j = 0; j <= 7; j++) { // Colonnes de l'échiquier
                position[i][j].init(columnChar, row);
                board[i][j].init(position[i][j], true, null);
                columnChar += 1;
            }
            columnChar = 'a';
        }

        //Initialisation de toutes les pièces du plateau
        //Initialisation des pièces blanches

        King WK = new King(); // Nouvelle pièce Roi
        Position positionWK = new Position(); // Nouvelle instance de position pour cette pièce
        positionWK.init('e', 1); // On définit la position du roi en début de partie
        WK.init(positionWK, 0);
        board[7][4].setPiece(WK);

        Queen WQ = new Queen();
        Position positionWQ = new Position();
        positionWQ.init('d', 1);
        WQ.init(positionWQ, 0);
        board[7][3].setPiece(WQ);

        Pawn[] WP = new Pawn[8];
        Position[] positionWP = new Position[8];
        columnChar = 'a';
        for (int i = 0; i <= 7; i++) {
            WP[i] = new Pawn();
            positionWP[i] = new Position();
            positionWP[i].init(columnChar, 2);
            WP[i].init(positionWP[i], 0);
            board[6][i].setPiece(WP[i]);
            columnChar += 1;
        }

        Bishop WB1 = new Bishop();
        Bishop WB2 = new Bishop();
        Position positionWB1 = new Position();
        Position positionWB2 = new Position();

        positionWB1.init('c', 1);
        WB1.init(positionWB1, 0);
        board[7][2].setPiece(WB1);

        positionWB2.init('f', 1);
        WB1.init(positionWB2, 0);
        board[7][5].setPiece(WB2);


        Knight WN1 = new Knight();
        Knight WN2 = new Knight();
        Position positionWN1 = new Position();
        Position positionWN2 = new Position();

        positionWN1.init('b', 1);
        WN1.init(positionWN1, 0);
        board[7][1].setPiece(WN1);

        positionWN2.init('g', 1);
        WN2.init(positionWN2, 0);
        board[7][6].setPiece(WN2);


        Rook WR1 = new Rook();
        Rook WR2 = new Rook();
        Position positionWR1 = new Position();
        Position positionWR2 = new Position();

        positionWR1.init('a', 1);
        WR1.init(positionWR1, 0);
        board[7][0].setPiece(WR1);

        positionWR2.init('h', 1);
        WR2.init(positionWR2, 0);
        board[7][7].setPiece(WR2);

        //Initialisation des pièces noires
        King BK = new King();
        Position positionBK = new Position();
        positionBK.init('e', 1);
        BK.init(positionBK, 0);
        board[0][4].setPiece(BK);

        Queen BQ = new Queen();
        Position positionBQ = new Position();
        positionBQ.init('d', 1);
        BQ.init(positionBQ, 0);
        board[0][3].setPiece(BQ);

        Pawn[] BP = new Pawn[8];
        Position[] positionBP = new Position[8];
        columnChar = 'a';
        for (int i = 0; i <= 7; i++) {
            BP[i] = new Pawn();
            positionBP[i] = new Position();
            positionBP[i].init(columnChar, 2);
            BP[i].init(positionBP[i], 0);
            board[1][i].setPiece(BP[i]);
            columnChar += 1;
        }

        Bishop BB1 = new Bishop();
        Bishop BB2 = new Bishop();
        Position positionBB1 = new Position();
        Position positionBB2 = new Position();

        positionBB1.init('c', 1);
        BB1.init(positionBB1, 0);
        board[0][2].setPiece(BB1);

        positionBB2.init('f', 1);
        BB2.init(positionBB2, 0);
        board[0][5].setPiece(BB2);


        Knight BN1 = new Knight();
        Knight BN2 = new Knight();
        Position positionBN1 = new Position();
        Position positionBN2 = new Position();

        positionBN1.init('b', 1);
        BN1.init(positionBN1, 0);
        board[0][1].setPiece(BN1);

        positionBN2.init('g', 1);
        BN2.init(positionBN2, 0);
        board[0][6].setPiece(BN2);

        Rook BR1 = new Rook();
        Rook BR2 = new Rook();
        Position positionBR1 = new Position();
        Position positionBR2 = new Position();

        positionBR1.init('a', 1);
        BR1.init(positionBR1, 0);
        board[0][0].setPiece(BR1);

        positionBR2.init('h', 1);
        BR2.init(positionBR2, 0);
        board[0][7].setPiece(BR2);
    }

    private void printBoard() {
        char columnChar = 'a';
        int row = 8;
        System.out.print(" " + '\t' + "|" + '\t');
        for (int j = 0; j <= 7; j++) {
            System.out.print(columnChar);
            System.out.print('\t' + "|" + '\t');
            columnChar += 1;
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i <= 7; i++) {
            System.out.print(row);
            System.out.print('\t' + "|" + '\t');
            for (int j = 0; j <= 7; j++) {
                Object piece = board[i][j].get();
                if (piece != null) {
                    System.out.print(piece);
                } else {
                    System.out.print(" ");
                }
                System.out.print('\t' + "|" + '\t');
            }
            System.out.print(row);
            System.out.println();
            row -= 1;
        }
        System.out.println();
        columnChar = 'a';
        System.out.print(" " + '\t' + "|" + '\t');
        for (int j = 0; j <= 7; j++) {
            System.out.print(columnChar);
            System.out.print('\t' + "|" + '\t');
            columnChar += 1;
        }
        System.out.println();
    }

    private String askMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quel est votre action ? : ");
        String move = scanner.next();
        return move;
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
