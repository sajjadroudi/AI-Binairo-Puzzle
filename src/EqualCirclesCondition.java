public class EqualCirclesCondition implements ConditionSatisfication {

    @Override
    public boolean doesSatisfy(Board board) {
        for(int row = 0; row < board.sideCount(); row++) {
            int blackCircleCount = 0;
            int whiteCircleCount = 0;
            for(int col = 0; col < board.sideCount(); col++) {
                Value value = board.getValue(row, col);
                switch (value) {
                    case WHITE -> whiteCircleCount++;
                    case BLACK -> blackCircleCount++;
                }
            }

            int emptyCount = board.sideCount() - blackCircleCount - whiteCircleCount;

            int difference = Math.abs(blackCircleCount - whiteCircleCount);

            if(difference != emptyCount)
                return false;
        }
        return true;
    }

}
