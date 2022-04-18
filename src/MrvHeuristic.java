public class MrvHeuristic implements Heuristic {

    public Coordinates findUnassignedCellCoordinates(Board board) {
        Coordinates coordinates = null;
        int minDomainSize = Integer.MAX_VALUE;
        for(int row = 0; row < board.sideCount(); row++) {
            for(int col = 0; col < board.sideCount(); col++) {
                if(board.getValueOrNull(row, col) != null)
                    continue;

                int domainSize = board.getDomainSize(row, col);

                if(domainSize == 0)
                    throw new NoSolutionException();

                if(domainSize < minDomainSize) {
                    minDomainSize = domainSize;
                    coordinates = new Coordinates(row, col);
                }
            }
        }

        return coordinates;
    }

}
