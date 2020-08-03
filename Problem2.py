"""
// Time Complexity : o(m*n), 
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

class Solution:
    def dfs(self, maze, start, dest):
        if start[0] == dest[0] and start[1] == dest[1]: #when we reach the destiiton
            return True
        
        dirs = [[0,-1],[0,1],[1,0],[-1,0]]
        
        for d in dirs: #explorinf all directions
            r = start[0]
            c = start[1]
            while r < len(maze) and r >= 0 and c < len(maze[0]) and c >= 0 and maze[r][c] != 1: #while stopping condition is not met, keep moving
                r = r + d[0]
                c = c + d[1]
                
            r =  r - d[0] #to go to the valid position
            c = c - d[1]
            
            if maze[r][c] != 2: #if not visited, mark it visited and call dfs on current location
                maze[r][c] = 2
            
                if self.dfs(maze,[r,c],dest):
                    return True
        return False
    
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        maze[start[0]][start[1]] = 2 #marking the start cell as visited
        
        return self.dfs(maze,start, destination) #call dfs