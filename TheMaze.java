// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Approach : We perfrom BFS and explore the path of not crossing boundaries and not hitting the wall. We maintain a queue and add the start position to the queue first. Then explore all
// four directions from that point and check if we crossed the boundaries or hit the wall. If we hit the wall, we step back, add to queue if not previously visited and mark it visited.
// When we stop, we check if it is destination index and return true else continue to explore until queue is empty, that means processing of all indexes is done.

class Solution {
    int[][] dirs;
    int m,n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}}; //all four directions array
        this.m = maze.length;
        this.n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();//using queue to perform BFS
        q.add(new int[]{start[0], start[1]});//add the start point to the queue to start processing
        maze[start[0]][start[1]] = 2; //mark it as visited by updating with 2

        while(!q.isEmpty()){
            int[] curr = q.poll(); //process current row-column index
            for(int[] dir: dirs){ //explore all four directions
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1){ //bounds hit and not the wall check
                    r += dir[0];
                    c += dir[1];
                }

                r -= dir[0];//step back because we either crossed the bounds or hit the wall
                c -= dir[1];

                if(r == destination[0] && c == destination[1]) return true; //reached destination point
                if(maze[r][c] != 2){ //if not visited
                    q.add(new int[]{r,c}); //add to queue
                    maze[r][c] = 2; //make it visited
                }
            }
        }

        return false;
    }
}
