//o(v+e) time and o(n) space

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n + 1];
        for(int[] t: trust){
            indegrees[t[0]]--;
            indegrees[t[1]]++;
        }
        for(int i = 1; i < indegrees.length; i++){
            if(indegrees[i] == n -1){
                return i;
            }

        }
        return -1;

    }
}

//o(m * n ) * max(m,n) and space is o(m + n) for queue
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) return false;
        int m = maze.length; int n = maze[0].length;
        Queue<int []> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        int [][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int i =  curr[0]; int j = curr[1];
                while( i < m && j < n && i >=0 && j >=0 && maze[i][j] != 1){
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j-= dir[1];
                if(maze[i][j] == 0){
                    maze[i][j] = 2;
                    if(destination[0] == i && destination[1] == j) return true;
                    q.add(new int[] {i,j});

                }

            }
        }
        return false;
    }
}