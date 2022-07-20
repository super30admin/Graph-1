TC:O(m*n*k) - k is some constant 
SC:O(m*n) - max queue size
succeffully run on leetcode

used BFS Approach to meet the destination. added to queue only if the cell is not visited and the traversal
of the ball is stopped only if we hit 1 or boundary

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
     int [][]dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if(maze.length==0) return false;
        dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int []>q = new LinkedList<>();
        q.add(start);
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        maze[start[0]][start[1]] = 2;//marked it visited 
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for(int [] dir:dirs){
                int i = cur[0],j=cur[1];
                while(i < maze.length && i >=0 && j<maze[0].length && j>=0 && maze[i][j] != 0){
                    i=i+dir[0];
                    j=j+dir[1];
                    if(i == destination[0] && j==destination[1]) return true;
                }
                int []newstop = new int[2];
                newstop[0] = i-dir[0];
                newstop[1] = j-dir[1];
                if(maze[newstop[0]][newstop[1]]!=2) q.add(newstop);
                else maze[newstop[0]][newstop[1]] = 2;
                
            }
        }
        return false;
    }
}