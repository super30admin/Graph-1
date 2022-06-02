#Time Complexity : O(M*N)
#Space Complexity: O(M*N) 
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #down,left,up,right
        dirr = [[1,0],[0,-1],[-1,0],[0,1]]
        row = len(maze)
        col = len(maze[0])
        queue = [start]
        
        while queue:
            curr = queue.pop()
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            
            for k in dirr:
                i = curr[0]
                j = curr[1]
                while i >=0 and j >=0 and i < row and j < col and maze[i][j] !=1:
                    i += k[0]
                    j += k[1]
                i -= k[0]
                j -= k[1]
                    
                if maze[i][j] !=2:
                    queue.append([i,j])
                    maze[i][j] = 2
                    
        return False