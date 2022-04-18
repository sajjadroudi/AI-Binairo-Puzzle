package constraint;

import model.Board;
import model.Value;

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
                int whiteCount = 0;
                int blackCount = 0;
                for(int i = 0; i <= maxAcceptableAdjacentCircles; i++) {
                    var value = board.getValueOrNull(row + i, col);
                    if(value == null)
                        continue;

                    switch(value) {
                        case WHITE -> whiteCount++;
                        case BLACK -> blackCount++;
                    }
                }

                if(whiteCount > maxAcceptableAdjacentCircles || blackCount > maxAcceptableAdjacentCircles)
                    return false;

                whiteCount = blackCount = 0;
                for(int i = 0; i <= maxAcceptableAdjacentCircles; i++) {
                    var value = board.getValueOrNull(row, col + i);
                    if(value == null)
                        continue;

                    switch(value) {
                        case WHITE -> whiteCount++;
                        case BLACK -> blackCount++;
                    }
                }

                if(whiteCount > maxAcceptableAdjacentCircles || blackCount > maxAcceptableAdjacentCircles)
                    return false;
            }
        }

        return true;
    }
}
