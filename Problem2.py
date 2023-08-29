# Time Complexity: O(rows * cols) 
# Space Complexity: O(rows * cols) 
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        rows, cols = len(maze), len(maze[0])
        visited = [[False] * cols for _ in range(rows)]
        
        def dfs(r, c):
            if visited[r][c]:
                return False
            visited[r][c] = True
            
            if [r, c] == destination:
                return True
            
            directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]  # Right, Left, Down, Up
            
            for dr, dc in directions:
                nr, nc = r, c
                while 0 <= nr + dr < rows and 0 <= nc + dc < cols and maze[nr + dr][nc + dc] == 0:
                    nr += dr
                    nc += dc
                if dfs(nr, nc):
                    return True
            
            return False
        
        return dfs(start[0], start[1])
