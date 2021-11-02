using System;
using System.Collections.Generic;
using System.Text;

namespace Graph
{
    class TheMazeLC
    {
        //TC=O((m+n) *m * n)
        //SC=O(m * n)
        public bool HasPath(int[][] maze, int[] start, int[] destination)
        {
            if (maze == null || maze.Length == 0) return false;
            int m = maze.Length;
            int n = maze[0].Length;
            Queue<int[]> q = new Queue<int[]>();
            q.Enqueue(new int[] { start[0], start[1] });
            maze[start[0]][start[1]] = 2;
            int[][] dirs = new int[4][] { new int[2] { 0, 1 }, new int[2] { 0, -1 }, new int[2] { 1, 0 }, new int[2] { -1, 0 } };
            while (q.Count != 0)
            {
                int[] curr = q.Dequeue();
                foreach (int[] dir in dirs)
                {
                    int row = curr[0];
                    int col = curr[1];
                    while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != 1)
                    {
                        row = row + dir[0];
                        col = col + dir[1];
                    }
                    row = row - dir[0];
                    col = col - dir[1];
                    if (row == destination[0] && col == destination[1]) return true;
                    if (maze[row][col] != 2)
                    {
                        q.Enqueue(new int[] { row, col });
                        maze[row][col] = 2;
                    }
                }
            }
            return false;
        }
        int m, n;
        int[][] dirs;
        public bool HasPathDFS(int[][] maze, int[] start, int[] destination)
        {
            if (maze == null || maze.Length == 0) return false;
            m = maze.Length;
            n = maze[0].Length;
            dirs = new int[4][] { new int[2] { 0, 1 }, new int[2] { 0, -1 }, new int[2] { 1, 0 }, new int[2] { -1, 0 } };
            return dfs(maze, destination, start[0], start[1]);
        }

        private bool dfs(int[][] maze, int[] destination, int row, int col)
        {
            //base

            //logic
            maze[row][col] = 2;
            foreach (int[] dir in dirs)
            {
                int r = row;
                int c = col;
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1)
                {
                    r += dir[0];
                    c += dir[1];
                }
                r = r - dir[0];
                c = c - dir[1];
                if (maze[r][c] != 2 && dfs(maze, destination, r, c))
                {
                    return true;
                }
            }
            return false;
        }
    }
}
