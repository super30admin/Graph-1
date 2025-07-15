# Time complexity: O(m * n)
# Space complexity: O(m * n)

from collections import deque

def hasPath(maze, start, destination):
    m, n = len(maze), len(maze[0])
    visited = [[False] * n for _ in range(m)]
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]  # right, left, down, up
    
    queue = deque([start])
    visited[start[0]][start[1]] = True
    
    while queue:
        x, y = queue.popleft()
        
        if [x, y] == destination:
            return True
        
        for dx, dy in directions:
            nx, ny = x, y
            while 0 <= nx + dx < m and 0 <= ny + dy < n and maze[nx + dx][ny + dy] == 0:
                nx += dx
                ny += dy
            
            if not visited[nx][ny]:
                queue.append([nx, ny])
                visited[nx][ny] = True
    
    return False
