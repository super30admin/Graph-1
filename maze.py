#Time Complexity: O(MN)

#Space Complexity: O(MN) 

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze)==0:
            return False
        m = len(maze)
        n = len(maze[0])
        
        dirs = [[0,-1],[0,1],[-1,0],[1,0]]
        def dfs(start):
            
            #base
            if start[0]==destination[0] and start[1]==destination[1]:
                return True
            #logic
            maze[start[0]][start[1]] = 2
            for item in dirs:
                row = start[0]
                col = start[1]
                
                while(row<m and row>=0) and(col<n and col>=0) and maze[row][col]!=1:
                    row+=item[0]
                    col +=item[1]
                row-= item[0]
                col-= item[1]
                if maze[row][col]!=2 and dfs((row,col)):
                    return True
            return False

        return dfs(start)
        
        