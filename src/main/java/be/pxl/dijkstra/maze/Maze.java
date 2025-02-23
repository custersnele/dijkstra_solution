package be.pxl.dijkstra.maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Maze {
    // create Graph<Cel> maze;
    private Cel start;
    private Cel end;
    private int rows;
    private int cols;

    public Maze(Path path) throws IOException {
        readFromFile(path);
    }

    public void drawMaze() {
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private void readFromFile(Path filename) throws IOException {
        List<String> lines = Files.readAllLines(filename);
        rows = lines.size();
        cols = lines.getFirst().length();

        // Convert maze to graph
    }

    private static char getAChar(List<String> lines, int row, int col) {
        return lines.get(row).charAt(col);
    }
}
