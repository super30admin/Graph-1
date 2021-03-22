
"""
490. The Maze
Time Complexity - O(m*n)
Space Complexity - O(m+n)
Check if destination is equal to target then return True
Create a dfs function that checks:
    Check if destination is equal to target then return True
    and change value to 2
    while traversing throughout direction
    keep checking  if row column have valid value and that value is not equal to 1 and change r and c with current direction + row/column
    if while loop breaks then revert back to previous value and check if its value is not equal to 1 and call dfs with updated r and c value then retutn True. Else return False.    
"""
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        return self.dfs(maze,destination,start[0],start[1])
        
    def dfs(self,maze,dest,i,j):
        dirs = ((-1,0),(0,-1),(1,0),(0,1))
        if i == dest[0] and j == dest[1]:
            return True
        maze[i][j] = 2
        for dir in dirs:
            r = i
            c = j
            while (r >= 0 and r < len(maze) and c >= 0 and c <len(maze[0]) and maze[r][c] != 1):
                r = r + dir[0]
                c = c + dir[1]
            r = r - dir[0]
            c = c - dir[1]
            if maze[r][c] != 2 and self.dfs(maze,dest,r,c):                 
                return True
        return False 