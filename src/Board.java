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

    public Cell get(int row, int col) {
        return board[row][col];
    }

    public void set(int row, int col, Cell cell) {
        board[row][col] = cell;
    }

    public Value getValue(int row, int col) {
        return board[row][col].getValue();
    }

    public void setValue(int row, int col, Value value) {
        board[row][col].setValue(value);
    }

    public void addValueToDomain(int row, int col, Value value) {
        board[row][col].addToDomain(value);
    }

    public void removeValueFromDomain(int row, int coll, Value value) {
        board[row][coll].removeFromDomain(value);
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                builder.append(cell).append(" ");
            }
            builder.append(Constants.LINE);
        }

        return builder.toString();
    }
}
