// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I perform a modified variant of BFS starting from the start coordinates. I mark it as visited and traverse in each direction until
I hit a wall or exceed the boundaries of the grid. When such a condition happens, I undo my last step and repeat the process from 
that coordinate. If by doing so I reach the destination, I return true. Else after my queue becomes empty, I return false.
*/

public class Solution {
    public bool HasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = new int[][]
        {
            new int[] {0,1},
            new int[] {0,-1},
            new int[] {1,0},
            new int[] {-1,0}
        };

        int rows = maze.Length; 
        int columns = maze[0].Length;
        Queue<int[]> q = new();
        q.Enqueue(new int[] {start[0], start[1]});
        
        // Mark the coordinates as visited
        maze[start[0]][start[1]] = 2;

        while(q.Count != 0)
        {
            int[] temp = q.Dequeue();

            foreach(int[] dir in dirs)
            {
                
                int r = temp[0], c = temp[1];
                
                while(r>=0 && r<rows && c>=0 && c<columns && maze[r][c] != 1)
                {
                    r += dir[0];
                    c += dir[1];
                }

                r -= dir[0];
                c -= dir[1];

                if(maze[r][c] != 2)
                {
                    q.Enqueue(new int[] {r,c});
                    maze[r][c] = 2;

                    if(r == destination[0] && c == destination[1])
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}