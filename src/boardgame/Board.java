package boardgame;

public class Board {
    private final int rows;
    private final int cols;
    private final Piece[][] pieces;

    public Board(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new BoardException("Board requires at least one row and column");
        }
        this.rows = rows;
        this.cols = cols;

        pieces = new Piece[rows][cols];
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Piece getPiece(int row, int col) {
        validatePosition(row, col);
        return pieces[row][col];
    }

    public Piece getPiece(Position pos) {
        return getPiece(pos.getRow(), pos.getCol());
    }

    public void placePiece(Piece piece, Position pos) {
        if (thereIsAPiece(pos)) {
            throw new BoardException("Board position already contains a piece");
        }

        pieces[pos.getRow()][pos.getCol()] = piece;
        piece.position = pos;
    }

    private void validatePosition(int row, int col) {
        if (!positionExists(row, col)) {
            throw new BoardException("Board does not contain position " + row + ", " + col);
        }
    }

    private void validatePosition(Position pos) {
        validatePosition(pos.getRow(), pos.getCol());
    }

    public boolean positionExists(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean positionExists(Position pos) {
        return positionExists(pos.getRow(), pos.getCol());
    }

    public boolean thereIsAPiece(int row, int col) {
        validatePosition(row, col);
        return pieces[row][col] != null;
    }

    public boolean thereIsAPiece(Position pos) {
        validatePosition(pos);
        return thereIsAPiece(pos.getRow(), pos.getCol());
    }

    public Piece removePiece(Position pos) {
        if (!thereIsAPiece(pos)) {
            throw new BoardException("Board position does not contain a piece");
        }
        Piece piece = getPiece(pos);
        pieces[pos.getRow()][pos.getCol()] = null;
        return piece;
    }
}
