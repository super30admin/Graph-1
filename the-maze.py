#tc=O(m*n)
#sc=O(m*n)
from collections import deque
from typing import List
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze), len(maze[0])
        
        q = deque([start])
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        
        maze[start[0]][start[1]] = 2
        
        while q:
            r, c = q.popleft()
            
            if r == destination[0] and c == destination[1]:
                return True
            
            for dr, dc in dirs:
                i, j = r, c
                
                # Keep the ball rolling
                while 0 <= i < m and 0 <= j < n and (maze[i][j] == 0 or maze[i][j] == 2):
                    i += dr
                    j += dc
                
                # Bring back to stop point
                i -= dr
                j -= dc
                
                if maze[i][j] != 2:
                    q.append([i, j])
                    maze[i][j] = 2
        
        return False

# Example usage:
maze = [
    [0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0],
    [1, 1, 0, 1, 1],
    [0, 0, 0, 0, 0]
]
start = [0, 4]
destination = [4, 4]

solution = Solution()
result = solution.hasPath(maze, start, destination)
print("Path exists:", result)