package core;

import model.Board;
import model.Coordinates;
import model.Value;

public class ForwardCheckingApplier {

    public boolean applyForwardChecking(Board board, Coordinates coordinates) {
        int row = coordinates.getRow();
        int col = coordinates.getCol();
        Value value = board.getValue(row, col);

        if(board.getValueOrNull(row + 1, col) == value) {
            board.removeValueFromDomain(row - 1, col, value);
            board.removeValueFromDomain(row + 2, col, value);
        }

        if(board.getValueOrNull(row - 1, col) == value) {
            board.removeValueFromDomain(row + 1, col, value);
            board.removeValueFromDomain(row - 2, col, value);
        }

        if(board.getValueOrNull(row, col + 1) == value) {
            board.removeValueFromDomain(row, col - 1, value);
            board.removeValueFromDomain(row, col + 2, value);
        }

        if(board.getValueOrNull(row, col - 1) == value) {
            board.removeValueFromDomain(row, col + 1, value);
            board.removeValueFromDomain(row, col - 2, value);
        }

        return haveAllCellsNonEmptyDomain(board);
    }

    private boolean haveAllCellsNonEmptyDomain(Board board) {
        for(int row = 0; row < board.sideCount(); row++) {
            for(int col = 0; col < board.sideCount(); col++) {
                if(!board.isDefault(row, col) && board.getDomainSize(row, col) == 0)
                    return false;
            }
        }

        return true;
    }

}
