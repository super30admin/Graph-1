# DFS
# Time Complexity - O(mn)
# Space Complexity -O(mn)


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        if (start[0]== destination[0] and start[1]== destination[1]):
            return True

        self.dirs = [[1,0],[0,-1],[0,1],[-1,0]]
        
        return  self.dfs(maze,m,n,start,destination)

    def dfs(self,maze,m,n,start,destination):
        
        if (start[0] == destination[0] and start[1] == destination[1]):
            return True 
        if maze[start[0]][start[1]] == 2:
            return False 
        maze[start[0]][start[1]] = 2

        for each in self.dirs:
            i = start[0]
            j = start[1]
           
            while (i >= 0 and i < m and j >= 0 and j < n and maze[i][j] != 1):
                i += each[0]
                j += each[1]
            # backtrack
            i -= each[0]
            j -= each[1]
            if self.dfs(maze, m, n, [i, j], destination):
                   return True
              
            

            
        return False
