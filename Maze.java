package Graph-1;
// Time : O(m*n) where m and n are dimensions of the maze
// space : O(m*n) // Queue
public class Maze {
    class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            
            if(maze == null || maze.length==0) return false;
            int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            Queue<int[]> q = new LinkedList<int[]>();
            q.add(start);
            maze[start[0]][start[1]] = 2;
            int m = maze.length;
            int n = maze[0].length;
            while(!q.isEmpty())
            {
                int size = q.size();
                for(int k=0;k<size;k++)
                {
                    int [] curr = q.poll();
                    if(curr[0]==destination[0] && curr[1]==destination[1])
                    {
                        return true;
                    }
                    for(int [] dir : dirs)
                    {
                        int i=curr[0];
                        int j =curr[1];
                        maze[i][j] = 2;
                        while(i<m && j<n && i>=0 && j>=0 && maze[i][j]!=1)
                        {
                            i+=dir[0];
                            j+=dir[1];
                        }
                        i-=dir[0];
                        j-=dir[1];
                        if(maze[i][j]!=2)
                        {
                            q.add(new int[]{i,j});
                        }
                    }
                }
            }
            return false;
        }
    }    
}
