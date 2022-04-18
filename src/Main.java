import core.ProblemSolver;
import model.Board;
import model.Cell;
import model.SolutionResult;
import model.Value;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File input = new File("inputs/input3.txt");
        Board board = null;
        try {
            Scanner reader = new Scanner(input);
            int n = reader.nextInt();
            board = new Board(n);

            int m = reader.nextInt();
            for (int i = 0; i < m; i++) {
                int row = reader.nextInt();
                int col = reader.nextInt();
                int intValue = reader.nextInt();
                Value value = switch (intValue) {
                    case 0 -> Value.WHITE;
                    case 1 -> Value.BLACK;
                    default -> throw new IllegalStateException();
                };
                board.set(row, col, new Cell(value));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ProblemSolver solver = new ProblemSolver();
        long startTime = System.currentTimeMillis();
        SolutionResult result = solver.solve(board);
        long diff = System.currentTimeMillis() - startTime;
        System.out.println(result);
        System.out.println(diff);
    }

}
