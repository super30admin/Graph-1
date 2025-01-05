# Graph-1

## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)
## Time Complexity:O(N)+O(L)  Space Complexity:O(N) 
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees=new int[n+1];


        for(int[] tr:trust){
            indegrees[tr[0]]--;
            indegrees[tr[1]]++;
        }
    

    for(int i=1;i<=n;i++)
    {
        if(indegrees[i] == n-1) return i;

    }
    return -1;
    }
}

## Problem2 The Maze (https://leetcode.com/problems/the-maze/)
## Time Complexity:O(mxn) Space Complexity:O(mxn)
class Solution{
    int[][] dirs;
    int m,n;

    public boolean hasPath(int[][] maze,int[] start,int[] destination){
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m=maze.length;
        this.n=maze[0].length;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]]=-1;


        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] dir:dirs){
                int r=dir[0]+curr[0];
                int c=dir[1]+curr[1];


                while(r>=0 && c>=0 && r<n && c<n && maze[r][c]!=1)
                {
                    r+=dir[0];
                    c+=dir[1];
                }
                r-=dir[0];
                c-=dir[1];

                if(r==destination[0] && c==destination[1]) return true;


                if(maze[r][c]!=-1)
                {
                    q.add(new int[]{r,c});
                    maze[r][c]=-1;
                }


            }
        }

        return false;
    }
}


