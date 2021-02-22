class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # DFS solution
        # Problem Language difficult to understand
        # Time Complexity: O(mn)
        # Space Complexity: O(1), ignoring recursive stack
        if(maze[start[0]][start[1]]==-1):
            return False
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        if(start==destination):
            return True
        
        maze[start[0]][start[1]]=-1
        
        for i,j in dirs:
            r = start[0]
            c = start[1]
            while(r>=0) and (r<len(maze)) and (c>=0) and (c<len(maze[0])) and (maze[r][c]!=1):
                r= r + i
                c = c + j
            r-=i
            c-=j
            z = self.hasPath(maze, [r,c], destination)
            if(z==True):
                return True
        
        #maze[start[0]][start[1]]=0
        return False
