import java.util.LinkedList;
import java.util.Queue;

/*
Time Complexity: O(m*n) m is the number of rows in the maze and n is the number of cols in the maze
Space Complexity: O(m*n) size of the queue to iterate over the given maze box
Run on leetcode: yes
Any difficulties: No

Approach:
1. In this problem when the ball hit wall it can bounce to either of the directions up, down, left, and right
2. I am using Breadth first search to traverse the maze and starting from the start index trying to reach destination
by adding direction in the start index
 */
public class TheMaze {
    public static int[][] directions = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    public static boolean theMaze(int[][] maze, int[] start, int[] destination){
        boolean[][] visitedBox = new boolean[maze.length][maze[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int[] currentBox = queue.remove();
            if(currentBox[0] == destination[0] && currentBox[1] == destination[1]){
                return true;
            }
            for(int[] dir: directions) {
                int dirX = currentBox[0] + dir[0];
                int dirY = currentBox[1] + dir[1];

                while (dirX >= 0 && dirX < maze.length && dirY >= 0 && dirY < maze[0].length && maze[dirX][dirY] == 0) {
                    dirX += dir[0];
                    dirY += dir[1];
                }
                if (!visitedBox[dirX - dir[0]][dirY - dir[1]]) {
                    queue.add(new int[]{dirX - dir[0], dirY - dir[1]});
                    visitedBox[dirX - dir[0]][dirY - dir[1]] = true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };

        int start[] = {0,4};
        int destination[] = {4,4};
        System.out.println("Will ball reach to the destination: "+ theMaze(maze, start, destination));
    }
}
