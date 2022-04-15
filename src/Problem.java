public class Problem {

    private final Board board;

    private final ConstraintSatisfication[] constraints = {
            new AdjacencyConstraint(),
            new UniqueCellAndColumnConstraint(),
            new EqualCirclesConstraint()
    };

    public Problem(Board board) {
        this.board = board;
    }

    public SolutionResult solve(Heuristic heuristic) {
        if(board.isComplete())
            return SolutionResult.success(board);

        int[] coordinates = heuristic.findUnassignedCellCoordinates(board);
        int row = coordinates[0];
        int col = coordinates[1];

        for(Value value : board.getDomain(row, col)) {
            if(isConsistent(board, row, col, value)) {
                board.setValue(row, col, value);
                var result = solve(heuristic);
                if(result.isSuccessful())
                    return result;
            }

            board.removeValue(row, col);
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
