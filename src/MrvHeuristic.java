public class MrvHeuristic implements Heuristic {

    @Override
    public int[] findUnassignedCellCoordinates(Board board) {
        int[] coordinates = {0, 0};
        int minDomainSize = Integer.MAX_VALUE;
        for(int row = 0; row < board.sideCount(); row++) {
            for(int col = 0; col < board.sideCount(); col++) {
                int domainSize = board.getDomainSize(row, col);
                if(domainSize < minDomainSize) {
                    minDomainSize = domainSize;
                    coordinates = new int[] {row, col};
                }
            }
        }

        return coordinates;
    }

}
