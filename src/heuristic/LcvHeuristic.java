package heuristic;

import core.ForwardCheckingApplier;
import model.Board;
import model.Coordinates;
import model.Value;

import java.util.List;

public class LcvHeuristic implements Heuristic {

    public List<Value> findAppropriateValue(Board board, Coordinates coordinates) {
        Value[] domain = board.getDomain(coordinates.getRow(), coordinates.getCol());
        if(domain.length == 0) {
            return List.of();
        } else if(domain.length == 1) {
            return List.of(domain[0]);
        } else {
            int white = put(board.copy(), coordinates, Value.WHITE);
            int black = put(board.copy(), coordinates, Value.BLACK);

            if(white > black) {
                return List.of(Value.WHITE, Value.BLACK);
            } else {
                return List.of(Value.BLACK, Value.WHITE);
            }
        }
    }

    private int put(Board board, Coordinates coordinates, Value value) {
        board.setValue(coordinates.getRow(), coordinates.getCol(), value);

        var forwardChecking = new ForwardCheckingApplier();
        forwardChecking.applyForwardChecking(board, coordinates);

        int allDomainSize = 0;
        for(int row = 0; row < board.sideCount(); row++) {
            for(int col = 0; col < board.sideCount(); col++) {
                if(board.getValueOrNull(row, col) == null) {
                    allDomainSize += board.getDomainSize(row, col);
                }
            }
        }

        return allDomainSize;
    }

}
