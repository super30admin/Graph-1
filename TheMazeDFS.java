import java.util.Scanner;

public class TheMazeDFS {

        // DFS - TIME O(M*N) AND SPACE O(M*N)

        int[][] dirs;
        private int m;
        private int n;

        public boolean hasPath(int[][] maze, int[] start, int[] destination) {

            // true if start itself is destination
            if(start[0] == destination[0] && start[1] == destination[1]) return true;

            // four directions array
            dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // maze dimensions
            m = maze.length;  n = maze[0].length;

            return dfs(maze, start, destination);
        }

        private boolean dfs(int[][] maze, int[] curr, int[] destination) {

            // base
            // destination reached
            if(curr[0] == destination[0] && curr[1] == destination[1])   return true;

            // not a destination if already visited
            if(maze[curr[0]][curr[1]] == 2)            return false;

            // logic
            //action
            // make it visited
            maze[curr[0]][curr[1]] = 2;

            for(int[] dir: dirs) {

                int row = curr[0]; int col = curr[1];

                // roll until wall
                while(row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != 1) {

                    row += dir[0];
                    col += dir[1];
                }

                // retract to get in bounds
                row -= dir[0];
                col -= dir[1];

                // call dfs at stop
                if(dfs(maze, new int[] {row, col}, destination)) return true;
            }

            return false;
        }

        public static void main(String[] args) {

            TheMazeDFS obj = new TheMazeDFS();

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

recursive stack space = O(M*N)
*/