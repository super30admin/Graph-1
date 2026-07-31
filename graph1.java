//problem1
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr=new int[n];
        for(int[] t:trust){
            arr[t[0]-1]--;
            arr[t[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(arr[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}
//problem2
import java.util.*;

class Main {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = -1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == destination[0] &&
                curr[1] == destination[1])
                return true;
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                while (r >= 0 && r < m &&
                       c >= 0 && c < n &&
                       maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if (maze[r][c] != -1) {
                    maze[r][c] = -1;
                    q.add(new int[]{r, c});
                }
            }
        }
        return false;
    }
}
