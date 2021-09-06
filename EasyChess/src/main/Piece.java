package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Piece {
    private Alliance alliance;
    private Position currentPosition;

    Piece(int x, int y, Alliance alliance) {
        this.currentPosition = new Position(x, y);
        this.alliance = alliance;
    }

    Piece(Position position, Alliance alliance) {
        this.currentPosition = position;
        this.alliance = alliance;
    }


    public List<Position> calculateLegalMoves(Board board) {
        final List<Position> legalMoves = new ArrayList();

        if (!board.getField(currentPosition.getX()+ alliance.getDirection(), currentPosition.getY() ).isFieldOccupied){

            legalMoves.add(new Position(currentPosition.getX()+ alliance.getDirection(), currentPosition.getY() ));
        }

        if (currentPosition.getY() > 0) {
            Field leftSide = board.getField(currentPosition.getX() + alliance.getDirection(), currentPosition.getY() - 1);
            if (leftSide.isFieldOccupied
                    && leftSide.getPiece().getAlliance() != alliance){
                legalMoves.add(new Position(leftSide.position));
            }
        }

        if (currentPosition.getY() < board.getSize()-1) {
            Field rightSide = board.getField(currentPosition.getX() + alliance.getDirection(), currentPosition.getY() + 1);
            if (rightSide.isFieldOccupied
                    && rightSide.getPiece().getAlliance() != alliance){
                legalMoves.add(new Position(rightSide.position));
            }
        }
        return legalMoves;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position newPosition) {
        this.currentPosition = newPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return alliance == piece.alliance && Objects.equals(currentPosition, piece.currentPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alliance, currentPosition);
    }

    @Override
    public String toString() {
        return "main.Piece{" +
                "alliance=" + alliance +
                ", currentPosition=" + currentPosition +
                //", isOver=" + isOver +
                '}';
    }
}
