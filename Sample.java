# GRAPH-1 problems

Problem 1:Find the Town Judge
(https://leetcode.com/problems/find-the-town-judge/submissions/)
// Time Complexity : O(V+E) //
// Space Complexity : O(V) //
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Method #1:
class Solution {
    public int findJudge(int N, int[][] trust) {
        //[1,2]
        //index:  0,1
        //people: 1,2
        int[] indegree = new int[N];
        for(int[] t: trust){
            indegree[t[0]-1]--;
            indegree[t[1]-1]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==N-1){
                return i+1;
            }
        }
        return -1;
    }
}


Problem 2: The Maze
(https://leetcode.com/problems/the-maze/submissions/)
// Time Complexity : O(M*N) //
// Space Complexity : O(M*N) //
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Method #1: BFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        int dirs[][] = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]]=2;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==destination[0] && curr[1]==destination[1]) return true;
            for(int[] dir: dirs){
                int i=curr[0]; int j=curr[1];
                while(i>=0 && j>=0 && i<maze.length && j<maze[0].length && maze[i][j]!=1){
                    i+=dir[0];
                    j+=dir[1];
                }
                i-=dir[0]; j-=dir[1];
                if(maze[i][j]!=2){
                    q.add(new int[]{i, j});
                    maze[i][j]=2;
                }
            }
        }
    return false;
    }
}