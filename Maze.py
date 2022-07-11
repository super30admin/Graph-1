#Time Complexity : O(M*N)
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        queue = deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2
        
        directions = [[-1,0],[0,-1],[1,0],[0,1]]
        
        while(len(queue)):
            curr = queue.pop()
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            
            for direction in directions:
                i = curr[0]
                j = curr[1]
                while(i >=0 and j >= 0 and i < len(maze) and j < len(maze[0]) and maze[i][j] != 1):
                    i += direction[0]
                    j += direction[1]
                i-= direction[0]
                j -= direction[1]
                if(maze[i][j] != 2):
                    maze[i][j] = 2
                    queue.append([i,j])
        return False
