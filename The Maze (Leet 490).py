'''
Time: O(mn) * some constant (not exactly square or just mn), only it iterates again on corners for very few rows
Space: O(mn)
'''

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None or len(maze) == 0:
            return False
        
        if start == destination:
            return True
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(maze)
        n = len(maze[0])
        q = list()

        q.append(start[0])
        q.append(start[1])
        maze[start[0]][start[1]] = 2
        
        while len(q) != 0:
            cr = q.pop(0)
            cc = q.pop(0)
            for di in dirs:
                i = cr
                j = cc
                while i >= 0 and i < m and j >= 0 and j < n and maze[i][j] != 1:
                    i += di[0]
                    j += di[1]
                i -= di[0]
                j -= di[1]
                if [i,j] == destination:
                    return True
                if maze[i][j] != 2:
                    q.append(i)
                    q.append(j)
                    maze[i][j] = 2
        return False
        
        
        

'''
Using DFS Approach
Time: O(mn) * constant
Space: Recursive Stack
'''

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if maze is None or len(maze) == 0:
            return None
        
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(maze)
        n = len(maze[0])
        
        return self.dfs(maze, start, destination, dirs, m, n, start[0], start[1])
    
    def dfs(self, maze, start, destination, dirs, m, n, i, j):
        
        
        if i == destination[0] and j == destination[1]:
            return True
        
        maze[i][j] = 2
        
        for di in dirs:
            r = i
            c = j
            while r >= 0 and r < m and c >= 0 and c < n and maze[r][c] != 1:
                r += di[0]
                c += di[1]
            r -= di[0]
            c -= di[1]
            
            if maze[r][c] != 2 and self.dfs(maze, start, destination, dirs, m, n, r, c):
                return True
        
        return False