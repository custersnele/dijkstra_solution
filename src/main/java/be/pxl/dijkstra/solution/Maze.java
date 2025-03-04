package be.pxl.dijkstra.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Maze {
    private Graph<Cel> maze;
    private Cel start;
    private Cel end;
    private int rows;
    private int cols;

    public Maze(Path path) throws IOException {
        readFromFile(path);
    }

    public void drawMaze() {
        List<Cel> path = maze.shortestPath(start, end).getVertices();
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                Cel cel = new Cel(row, col);
                if (path.contains(cel)) {
                    System.out.print("*");
                } else if (maze.getVertices().contains(cel)) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    private void readFromFile(Path filename) throws IOException {
        maze = new Graph<>();
        List<String> lines = Files.readAllLines(filename);
        rows = lines.size();
        cols = lines.getFirst().length();

        // Convert maze to graph
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char aChar = getAChar(lines, row, col);
                if (aChar != '#') {
                    Cel current = new Cel(row, col);
                    if (aChar == 'S') {
                        start = current;
                    }
                    if (aChar == 'E') {
                        end = current;
                    }
                    maze.addVertex(current);

                    // Check adjacent cells
                    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
                    for (int[] dir : directions) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];
                        if (getAChar(lines, newRow, newCol) != '#') {
                            Cel next = new Cel(newRow, newCol);
                            maze.addVertex(next);
                            maze.addEdge(current, next, 1);
                        }
                    }
                }
            }
        }
    }

    private static char getAChar(List<String> lines, int row, int col) {
        return lines.get(row).charAt(col);
    }
}
