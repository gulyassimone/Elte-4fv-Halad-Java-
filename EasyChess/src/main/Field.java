package main;

import java.util.Objects;

public class Field {
    Position position;
    Piece piece;
    boolean isFieldOccupied = false;

    Field(int x, int y){
        position = new Position(x,y);
        piece = null;
    }

    public Position getPosition() {
        return position;
    }

    public Piece getPiece() {
        return piece;
    }

    public Boolean getFieldOccupied() {
        return isFieldOccupied;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void removePiece() {
        piece = null;
        isFieldOccupied = false;
    }

    public void setPiece(Alliance alliance) {
        this.piece = new Piece(this.position, alliance);
        isFieldOccupied =true;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(position, field.position) && Objects.equals(piece, field.piece) && Objects.equals(isFieldOccupied, field.isFieldOccupied);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, piece, isFieldOccupied);
    }

    @Override
    public String toString() {
        return "main.Field{" +
                "position=" + position +
                ", piece=" + piece +
                ", isFieldOccupied=" + isFieldOccupied +
                '}';
    }
}
