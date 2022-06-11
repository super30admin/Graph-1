using System;
using System.Collections.Generic;
using System.Text;

namespace DFS_And_BFS
{
    public class Maze
    {
        //BFS
        /*
         * T.C: O(M*N) where m is rows and n is columns in the maze
         * S.C: O(M*N)
         */
        public Boolean hasPath(int[][] maze, int[] start, int[] destination)
        {
            if (maze == null || maze.Length == 0) return false;

            int[,] dir = new int[,] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
            int m = maze.Length;
            int n = maze[0].Length;
            Queue<int[]> queue = new Queue<int[]>();

            queue.Enqueue(new int[] { start[0], start[1] });
            maze[start[0]][start[1]] = 2;

            while (queue.Count != 0)
            {
                int[] curr = queue.Dequeue();

                for (int i = 0; i < dir.GetLength(0); i++)
                {
                    int r = curr[0];
                    int c = curr[1];

                    if (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1)
                    {
                        r = r + dir[i, 0];
                        c = c + dir[i, 0];
                    }

                    //once we reach to 1 need to go back to 0 as valid coordinates
                    r = r - dir[i, 0];
                    c = c - dir[i, 0];

                    if (maze[r][c] != 2)
                    {
                        if (r == destination[0] && c == destination[1])
                        {
                            return true;
                        }
                        maze[r][c] = 2;
                    }


                    queue.Enqueue(new int[] { r, c });
                }
            }
            return false;
        }



        //DFS solution

        int[,] dir = new int[,] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        public Boolean hasPath1(int[][] maze, int[] start, int[] destination)
        {

            return dfs(maze, start, destination);
                
        }

        private bool dfs(int[][] maze, int[] start, int[] destination )
        {
            //base
            if(start[0] == destination[0] && start[1] == destination[1])
            {
                return true;
            }


            //logic
            
            maze[start[0]][start[1]] = 2; 

            for (int i = 0; i < dir.GetLength(0); i++)
            {
                int r = start[0];
                int c = start[1];

                if (r >= 0 && r < maze.Length && c >=0 && c < maze[0].Length && maze[r][c] !=1 )
                {
                    r = r + dir[i, 0];
                    c = c + dir[i, 1];
                }

                r = r - dir[i, 0];
                c = c - dir[i, 1];

                if(maze[r][c] !=2 && dfs(maze, new int[] { r, c }, destination))
                {
                    return true;
                }
            }

            return false;
        }
    }
}
