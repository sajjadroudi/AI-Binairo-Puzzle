package heuristic;

import model.Board;
import model.Coordinates;
import utils.NoSolutionException;

public class MrvHeuristic implements Heuristic {

    public Coordinates findUnassignedCellCoordinates(Board board) {
        Coordinates coordinates = null;

        for(int row = 0; row < board.sideCount(); row++) {
            for(int col = 0; col < board.sideCount(); col++) {
                if(board.getValueOrNull(row, col) != null)
                    continue;

                int domainSize = board.getDomainSize(row, col);

                if(domainSize == 0)
                    throw new NoSolutionException();

                coordinates = new Coordinates(row, col);
                if(domainSize == 1)
                    return coordinates;
            }
        }

        return coordinates;
    }

}
