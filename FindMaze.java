/**
Leetcode 115: https://leetcode.com/problems/the-maze/

hurdle is at 1

start has coordinates of the row and column to begin with

Algo take one queue of Pair storing the record of the nodes that have been visited 

insert the start in the queue and start doing the BFS, at the nodes are explored in all directions, change their status to 2

one we reach the destination, we will return true, esle in the end false is returned

**/
class Solution 
{
    private int dirs[][] = { {1,0}, {0,1}, {-1, 0}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination)
    {
        int rows = maze.length;
        int cols = maze[0].length;

        Pair st = new Pair(start[0], start[1]);
        Pair dest = new Pair(destination[0], destination[1]);

        Queue<Pair> queue = new LinkedList<>();

        maze[st.row][st.col] = 2;
        queue.add(st);

        while( !queue.isEmpty() )
        {
            Pair current = queue.poll();

            for(int dir[]: this.dirs)
            {
                int row = current.row + dir[0];
                int col = current.col + dir[1];

                // keep going that direction till we hit the boundary value of row or column or we hit a wall i.e value == 1
                while( row >= 0 && col >= 0 && row < rows && col < cols && maze[row][col] != 1)
                {
                    row = row + dir[0];
                    col = col + dir[1];
                }

                // decrementing the value once int directions since we want one location ahead of it
                row = row - dir[0];
                col = col - dir[1];

                Pair point = new Pair(row, col);

                // checking if that point is the destination we have to reach
                if( point.equals(dest))
                    return true;

                // checking if that point has been already explored in all directions
                if(maze[point.row][point.col] != 2)
                    queue.add(point);

            }// end of dirs for loop

            // once the current point has been explored in all directions set value at point = 2
            maze[current.row][current.col] = 2;

        }// end of while loop queue not empty


        // if exploring all the path we have not reached the destination we aim, the return false
        return false;
    }
}
public class Pair
{
    public int row;
    public int col;

    public Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object obj)
    {
        Pair obj2 = (Pair)obj;

        return this.row == obj2.row && this.col == obj2.col;
    }
}