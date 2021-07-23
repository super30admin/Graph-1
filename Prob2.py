class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """ 
        # time: O(mn *max(m,n))
        # space: O(mn)
        #BFS solution
        queue = deque()
        queue.append((start[0],start[1]))
        maze[start[0]][start[1]] = 2
        dirs = [(-1,0),(1,0),(0,1),(0,-1)]
        while queue:
            cur = queue.popleft()
            for i,j in dirs:
                x,y = cur
                while x>=0 and y>=0 and x<len(maze) and y<len(maze[0]) and maze[x][y]!=1:
                    x += i
                    y += j
                x -= i
                y -= j
                
                if x == destination[0] and y == destination[1]:
                    return True
                if  maze[x][y] != 2:
                    maze[x][y] = 2
                    queue.append((x,y))
        return False
                
