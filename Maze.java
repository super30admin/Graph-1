import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
/*
 * Approach 1 - BFS
 * 1 - The idea is to perform BFS. Remember the child nodes of any node would be the node before node 1.
 * 2- BFS begins from the start point and we iterate until the hurdle is reached. Once the hurdle is reached, we take a step
 * back and add that node into the queue.
 * 3 - We check if this node is the destination. If yes, return true.
 * 4 - Remember, we also are marking the visited nodes as 2 in this problem.
 */

public class Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        
        q.add(start);
        maze[start[0]][start[1]] = 2;
        
        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            for(int[] dir:dirs)
            {
                int i = curr[0];
                int j = curr[1];
            
                while(i >= 0 && j>=0 && i < m && j < n && maze[i][j] != 1)
                {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                
                if(maze[i][j] != 2)
                {
                    if(i == destination[0] && j == destination[1])
                    {
                        return true;
                    }
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}
