#Time COmplexiy : O(N) WHERE N is number fo elements in Maze
#Space Complexity : O(MAX(N,M)) where N is len(maze) and M is len(maze[0])
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze) ==0:
            return True
        m = len(maze)
        n = len(maze[0])
        q = []
        q.append(start)
        maze[start[0]][start[1]]==2
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        while(len(q)!=0):
            curr = q.pop(0)
            if curr[0]==destination[0] and curr[1] == destination[1]:
                return True
            for i in dirs:
                r = curr[0]
                c = curr[1]
            while(r<m and c<n and r>=0 and c>=0 and maze[r][c]==1):
                r+=dir[0]
                c+=dir[1]
            r-=dir[0]
            c-=dir[0]
            if maze[r][c]!=2:
                maze[r][c]=2
                q.append(r,c)
        return False
    
===============================================================================
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
         m = len(maze)
         n = len(maze[0])
         if len(maze) ==0:
          return True
        maze[start[0]][start[1]]==2
        
        def dfs(maze,start,destination):
          if start[0] == destination[0] and start[1] == destination[1]:
                return True
          dirs = [(0,1),(1,0),(-1,0),(0,-1)] 
          for i in dirs:
                r = curr[0]
                c = curr[1]
            while(r<m and c<n and r>=0 and c>=0 and maze[r][c]==1):
                r+=dir[0]
                c+=dir[1]
            r-=dir[0]
            c-=dir[0]
            if maze[r][c]!=2:
                maze[r][c]=2
                if (dfs(maze,[r,c],destination)) ==True:
                    return True
          return False
      
      return dfs(maze,start,destination)
        
         
        
        
                