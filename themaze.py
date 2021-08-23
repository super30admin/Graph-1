from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if not maze or not start or not destination:
            return False
        
        if start == destination:
            return True
        
        visited = set((start[0], start[1]))
        queue = deque([(start[0], start[1])])
        des = (destination[0], destination[1])
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        while queue:
            
            (x, y) = queue.popleft()
            if (x, y) == des:
                return True
            for dx, dy in directions:
                x_n = x + dx
                y_n = y + dy
                while 0 <= x_n < len(maze) and 0 <= y_n < len(maze[0]) and maze[x_n][y_n] == 0:
                    x_n += dx
                    y_n += dy
                x_n -= dx
                y_n -= dy
                
                if (x_n, y_n) not in visited:
                    visited.add((x_n, y_n))
                    queue.append((x_n, y_n))
        return False