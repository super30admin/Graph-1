from collections import deque

class Solution:
    
    #BFS
    def hasPath_BFS(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if not maze:
            return False
        
        m = len(maze)
        n = len(maze[0])
        #print (m,n)
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        q = deque()        
        q.append(start)
        
        while q:       
            print(q)
            curr = q.popleft()
            if curr[0] == destination[0] and curr[1] == destination[1]:
                    return True
            for i in dirs:
                r = i[0] + curr[0]
                c = i[1] + curr[1]
                while r < m and c < n and r >= 0 and c >= 0 and maze[r][c] !=1: 
                    r += i[0]
                    c += i[1]
                print(r,c)
                r = r- i[0]
                c = c - i[1]
                if maze[r][c] != 2:
                    maze[r][c]=2
                    q.append((r,c))
        return False
    
    #DFS
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if not maze:
            return False
        
        self.m = len(maze)
        self.n = len(maze[0])
        
        return self.dfs(maze,start,destination)
        

    def dfs(self,maze,start,destination):
        #Base
        #print(start)
        if start[0] == destination[0] and start[1] == destination[1]:
            print(start)
            return True
                
        #Logic
        maze[start[0]][start[1]]=2
        
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        
        for i in dirs:
            r = i[0] + start[0]
            c = i[1] + start[1]
            while r < self.m and c < self.n and r >= 0 and c >= 0 and maze[r][c] !=1 : 
                r += i[0]
                c += i[1]
            r = r - i[0]
            c = c - i[1] 
            if maze[r][c] !=2 and self.dfs(maze,[r,c],destination):
                return True
        
        return False
            
       
