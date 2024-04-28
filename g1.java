// Graph-1

// Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in=new int[n+1];
        for(int t[]:trust)
        {
            in[t[0]]--;
            in[t[1]]++;
        }
        for(int i=1;i<=n;i++)
        {
            if(in[i]==n-1)
                return i;
        }
        return -1;      
    }
}



// Problem2 The Maze (https://leetcode.com/problems/the-maze/)

// Time Complexity : O(mn(m+n))
// Space Complexity : O(mn) 
// Did this code successfully run on Leetcode : yes

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]]=2;
        int m=maze.length;
        int n=maze[0].length;
        int[][] dirs = {{-1, 0}, {1, 0},{0, -1}, {0, 1}};
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            for(int[] dir:dirs)
            {
                int r=curr[0];
                int c=curr[1];
                while(r<m && r>=0 && c<n && c>=0 && maze[r][c]!=1)
                {
                    r+=dir[0];
                    c+=dir[1];
                }
                r-=dir[0];
                c-=dir[1];
                if(r==destination[0] && c==destination[1])
                    return true;
                if(maze[r][c]!=2)
                {
                    q.add(new int[]{r,c});
                    maze[r][c]=2;
                }
            }
        }
        return false;  
    }
}



