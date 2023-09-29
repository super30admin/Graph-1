// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will do BFS, by maintaining a queue to store all the possible cells the ball the go in
// from one spot. When we put it in the queue, we move to all four directions and check if it 
// has reached any obstacle or boundary to make the ball stop. We will mark the cells visited
// by making the cell as 2, and would not go through it again. If we complete the queue and still 
// not reach the destination, then we return false, otherwise we return true

Class Solution
{
int[][] dirs;
int n,m;

public boolean hasPath (int [][] maze, int[]start, int [] destination)
{
    //null
    if(maze==null) return false;
    int m=maze.length, n=maze[0].length;
    //if the start is at the destination
    if(start[0]==destination[0] && start[1]==destination[1]) return true;

    this.dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    Queue <int[]> q=new LinkedList<>();

    q.add(start);   //add the starting position of the ball

    //mark the starting cell as 2
    maze[start[0]][start[1]]=2;

    while(!q.isEmpty())
    {
        int[]curr=q.poll();
        int r=curr[0];
        int c=curr[1];

        for (int [] dir: dirs)
        {
            //until the ball finds an obstacle, we need to keep moving its position
            while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
            {
                r+=dir[0];
                c+=dir[1];
            }

            //one step back
            r-=dir[0];
            c-=dir[1];

            //if we reach the destination, then we return true

            if(r==destination[0] && c==destination[1])
            {
                return true;
            }

            if(maze[r][c]!=2)
            {
                //add it to the queue
                q.add(new int[]{r,c});
                //mark it visited]
                maze[r][c]=2;

            }
        }
    }

    return false;
}
}


//dfs

Class Solution
{
int[][] dirs;
int n,m;

public boolean hasPath (int [][] maze, int[]start, int [] destination)
{
    //null
    if(maze==null) return false;
    int m=maze.length, n=maze[0].length;
    //if the start is at the destination
    if(start[0]==destination[0] && start[1]==destination[1]) return true;

    this.dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    return dfs(maze,start,destination);
}

private boolean dfs(int [][] maze, int[]curr, int [] destination)
{
    //base
    if(curr[0]==destination[0] && curr[1]==destination[1]) return true;

    if(maze[curr[0]][curr[1]]==2) return false;
    //logic

    maze[curr[0]][curr[1]]=2;
    for(int[] dir:dirs)
    {
        int r=curr[0], c=curr[1];
        while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
        {
            r+=dir[0];
            c+=dir[1];
        }

        //one step back
        r-=dir[0];
        c-=dir[1];

        int[] ne = new int[]{r,c};

        if (dfs(maze,ne,destination)) return true;
    }
    return false;
}


}

