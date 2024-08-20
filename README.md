# Graph-1

## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

Explain approach in 3 lines: Simple approach here is we are creating an array of indegrees where we are storing indegrees such that suppose person i is trusting person j then we are decreasing the indegree of person i and increasing the indegree of person j. In this way at the end town judge will have n-1 degrees as everyone trusts town judge and as his indegrees has never been decreased that means he does not trust anyone. 

Time complexity: O(V+E) where V is number of people and E is sides array given in the problem.

Space complexity: O(V) where we are storing in-degrees of all the people.

Approached Code: 

class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] indegrees = new int[n+1];

        for(int[] edges: trust) {
            indegrees[edges[0]]--;
            indegrees[edges[1]]++;
        }

        for(int i = 1; i <= n; i++) {
            if(indegrees[i] == n-1) {
                return i;
            }
        }

        return -1;

    }
}



## Problem2 The Maze (https://leetcode.com/problems/the-maze/)

Explain approach in 3 lines: Simple approach here is we will insert the starting position of ball in a queue and mark it visited. Then we will traverse up down left and right using directions array and we will move the ball until we hit wall (1) and add that position in a queue and mark it visited. We will repeat this process for all the elements in the queue and if we find a final destination added in the queue we will return true and stop there otherwise after exploring all the paths if we do not stop at destination we will return false. Same thing we can do it with DFS with recursive calls.

Time complexity: O(m*n) where m*n is a size of matrix as even though we are writing multiple for and while loops still the elements we are traversing in this logic will be m*n in worst case scenario.

Space complexity: O(m*n) as we will be storing the elements we are traversing in a queue for BFS.

Approached Code: 

class Solution {
    boolean flag = false;
    int[][] dirs;
    int m;
    int n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        this.dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        this.m = maze.length;
        this.n = maze[0].length;

        // BFS Approach

        // Queue<int []> queue = new LinkedList<>();

        // queue.add(start);

        // maze[start[0]][start[1]] = 2;

        // while(!queue.isEmpty()) {
        //     int[] curr = queue.poll();

        //     for(int [] dir : dirs) {
        //         int r = curr[0];
        //         int c = curr[1];

        //         while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) {
        //             r += dir[0];
        //             c += dir[1];
        //         }

        //         r -= dir[0];
        //         c -= dir[1];

        //         if(r == destination[0] && c == destination[1]) {
        //             return true;
        //         }

        //         if(maze[r][c] != 2) {
        //             queue.add(new int[] {r, c});
        //             maze[r][c] = 2;
        //         }
        //     }
        // }

        // return false;



        // DFS Approach

        dfs(maze, start, destination);
        return flag;

    }

    private void dfs(int[][] maze, int[] start, int[] destination) {
        // base
        if(maze[start[0]][start[1]] == 2) return;

        // logic
        if(start[0] == destination[0] && start[1] == destination[1]) {
            flag = true;
            return;
        }

        maze[start[0]][start[1]] = 2;

        for(int[] dir : dirs) {
            int r = start[0];
            int c = start[1];

            while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }

            r -= dir[0];
            c -= dir[1];

            if(!flag) {
                dfs(maze, new int[] {r, c}, destination);
            }
            
        }
    }
}