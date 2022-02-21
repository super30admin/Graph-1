'''
TC: O(mn)
SC: O(mn)

Intuition: From any point, do dfs and stop until the point where the next node is 1 or edge, return that point and add to 
the queue. Repeat until destination.
'''
from collections import deque

class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        rlen = len(maze)
        if not rlen:
            return False
        clen = len(maze[0])
        visited = [[False for i in range(clen)] for j in range(rlen)]
        
        def issafe(x, y, a=rlen, b=clen):
            if x >= 0 and y >= 0 and x < a and y < b:
                return True
            return False
        
        def dfs(maze, x, y, dirs):
            newx = x + dirs[0]
            newy = y + dirs[1]
            
            if not issafe(newx, newy) or maze[newx][newy] == 1:
                return x, y
            
            return dfs(maze, newx, newy, dirs)
        
        dirArr = [(0,1), (1, 0), (-1, 0), (0, -1)]
        queue = deque()
        queue.append(start)
        
        while queue:
            topx, topy = queue.popleft()
            if topx == destination[0] and topy == destination[1]:
                return True
            visited[topx][topy] = True
            for dirs in dirArr:
                newx, newy = dfs(maze, topx, topy, dirs)
                if not visited[newx][newy]:
                    visited[newx][newy] = True
                    queue.append([newx, newy])
        
        return False