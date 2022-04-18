package model;

public class SolutionResult {

    private final Board board;

    public SolutionResult(Board board) {
        this.board = board;
    }

    public boolean isSuccessful() {
        return board != null;
    }

    public boolean isFailed() {
        return !isSuccessful();
    }

    public static SolutionResult success(Board board) {
        return new SolutionResult(board);
    }

    public static SolutionResult failure() {
        return new SolutionResult(null);
    }

    @Override
    public String toString() {
        if(isFailed())
            return "No solution!";

        return board.toString();
    }
}
