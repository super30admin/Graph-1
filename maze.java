// Time Complexity : O(mn)
// Space Complexity : O(mn)
//BFS
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0) return false;
        int m=maze.length; int n=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]]=2;
        int[][] dirs={{0,1},{0,-1},{-1,0},{-1,-1}};
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            if(curr[0]==destination[0] && curr[1]==destination[1]) return true;
            for(int[] dir:dirs)
            {
                int r=curr[0]; int c=curr[1];
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
                {
                    r+=dir[0]; c+=dir[1];
                }
                r-=dir[0];c-=dir[1];
                if(maze[r][c]!=2)
                {
                    maze[r][c]=2;
                    q.add(new int[]{r,c});
                }
            }
            
        }
        return false;
    }
}

//DFS
TC:O(m*n) m*n = size of maze
SC: stack space
public class Solution {
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0) return false;
        maze[start[0]][start[1]]=2;
        dirs={{0,1},{0,-1},{-1,0},{-1,-1}};
        return dfs(maze,start,destination);
    }
    public boolean dfs(int[][] maze, int[] start, int[] destination)
    {
        if(start[0]==destination[0] && start[1]==destination[1]) return true;
        
        for(int[] dir:dirs)
        {
            int r=start[0];
            int c=start[1];
            while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]!=1)
            {
                r+=dir[0];
                c+=dir[1];
            }
            r-=dir[0];
            c-=dir[1];
            if(maze[r][c]!=2)
            {
                maze[r][c]=2;
                if(dfs(maze,new int[]{r,c},destination)) return true;
            }
            
            
        }
        return false;
    }
}