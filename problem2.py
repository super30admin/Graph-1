#Time O(nm(m+n)), space(mn)

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        q=deque()
        
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        
        m=len(maze)
        n=len(maze[0])
        
        maze[start[0]][start[1]]=2
    #Adding start values into queue    
        q.append([start[0],start[1]])
    #Bfs traversal processing the start values     
        while q:
            cr,cc=q.popleft()
        #Going in all four directions to find the zero's and keeping on moving until we find destination
            for i in dirs:
                nr=cr
                nc=cc
                
                while nr<m and nr>=0 and nc<n and nc>=0 and maze[nr][nc]!=1:
                    nr+=i[0]
                    nc+=i[1]
                    
                nr-=i[0]
                nc-=i[1]
                
                if nr==destination[0] and nc==destination[1]:
                    return True
                
                if maze[nr][nc]!=2:
                    maze[nr][nc]=2
                    q.append([nr,nc])
                    
        return False
