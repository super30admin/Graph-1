# Time O(m*n)
# Space O(m+n)
class Solution:
    def __init__(self):
        self.dir = [(-1,0), (1,0), (0,-1), (0,1)]
        self.flag = False
        
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        maze[start[0]][start[1]] = 2
        self.dfs(maze, start, destination, len(maze), len(maze[0]))
        return self.flag

    def dfs(self, maze: List[List[int]], start: List[int], destination: List[int], m: int, n: int) -> None:
        if start[0] == destination[0] and start[1] == destination[1]:
            self.flag = True
            return
        
        for r, c in self.dir:
            nr, nc = start[0] + r, start[1] + c
            while -1 < nr < m and -1 < nc < n and  maze[nr][nc] != 1:
                nr, nc = nr + r, nc + c
            
            nr, nc = nr - r, nc - c
            if maze[nr][nc] != 2:
                maze[nr][nc] = 2
                self.dfs(maze, [nr, nc], destination, m, n)
        