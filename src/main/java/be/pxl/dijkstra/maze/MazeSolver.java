package be.pxl.dijkstra.maze;

import java.io.IOException;
import java.nio.file.Path;

public class MazeSolver {

    public static void main(String[] args) throws IOException {
        Maze maze = new Maze(Path.of("src/main/resources/maze.txt"));
        maze.drawMaze();
    }
}
