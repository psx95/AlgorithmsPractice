import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class RobotInGrid {

    private static Set<Point> failedPoints = new HashSet<>();

    public static void main(String args[]) {

    }

    public static ArrayList<Point> getPath(boolean[][] maze) {
        ArrayList<Point> path = new ArrayList<>();
        pathHelper(maze, path, maze.length - 1, maze[0].length - 1);
        return path;
    }

    /**
     * This function tests if a Point - (row, column) in the maze is viable to be
     * used as a Point in our path
     * 
     * @param maze    - The maze that needs to be navigated.
     * @param pathAcc - The path accumulator. This is path that has been figured out
     *                so far.
     * @param row     - The current row that needs to be tested for a viable Path.
     * @param column  - The current column that needs to be tested for a viable
     *                Path.
     * @return a boolean indicating if {@code maze[row][column]} should be included
     *         in the final Path.
     */
    private static boolean pathHelper(boolean[][] maze, ArrayList<Point> pathAcc, int row, int column) {
        // base case
        if (row < 0 || column < 0 || row >= maze.length || column >= maze[0].length || !maze[row][column]) {
            return false;
        }
        // the current row column is valid and not an obstacle
        Point p = new Point(row, column); // create Point to test its viability

        // was this point earlier tested and failed ?
        if (failedPoints.contains(p)) {
            // yes, so no need to further compute
            return false;
        }

        // now recurse the two possible ways - down & right
        if ((row == 0 && column == 0) || pathHelper(maze, pathAcc, row, column - 1)
                || pathHelper(maze, pathAcc, row - 1, column)) {
            pathAcc.add(p);
            return true;
        } else {
            failedPoints.add(p);
            return false;
        }
    }

    // uses a cache Point to Boolean mapping to get viability of the Point
    private static boolean pathHelperOptimised(boolean[][] maze, ArrayList<Point> pathAcc, int row, int column,
            HashMap<Point, Boolean> cache) {
        if (row < 0 || column < 0 || row >= maze.length || column >= maze[0].length || !maze[row][column]) {
            return false;
        }
        Point p = new Point(row, column);

        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        boolean success = false;
        if ((row == 0 && column == 0) || pathHelperOptimised(maze, pathAcc, row, column - 1, cache)
                || pathHelperOptimised(maze, pathAcc, row - 1, column, cache)) {
            pathAcc.add(p);
            success = true;
        }
        cache.put(p, success);
        return success;
    }

    private static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}