package core;

import constraint.AdjacencyConstraint;
import constraint.ConstraintSatisfication;
import constraint.EqualCirclesConstraint;
import constraint.UniqueCellAndColumnConstraint;
import heuristic.LcvHeuristic;
import heuristic.MrvHeuristic;
import model.Board;
import model.SolutionResult;
import model.Value;
import utils.NoSolutionException;

public class ProblemSolver {

    private final ConstraintSatisfication[] constraints = {
            new AdjacencyConstraint(),
            new UniqueCellAndColumnConstraint(),
            new EqualCirclesConstraint()
    };

    private final MrvHeuristic mrvHeuristic = new MrvHeuristic();
    private final LcvHeuristic lcvHeuristic = new LcvHeuristic();
    private final ForwardCheckingApplier forwardCheckingApplier = new ForwardCheckingApplier();

    public SolutionResult solve(Board board) {
        if(board.isComplete())
            return SolutionResult.success(board);

        try {
            var coordinates = mrvHeuristic.findUnassignedCellCoordinates(board);
            int row = coordinates.getRow();
            int col = coordinates.getCol();

            for(Value value : lcvHeuristic.findAppropriateValue(board, coordinates)) {
                if(isConsistent(board, row, col, value)) {
                    board.setValue(row, col, value);

                    var boardCopy = board.copy();
                    boolean canContinue = forwardCheckingApplier.applyForwardChecking(boardCopy, coordinates);
                    if(canContinue) {
                        var result = solve(boardCopy);
                        if(result.isSuccessful())
                            return result;
                    }
                }

                board.removeValue(coordinates.getRow(), coordinates.getCol());
            }
        } catch (NoSolutionException ex) {
            ex.printStackTrace();
        }

        return SolutionResult.failure();
    }

    private boolean isConsistent(Board board, int row, int col, Value value) {
        board.setValue(row, col, value);

        for(var constraint : constraints) {
            if(!constraint.doesSatisfy(board))
                return false;
        }

        board.removeValue(row, col);

        return true;
    }

}
