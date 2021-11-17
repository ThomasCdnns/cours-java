package com.company;

public class Cell {
    private Position position;
    private boolean isEmpty;
    private Piece piece;

    public void init(Position position, boolean isEmpty, Piece piece) {
        this.position = position;
        this.isEmpty = isEmpty;
        this.piece = piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        this.isEmpty = false;
    }

    public void setEmpty() {
        this.piece = null;
        this.isEmpty = true;
    }

    public boolean isEmpty(){
        return this.isEmpty;
    }

    public Piece getPiece() {
        if (!isEmpty) {
            return this.piece;
        }
        return null;
    }

    public Position getPosition() {
        return this.position;
    }

    public void movePiece(Cell destinationCell) {
        destinationCell.setPiece(this.piece);
        this.piece.setPosition(destinationCell.getPosition());
        this.setEmpty();
    }
}
