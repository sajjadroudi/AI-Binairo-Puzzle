public class MrvHeuristic implements Heuristic {

    public Coordinates findUnassignedCellCoordinates(Board board) {
        Coordinates coordinates = null;
        int minDomainSize = Integer.MAX_VALUE;
        for(int row = 0; row < board.sideCount(); row++) {
            for(int col = 0; col < board.sideCount(); col++) {
                int domainSize = board.getDomainSize(row, col);
                if(domainSize < minDomainSize && domainSize != 0) {
                    minDomainSize = domainSize;
                    coordinates = new Coordinates(row, col);
                }
            }
        }

        return coordinates;
    }

}
