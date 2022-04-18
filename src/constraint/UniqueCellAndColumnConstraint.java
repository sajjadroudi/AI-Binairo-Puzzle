package constraint;

import model.Board;

public class UniqueCellAndColumnConstraint implements ConstraintSatisfication {

    @Override
    public boolean doesSatisfy(Board board) {
        return areRowsValid(board) && areColumnsValid(board);
    }

    private boolean areColumnsValid(Board board) {
        for(int firstColumn = 0; firstColumn < board.sideCount(); firstColumn++) {
            for(int secondColumn = firstColumn + 1; secondColumn < board.sideCount(); secondColumn++) {
                if(areColumnsEqual(board, firstColumn, secondColumn))
                    return false;
            }
        }

        return true;
    }

    private boolean areColumnsEqual(Board board, int firstColumn, int secondColumn) {
        for(int row = 0; row < board.sideCount(); row++) {
            if(board.get(row, firstColumn) != board.get(row, secondColumn))
                return false;
        }

        return true;
    }

    private boolean areRowsValid(Board board) {
        for(int firstRow = 0; firstRow < board.sideCount(); firstRow++) {
            for(int secondRow = firstRow + 1; secondRow < board.sideCount(); secondRow++) {
                if(areRowsEqual(board, firstRow, secondRow))
                    return false;
            }
        }

        return true;
    }

    private boolean areRowsEqual(Board board, int firstRow, int secondRow) {
        for(int col = 0; col < board.sideCount(); col++) {
            if(board.get(firstRow, col) != board.get(secondRow, col))
                return false;
        }

        return true;
    }

}
