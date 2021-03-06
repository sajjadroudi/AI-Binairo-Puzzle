package model;

public class Board {

    private final Cell[][] board;

    public Board(int n) {
        board = new Cell[n][n];

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    public int sideCount() {
        return board.length;
    }

    public Cell get(int row, int col) {
        return board[row][col];
    }

    public void set(int row, int col, Cell cell) {
        board[row][col] = cell;
    }

    public Value getValue(int row, int col) {
        return board[row][col].getValue();
    }

    public Value getValueOrNull(int row, int col) {
        try {
            return getValue(row, col);
        } catch (Exception e) {
            return null;
        }
    }

    public void setValue(int row, int col, Value value) {
        board[row][col].setValue(value);
    }

    public void removeValue(int row, int col) {
        setValue(row, col, null);
    }

    public void addValueToDomain(int row, int col, Value value) {
        board[row][col].addToDomain(value);
    }

    public void removeValueFromDomain(int row, int col, Value value) {
        if(isValidCoordinates(row, col) && !isDefault(row, col)) {
            board[row][col].removeFromDomain(value);
        }
    }

    public Value[] getDomain(int row, int col) {
        return board[row][col].getDomain();
    }

    public int getDomainSize(int row, int col) {
        return getDomain(row, col).length;
    }

    public boolean isDefault(int row, int col) {
        return board[row][col].isDefault();
    }

    public boolean isComplete() {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(!board[row][col].hasValue())
                    return false;
            }
        }

        return true;
    }

    public Board copy() {
        Board copy = new Board(sideCount());
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                copy.board[row][col] = board[row][col].copy();
            }
        }
        return copy;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                builder.append(cell).append(" ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    private boolean isValidCoordinates(int row, int col) {
        return row < sideCount() && row >= 0 && col < sideCount() && col >= 0;
    }
}
