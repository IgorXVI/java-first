package chess;

import boardgame.Position;

public class ChessPosition {
    private final char col;
    private final int row;

    public ChessPosition(char col, int row) {
        if (col < 'a' || col > 'h' || row < 1 || row > 8) {
            throw new ChessException("Invalid chess position");
        }
        this.col = col;
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition() {
        int col = this.col - 'a';
        int row = 8 - this.row;
        return new Position(row, col);
    }

    protected static ChessPosition fromPosition(Position pos) {
        char newCol = (char) (pos.getCol() + 'a');
        int newRow = 8 + pos.getRow();

        return new ChessPosition(newCol, newRow);
    }

    public String toString() {
        return "" + col + row;
    }
}
