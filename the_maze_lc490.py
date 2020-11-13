"""
Author: Srindihi
Did it run on LC: Getting TLE

Time Complexity: O(m x n) - Additionally using a Queue - It can have all points at once in worst case at once
Space Complexity: O(1) - No additional space, the visited is done in place and is also swapped with initial value
so that input Maze does not modified

Logic: Using BFS first explore a given coordinate breadth wise. In case it equals to the destination
coordinates, then return True(since its possible to land there.)

Else, while exploring breadth wise, if you do not encounter a wall, keep reducing the current row and col
and check if this is a possible destination
"""
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze) == 0:
            return False
        
        l = len(maze)
        b = len(maze[0])
        
        qu = deque([start])
        dirs = ((-1,0),(1,0),(0,-1),(0,1))
        
        while qu:
            x,y = qu.popleft()
            temp = maze[x][y]
            maze[x][y] = 2
            
            if x ==destination[0] and y == destination[1]:
                maze[x][y] = temp
                return True
            
            for row,col in dirs:
                new_r = x + row
                new_c = y + col
                
                while 0<=new_r<len(maze) and 0<=new_c<len(maze[0]) and maze[new_r][new_c] == 0:
                    new_r+=row
                    new_c+=col
                    
                new_r-=row
                new_c-=col
                
                if maze[new_r][new_c] == 0:
                    qu.append((new_r,new_c))
            
            maze[x][y] = temp
            print(maze)
        return False