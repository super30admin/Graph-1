## Problem2 The Maze (https://leetcode.com/problems/the-maze/)
def has_path(maze: list[list[int]], start: list[int], destination: list[int]) -> bool:
    rows, cols = len(maze), len(maze[0])
    directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
    def dfs(r: int, c: int) -> bool:
        # If this stopping position was already visited, skip it
        if maze[r][c] == 2:
            return False
            
        # Check if we reached the destination stopping point
        if r == destination[0] and c == destination[1]:
            return True
            
        # Mark current stopping position as visited
        maze[r][c] = 2
        
        # Try rolling in all 4 directions
        for dr, dc in directions:
            nr, nc = r, c
            
            # Keep rolling until hitting a wall (1) or boundary
            while 0 <= nr + dr < rows and 0 <= nc + dc < cols and maze[nr + dr][nc + dc] != 1:
                nr += dr
                nc += dc
                
            # Recursively explore from the stopped position
            if dfs(nr, nc):
                return True
                
        return False

    return dfs(start[0], start[1])