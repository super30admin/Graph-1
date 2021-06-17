# TC: O(M x N) since we will be visiting all the nodes. 
# SC: O(H) where H is the height of the recursive stack.

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or len(maze) == 0: 
            return False
        
        rows = len(maze)
        cols = len(maze[0])
        
        def dfs(i, j):
            if destination[0] == i and destination[1] == j: 
                return True
            
            if maze[i][j] == 2: 
                return False
            
            maze[i][j] = 2
            dirs = [(0,1),(0,-1),(1,0),(-1,0)]
            for x,y in dirs: 
                new_x = i + x
                new_y = j + y
                while new_x >= 0 and new_x < rows and new_y >= 0 and new_y < cols and maze[new_x][new_y] != 1: 
                    new_x += x
                    new_y += y
                
                new_x -= x
                new_y -= y
                if maze[new_x][new_y] != 2: 
                    if dfs(new_x, new_y):
                        return True
            return False
            
        
        return dfs(start[0], start[1])
