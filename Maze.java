// Time Complexity : O(V+E)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes. 
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach: 
Approached this problem using dfs and at each step we are traversing untill we reach boundary.

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(null == maze || 0 == maze.length){return true;}
        boolean visited[][] = new boolean[maze.length][maze[0].length];
        return helper(maze,start,destination,visited);
    }
    private boolean helper(int[][] maze, int[] start, int[] dest, boolean[][] visited){
        if(visited[start[0]][start[1]]){return false;}
        if(start[0] == dest[0] && start[1] == dest[1]){return true;}
        visited[start[0]][start[1]] = true;
        int l = start[1]-1, r = start[1] + 1, u = start[0] - 1, d = start[0] + 1;
        int temp = start[1];
        while(l>= 0 && maze[start[0]][l] == 0){
            start[1] = l;
            l--;
        }
        if(helper(maze,start,dest,visited)){return true;}
        start[1] = temp;
        while(r<maze[0].length && maze[start[0]][r] == 0){
            start[1] = r;
            r++;
        }
        if(helper(maze,start,dest,visited)){return true;}
        start[1] = temp;
        temp = start[0];
        while(u >= 0 && maze[u][start[1]] == 0){
            start[0] = u;
            u--;
        }
        if(helper(maze,start,dest,visited)){return true;}
        start[0] = temp;
        while(d < maze.length && maze[d][start[1]] == 0){
            start[0] = d;
            d++;
        }
        if(helper(maze,start,dest,visited)){return true;}
        start[0] = temp;
    return false;
    }
}