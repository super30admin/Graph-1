
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Didnt tried (premium question)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


//BFS
// 2) Put initial element in queue
// 3) Look in four directions
//     a. Go in one direction until hit stopping element, then put in queue
//     b. Similalry put other elements for other direction until stopping element
//     c. Then dequeue the element from queue and then start going in differetn directions from that element
//     d. Keep doing until u reach destination.
// 4) TC: O(m*n)
// 5) SC: O(m*n)

public bool hasPathBFS(int[][] maze, int[] start, int[] destination)
{

    //BFS
    Queue<int[]> q = new Queue<int[]>();
    int[][] dirs = new int[][] { new int[] { 0, 1 }, new int[] { 0, -1 }, new int[] { 1, 0 }, new int[] { -1, 0 } };
    int m = maze.Length;
    int n = maze[0].Length;

    q.Enqueue(new int[] { start[0], start[1] });
    maze[start[0]][start[1]] = 2;

    while (q.Count > 0)
    {
        int[] curr = q.Dequeue();

        foreach (var dir in dirs)
        {
            int r = curr[0];
            int c = curr[1];
            //we keep in one direction until we reach stopping point or wall (which is 1)
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1)
            {
                r = r + dir[0];
                c = c + dir[1];
            }
            //once we hit wall, we come one step behind in one direction
            r = r - dir[0];
            c = c - dir[1];

            //if it is not visited before
            if (maze[r][c] != 2)
            {
                //if we reached the destination, return true
                if (r == destination[0] && c == destination[1])
                    return true;
                
                maze[r][c] = 2;
                q.Enqueue(new int[] {r, c});
            }
        }

        return false;
    }
    return false;
}




//DFS
// 2) We will start from initial point, we will start exploring going all four directions
// 3) We will keep going in one direction, when we reach stopping condition, we will put it in stack.
// 4) TC: O(m*n)
// 5) SC: O(m*n)
public bool hasPathDFS(int[][] maze, int[] start, int[] destination)
{
    m = maze.Length;
    n = maze[0].Length;

    return dfsMaze(maze, start, destination);
}

private bool dfsMaze(int[][] maze, int[] start, int[] destination)
{
    //base
    //we rweached the node visited before, so return false
    if (maze[start[0]][start[1]] != 2)
        return false;

    //we reached the destination, return true
    if (start[0] == destination[0] && start[1] == destination[1])
        return true;

    //logic
    maze[start[0]][start[1]] = 2;
    foreach (var dir in dirs)
    {
        int r = start[0];
        int c = start[1];
        //we keep in one direction until we reach stopping point or wall (which is 1)
        while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1)
        {
            r = r + dir[0];
            c = c + dir[1];
        }
        //once we hit wall, we come one step behind in one direction
        r = r - dir[0];
        c = c - dir[1];

        if (dfsMaze(maze, new int[] { r, c }, destination))
        {
            return true;
        }
    }
    return false;
}