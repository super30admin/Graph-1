from collections import deque

class Solution:
    #Solution 1
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #Approach: BFS
        #Time Complexity: O(m * n)
        #Space Complexity: O(m * n)
        #where, the maze is of the dimensions m * n
        
        m, n = len(maze), len(maze[0])
        
        dirArr = [(-1, 0), (0, - 1), (0, 1), (1, 0)]
        
        de = deque()
        de.append(start)
        maze[start[0]][start[1]] = 2
        
        while de:
            popped = de.popleft()
            if popped == destination:
                return True
            for dir in dirArr:
                r, c = popped
                while r >= 0 and r < m and c >= 0 and c < n and maze[r][c] != 1:
                    r += dir[0]
                    c += dir[1]
                
                r -= dir[0]
                c -= dir[1]
                
                if maze[r][c] != 2:
                    de.append([r,c])
                    maze[r][c] = 2
                
        return False
        
    #Solution 2
    """
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #Approach: BFS
        #Time Complexity: O(m * n)
        #Space Complexity: O(m * n)
        #where, the maze is of the dimensions m * n
        
        m, n = len(maze), len(maze[0])
        self.dirArr = [(-1, 0), (0, - 1), (0, 1), (1, 0)]
        
        return self.dfs(maze, start, destination, m, n)
    
    def dfs(self, maze, start, destination, m, n):
        #base
        if start == destination:
            return True
        elif maze[start[0]][start[1]] == 2:
            return False
        
        #logic
        maze[start[0]][start[1]] = 2
        for dir in self.dirArr:
            r, c = start
            while r >= 0 and r < m and c >= 0 and c < n and maze[r][c] != 1:
                r += dir[0]
                c += dir[1]
                
            r -= dir[0]
            c -= dir[1]
            
            if self.dfs(maze, [r, c], destination, m, n):
                return True
    """