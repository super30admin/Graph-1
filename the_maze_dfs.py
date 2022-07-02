# Time Complexity : O(MN) where M is number of rows and N is number of columns in the grid
# Space Complexity :  O(MN) where M is number of rows and N is number of columns in the grid
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    """
    @param maze: the maze
    @param start: the start
    @param destination: the destination
    @return: whether the ball could stop at the destination
    """
    def has_path(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # write your code here
        if len(maze[0]) == 0: return False
        if start == destination: return True
        dirs = [(1,0), (0,1), (-1,0), (0,-1)]
        ROWS = len(maze)
        COLS = len(maze[0])
        r, c = start
        return self.dfs(maze, r, c, destination, dirs, ROWS, COLS)
    
    def dfs(self, maze, r, c, destination, dirs, ROWS, COLS):
        #base
        if r == destination[0] and c == destination[1]:
            return True
        if maze[r][c] == 2: return False

        #logic
        maze[r][c] = 2
        for d in dirs:
            nr = r
            nc = c
            while nr >= 0 and nc >= 0 and nr < ROWS and nc < COLS and maze[nr][nc] != 1:
                nr += d[0]
                nc += d[1]
            
            nr -= d[0]
            nc -= d[1]
            if (maze[nr][nc] != 2 and self.dfs(maze, nr, nc, destination, dirs, ROWS, COLS)): return True

        return False