package main;

import java.util.Arrays;

public class Board {
    private final int size;
    private Field[][] board;
    private Field selectedField;
    private Alliance winner;


    public Board(final int size) {
        this.size = size;
        board = new Field[this.size][this.size];
        selectedField = null;
        winner = null;
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                board[i][j] = new Field(i,j);
            }
        }
        initial();
    }

    public void setSelected(Field selected) {
        selectedField = selected;
    }

    public void setWinner(Alliance winner) {
        this.winner = winner;
    }

    public Field getField(int x, int y) {
        return board[x][y];
    }

    public int getSize() {
        return size;
    }

    public Field getSelected() {
        return selectedField;
    }

    public Alliance getWinner() {
        return winner;
    }

    /**
     * set piece to
     */
    public void initial(){
        Alliance black = Alliance.BLACK;
        Alliance white = Alliance.WHITE;

        for(int i=0; i<this.size; ++i){
            board[0][i].setPiece(black);
            board[this.size-1][i].setPiece(white);
            board[1][i].setPiece(black);
            board[this.size-2][i].setPiece( white);
        }

    }

}
