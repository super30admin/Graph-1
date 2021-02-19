# Approach: Perform BFS by moving ball on all 4 directions until we hit the wall, always keep track of visited cells, if not visited add to the queue
# Time - O( M * N)
# Space - O(M * N)

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if not maze or len(maze) == 0:
            return false
        
        rows = len(maze)
        cols = len(maze[0])
        
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        
        # add start index to queue and mark it visited
        q = collections.deque()
        q.append(start)
        
        maze[start[0]][start[1]] = 2
        
        while q:
            
            current = q.popleft()
            
            if current[0] == destination[0] and current[1] == destination[1]:
                return True
            
            for dir in dirs:
                i = current[0]
                j = current[1]
                
                # check for boundary conditions and if we are at a wall already before iterating on dirs
                
                while i >= 0 and j >= 0 and i < rows and j < cols and maze[i][j] != 1:
                    
                    i += dir[0]
                    j += dir[1]
                    
                    
                # stopping point, at this point we are one step ahead of the stopping point
                i -= dir[0]
                j -= dir[1]
                
                # if not visited already, add to queue and mark it visited
                if maze[i][j] != 2:
                    q.append([i,j])
                    maze[i][j] = 2
                    
        return False
            
            
## DFS approach

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool: 

        if not maze or len(maze) == 0:
            return False

        rows = len(maze)
        cols = len(maze[0])

        return self.dfs(maze, start, destination, rows, cols)

    def dfs(self, maze, start, dest, rows, cols):

        # base case
        if start[0] == dest[0] and start[1] == dest[1]:
            return True
    
        # logic 
        maze[start[0]][start[1]] = 2
        
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]

        for dir in dirs:
            r = start[0]
            c = start[1]

            while r >= 0 and c >= 0 and r < rows and c < cols and maze[r][c] != 1:

                r += dir[0]
                c += dir[1]

            r -= dir[0]
            c -= dir[1]

            if maze[r][c] != 2:
                if self.dfs(maze, [r,c], dest, rows, cols):
                    return True

        return False





        
        
        