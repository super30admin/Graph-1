from collections import deque

def hasPath(maze, start, destination):
    m, n = len(maze), len(maze[0])
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    queue = deque([start])
    visited = set()
    visited.add(tuple(start))
    
    while queue:
        x, y = queue.popleft()
        
        if [x, y] == destination:
            return True
        
        for dx, dy in directions:
            new_x, new_y = x, y
            
            # Move in the direction until hitting a wall or boundary
            while 0 <= new_x + dx < m and 0 <= new_y + dy < n and maze[new_x + dx][new_y + dy] == 0:
                new_x += dx
                new_y += dy
            
            if (new_x, new_y) not in visited:
                visited.add((new_x, new_y))
                queue.append([new_x, new_y])
    
    return False

#time = O(M * N) M = rows, N= columns
#space = O(M * N) 