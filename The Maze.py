# Time complexity: O(mn)
# Space complexity: O(mn)-recursion stack
# Use DFS
# keep a dirs list to move up, down, left, right directions
# taking care of edge cases, run a loop by moving accross directions until edge case or until there is an obstacle.
# if there is an obstacle, travel from the place before obstacle to different directions again.
# if we reach destination, return true.




class Solution:
    def __init__(self):
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]]
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze)== 0:
            return False
        return self.dfs(maze,start,destination)
    
    def dfs(self,maze,start, destination):
        #base case
        if start[0]== destination[0] and start[1]==destination[1]:
            return True
        
        #logic
        maze[start[0]][start[1]] = 2
        for dir in self.dirs:
            i = start[0]
            j = start[1]
            while(i < len(maze) and j < len(maze[0]) and i >= 0 and j >= 0 and maze[i][j] != 1):

                i = i + dir[0]
                j = j + dir[1]
            i = i - dir[0]
            j = j - dir[1]
            if((maze[i][j] != 2) and self.dfs(maze,[i,j], destination)):
                return True
        return False
            
                
            
        