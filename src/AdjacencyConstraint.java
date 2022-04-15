import java.util.HashSet;
import java.util.Set;

public class AdjacencyConstraint implements ConstraintSatisfication {

    private final int maxAcceptableAdjacentCircles;

    public AdjacencyConstraint(int maxAcceptableAdjacentCircles) {
        this.maxAcceptableAdjacentCircles = maxAcceptableAdjacentCircles;
    }

    public AdjacencyConstraint() {
        this(2);
    }

    @Override
    public boolean doesSatisfy(Board board) {
        for(int row = 0; row < board.sideCount(); row++) {
            for(int col = 0; col < board.sideCount(); col++) {
                Set<Cell> cells = new HashSet<>();
                for(int i = 0; i <= maxAcceptableAdjacentCircles; i++) {
                    var value = board.get(row + i, col);
                    if(value != null)
                        cells.add(value);
                }

                if(cells.size() == 1)
                    return false;

                cells.clear();
                for(int i = 0; i <= maxAcceptableAdjacentCircles; i++) {
                    var value = board.get(row, col + i);
                    if(value != null)
                        cells.add(value);
                }

                if(cells.size() == 1)
                    return false;
            }
        }

        return true;
    }
}
