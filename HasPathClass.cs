// TC => O(m+n)
// SC => O(m+n)

public class Solution
{
    int m, n;
    int[][] dirs;
    public bool HasPath(int[][] maze, int[] start, int[] destination)
    {
        if (maze == null || maze.Length == 0)
        {
            return false;
        }
        m = maze.Length;
        n = maze[0].Length;
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];
        return dfs(maze, start, destination);

    }

    public bool dfs(int[][] maze, int[] start, int[] destination)
    {
        //base
        if (start[0] == destination[0] && start[1] == destination[1])
        {
            return true;
        }

        //logic
        maze[start[0]][start[1]] = 2;
        foreach (var dir in dirs)
        {
            int nr = start[0];
            int nc = start[1];
            while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1)
            {
                nr += dir[0];
                nc += dir[1];
            }
            nr = nr - dir[0];
            nc = nc - dir[1];
            if (maze[nr][nc] == 2)
            {
                continue;
            }
            if (dfs(maze, new int[2] { nr, nc }, destination))
            {
                return true;
            }
        }
        return false;
    }
}