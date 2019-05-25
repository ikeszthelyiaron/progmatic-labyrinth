package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;

/**
 * A simple immutable class for encapsulating a row and a column index.
 * 
 * @author pappgergely
 */
public class Coordinate {
    
    private final int row, col;
    public CellType ct;

    public void setCt(CellType ct) {
        this.ct = ct;
    }

    public CellType getCt() {
        return this.ct;
    }

    public Coordinate(int col, int row) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.col != other.col) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.row;
        hash = 83 * hash + this.col;
        return hash;
    }
}
