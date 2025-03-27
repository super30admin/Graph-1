// Time complexity  O(mn)
// spcace Complexity O(mn)
public class Solution
{
    public bool HasPath(int[][] maze, int[] start, int[] destination)
    {
        int[][] dir = new int[][] { [0, 1], [0, -1], [1, 0], [-1, 0] };
        int m = maze.Length;
        int n = maze[0].Length;
        if (start[0] == destination[0] && start[1] == destination[1])
        {
            return true;
        }
        Queue<int[]> bfs = new Queue<int[]>();
        bfs.Enqueue(start);
        maze[start[0]][start[1]] = 2;
        while (bfs.Count() > 0)
        {
            int[] currPos = bfs.Dequeue();
            foreach (int[] d in dir)
            {
                int nr = currPos[0];
                int nc = currPos[1];
                while (nr < m && nr >= 0 && nc < n && nc >= 0 && maze[nr][nc] != 1)
                {
                    nr = nr + d[0];
                    nc = nc + d[1];
                }
                nr = nr - d[0];
                nc = nc - d[1];
                if (nr == destination[0] && nc == destination[1])
                {
                    return true;
                }
                if (maze[nr][nc] != 2)
                {
                    bfs.Enqueue(new int[] { nr, nc });
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
    }
}