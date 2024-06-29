// Time Complexity : O(m + n) * O(m * n)
// Space Complexity : O(m * n)
// Method used : BFS

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Using BFS approach
        // I will use -1 as the cell is visited

        Queue<int[]> queue = new LinkedList();

        // Add to the queue and mark as visited
        queue.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = -1;

        while(!queue.isEmpty())
        {
            int[] pair = queue.poll();

            for(int[] dir : dirs)
            {
                int row = pair[0], col = pair[1];

                // Assume our direction popped from queue was 0, 4 and assume dir[0] and dir[1] are -1 and 0 which is 
                // left direction we keep on adding them and check the boundary/wall
                // I keep continuing the loop even I find a -1 or 0. I only stop when I see a 1
                while(row >= 0 && col >= 0 && row < rows && col < cols && maze[row][col] != 1)
                {
                    row = row + dir[0];
                    col = col + dir[1];
                }

                // The above loop might fail for any of those 5 conditions. But let us assume we found out a 1 which is wall
                // Now I need to make -1 to a cell before it.
                row = row - dir[0];
                col = col - dir[1];

                // It means ball can stop here because it is not a wall and is not yet visited.
                // If maze[row][col] is not 0 then we don't care it bcoz the value in that case should be -1 which
                // should have already been visited
                if(maze[row][col] == 0)
                {
                    // Check if it is destination
                    if(row == destination[0] && col == destination[1]) return true;

                    // This is not a destination so mark it visited and add to the queue
                    else 
                    {
                        maze[row][col] = -1;
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }

        return false;
    }
}
