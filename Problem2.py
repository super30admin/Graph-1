# time complexity o(m*n) k
#space complexity o(m*n)

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze), len(maze[0])
        return self.dfs(maze, start, destination, m, n)

    def dfs(self, maze: List[List[int]], start: List[int], destination: List[int], m: int, n: int) -> bool:
        # Base cases
        if start == destination:
            return True
        
        # If already visited, return False
        if maze[start[0]][start[1]] == 2:
            return False
        
        # Mark current cell as visited
        maze[start[0]][start[1]] = 2
        
        # Directions: up, down, left, right
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        
        for d in directions:
            nr, nc = start
            
            # Roll until you hit a wall or boundary
            while 0 <= nr < m and 0 <= nc < n and maze[nr][nc] != 1:
                nr += d[0]
                nc += d[1]
            
            # Step back one position (the ball stops here)
            nr -= d[0]
            nc -= d[1]
            
            if self.dfs(maze, [nr, nc], destination, m, n):
                return True
        
        return False
