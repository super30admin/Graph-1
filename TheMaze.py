#Time Complexity: O(O(M * N * max(M, N))
#Space Complexity: O(M * N)
#Each cell is processed once.
#Each processing does up to 4 * max(M,N) rolling steps → simplified to O(M*N*max(M,N))
from collections import deque
def Maze(maze,start,destination):
    """
    :type maze: List[List[int]]
    :type start: List[int]
    :type destination: List[int]
    :rtype: bool
    """
    if not maze or not start or not destination:
        return False
    
    rows, cols = len(maze), len(maze[0])
    directions = [(0,1),(0,-1),(1,0),(-1,0)]
    visited = set()
    
    queue = deque([tuple(start)])
    visited.add(tuple(start))
    
    while queue:
        x, y = queue.popleft()
        
        if [x, y] == destination:
            return True
        
        for dx, dy in directions:
            nx, ny = x, y
            while 0 <= nx+dx < rows and 0 <= ny+dy < cols and maze[nx+dx][ny+dy] == 0:
                nx += dx
                ny += dy
            
            if (nx, ny) not in visited:
                visited.add((nx, ny))
                queue.append((nx, ny))
    
    return False
