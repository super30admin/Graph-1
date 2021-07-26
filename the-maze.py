# BFS
# Time Complexity: O(mn)
# Space Complexity: O(mn)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # Null condition check
        if len(maze) == 0:
            return True
        
        # Declarations
        m = len(maze)
        n = len(maze[0])
        q = deque()
        dirs = [[1,0], [-1,0], [0,1], [0,-1]]
        
        # Initially append start to the queue
        q.append(start)
        
        while q:
            # Pop the elements from the queue and traverse its neighbors
            curr = q.popleft()
            for dir in dirs:
                i = curr[0]
                j = curr[1]
                # Traverse as long as there is no wall and the boundary conditions match
                while (i >= 0 and i < m and j >= 0 and j < n and maze[i][j] != 1):
                    i += dir[0]
                    j += dir[1]
                
                # To go one step back and within the boundaries
                i -= dir[0]
                j -= dir[1]
                
                # Keep checking if it is the destination at each point
                if i == destination[0] and j == destination[1]:
                    return True
                # Append the node to the queue
                # To mark visited nodes, make the value 2
                if maze[i][j] != 2:
                    q.append([i,j])
                    maze[i][j] = 2
        return False
                
                    
                    
# DFS
# Time Complexity: O(mn)
# Space Complexity: O(mn)
class Solution:
    def dfs(self, maze, start, destination, m, n):
        dirs = [[1,0], [-1,0], [0,1], [0,-1]]
        # Base
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        # Logic
        # Mark it visited
        maze[start[0]][start[1]] = 2
        # Traverse its neighbors
        for dir in dirs:
            i = start[0]
            j = start[1]
            # Traverse as long as there is no wall and the boundary conditions match
            while (i >= 0 and i < m and j >= 0 and j < n and maze[i][j] != 1):
                i += dir[0]
                j += dir[1]

            # To go one step back and within the boundaries
            i -= dir[0]
            j -= dir[1]
            
            # New start to traverse
            newStart = [i, j]
            # If it is not visited, recurse and return True
            if maze[i][j] != 2 and self.dfs(maze, newStart, destination, m, n):
                return True
            
        return False
                
        
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # Null condition check
        if len(maze) == 0:
            return True
        
        # Declarations
        m = len(maze)
        n = len(maze[0])
        return self.dfs(maze, start, destination, m, n)
        
                
                    