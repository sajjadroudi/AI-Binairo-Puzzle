import java.util.List;

public class LcvHeuristic implements Heuristic {

    public List<Value> findAppropriateValue(Board board, Coordinates coordinates) {
        Value[] domain = board.getDomain(coordinates.getRow(), coordinates.getCol());
        return switch (domain.length) {
            case 0 -> List.of();
            case 1 -> List.of(domain[0]);
            default -> List.of(domain); // TODO
        };
    }

}
