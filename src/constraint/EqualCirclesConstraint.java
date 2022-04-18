package constraint;

import model.Board;
import model.Value;

public class EqualCirclesConstraint implements ConstraintSatisfication {

    @Override
    public boolean doesSatisfy(Board board) {
        for(int row = 0; row < board.sideCount(); row++) {
            int blackCircleCount = 0;
            int whiteCircleCount = 0;
            for(int col = 0; col < board.sideCount(); col++) {
                Value value = board.getValueOrNull(row, col);
                if(value == null)
                    continue;

                switch (value) {
                    case WHITE -> whiteCircleCount++;
                    case BLACK -> blackCircleCount++;
                }
            }

            int half = board.sideCount() / 2;
            if(blackCircleCount > half || whiteCircleCount > half)
                return false;
        }
        return true;
    }

}
