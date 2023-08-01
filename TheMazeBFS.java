import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class TheMazeBFS {

        //BFS

        public boolean hasPath(int[][] maze, int[] start, int[] destination) {

            // true if start itself is destination
            if(start[0] == destination[0] && start[1] == destination[1]) return true;

            // four directions array
            int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // maze dimensions
            int m = maze.length;  int n = maze[0].length;

            // Queue to store position arrays containing row, column pair
            Queue<int[]> q = new LinkedList<>();     // O(M*N) space

            // add start position q
            q.add(start);

            // make start visited
            maze[start[0]][start[1]] = 2;

            // BFS run till queue is empty
            while(!q.isEmpty()) {          // O(M*N)

                // pop from queue
                int[] pop = q.poll();

                int popRow = pop[0];
                int popCol = pop[1];

                // return true if destination is the stop that is reached
                if(popRow == destination[0] && popCol == destination[1]) return true;

                // iterate over four possible directions
                for(int[] dir: dirs) {

                    // begin rolling from popped position
                    int row = popRow;
                    int col = popCol;

                    // roll within bounds from popped position until wall is hit
                    while(row >= 0 && col >= 0 && row < m && col < n
                            && maze[row][col] != 1) {        // O(K)

                        // update row and column in a directional movement
                        row += dir[0];
                        col += dir[1];
                    }

                    // retract a step to empty space from wall get back in bounds
                    row -= dir[0];
                    col -= dir[1];

                    // if not destination and not visited before, add position to queue and make it visited
                    if(maze[row][col] != 2) {

                        // newly visited position
                        q.add(new int[] {row, col});

                        maze[row][col] = 2;
                    }
                }
            }
            // if destination not reached during BFS
            return false;
        }

        public static void main(String[] args) {

            TheMazeBFS obj = new TheMazeBFS();

            Scanner scanner = new Scanner(System.in);

            System.out.println("number of rows of maze, m: ");
            int m = scanner.nextInt();

            System.out.println("number of columns of maze, n: ");
            int n = scanner.nextInt();

            int[][] maze = new int[m][n];

            for(int i = 0; i < m; i++) {

                System.out.println("row " + (i+1) + " of maze: ");

                for(int j = 0; j < n; j++) {

                    maze[i][j] = scanner.nextInt();
                }
            }

            System.out.println("start: ");
            int[] start = new int[2];

            start[0] = scanner.nextInt();
            start[1] = scanner.nextInt();

            System.out.println("destination: ");
            int[] destination = new int[2];

            destination[0] = scanner.nextInt();
            destination[1] = scanner.nextInt();

            boolean answer = obj.hasPath(maze, start, destination);

            System.out.println("Can the ball stop at the destination ? " + answer);

        }

}

/*
TIME COMPLEXITY = O(M*N) = k constant dropped in O(M * N * K)

k = 4*(m+n)

SPACE COMPLEXITY = O(M*N)

queue space = O(M*N)
*/

