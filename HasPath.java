// Time Complexity : The time complexity is O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity if O(m*n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        Queue<Integer> q = new LinkedList<>();
        q.offer(start[0]);
        q.offer(start[1]);
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){

            int row = q.poll();
            int column = q.poll();

            // reaches the destination
            if(row == destination[0] && column == destination[1]){
                return true;
            }

            // Traverse in 4 directions
            for(int[] dir:dirs){

                int nextRow = row;
                int nextColumn = column;

                // traverse till we reach a block
                while(nextRow+dir[0] >= 0 && nextRow+dir[0] < m && nextColumn+dir[1] >= 0 && nextColumn+dir[1] < n && maze[nextRow+dir[0]][nextColumn+dir[1]] != 1){

                    nextRow += dir[0];
                    nextColumn += dir[1];
                }

                if(maze[nextRow][nextColumn] != 2){
                    q.offer(nextRow);
                    q.offer(nextColumn);
                    maze[nextRow][nextColumn] = 2;
                }
            }
        }

        return false;

    }
}