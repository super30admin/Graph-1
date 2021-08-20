//Time complexity: O(m*n), where m*n is the size of the maze.
//Space complexity: O(m*n)

import java.util.*;

class Solution2 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; 
        int n = maze[0].length; 
        
        int directions[][] = {{-1,0},{0,-1},{0,1},{1,0}};
        
        Queue<Integer> q = new LinkedList<>(); 
        HashSet<Integer> set = new HashSet<>(); 
        int startPosition = start[0] * n + start[1]; 
        q.offer(startPosition);
        set.add(startPosition);
        
        //bfs
        while(!q.isEmpty()) {
            int position = q.poll();
            int i = position/n;
            int j = position%n;
            if(i == destination[0] && j == destination[1]) {
                return true;
            }
            for(int d=0; d<4; d++) {
                int newi = i; 
                int newj = j;
                while(newi >=0 && newi < m && newj >=0 && newj < n && maze[newi][newj] == 0) {
                    newi += directions[d][0];
                    newj += directions[d][1];
                }
                newi -= directions[d][0];
                newj -= directions[d][1];
                int newposition = newi*n+newj;
                if(!set.contains(newposition)) {
                    q.offer(newposition);
                    set.add(newposition);
                }
            }
        }
        return false;
    }
}