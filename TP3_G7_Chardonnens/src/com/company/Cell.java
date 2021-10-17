package com.company;

public class Cell {
    private Position position;
    private boolean isEmpty;
    private Object piece;

    public void init(Position position, boolean isEmpty, Object piece) {
        this.position = position;
        this.isEmpty = isEmpty;
        this.piece = piece;
    }

    public void setPiece(Object piece) {
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

    public Object getPiece() {
        if (!isEmpty) {
            return this.piece;
        }
        return null;
    }

    public Position getPosition() {
        return this.position;
    }
}
