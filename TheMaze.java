/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public boolean hasPath(int[][] maze, int[] start, int[] destination) 
    {
        
        int rows = maze.length;
        int cols = maze[0].length;
        
        Pair dest = new Pair(destination[0], destination[1]);
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start[0], start[1]));
        maze[start[0]][start[1]] = 2;
        
        int dirs[][] ={{1,0},{-1,0}, {0,1}, {0,-1}};
        
        
        while(!queue.isEmpty())
        {
            Pair current = queue.poll();
            
            boolean destinationReached = current.equals(dest);
            
            if(destinationReached)
                return true;
            else
            {
                for(int dir[]: dirs)
                {
                    int row = current.x;
                    int col = current.y;
                    
                    while(row >=0 && row < rows && col >=0 && col < cols && maze[row][col] !=1)
                    {
                        row = row + dir[0];
                        col = col + dir[1];
                    }
                    
                    row = row - dir[0];
                    col = col - dir[1];
                    
                    if(maze[row][col] != 2)
                    {
                        Pair newPair = new Pair(row, col);
                        maze[row][col] = 2;
                        queue.add(newPair);
                    }
                }
            }
        }
        
        return false;
        
    }
    
    class Pair 
    {
        int x;
        int y;
        
        public Pair(int x, int y)
        {
            this.x =x;
            this.y = y;
        }
        
        public boolean equals(Object obj)
        {
            Pair pair = (Pair)obj;
            
            return this.x == pair.x && this.y == pair.y;
        }
    }
}