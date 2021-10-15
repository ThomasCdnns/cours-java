package com.company;

public class Cell {
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
