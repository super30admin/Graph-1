"""
Problem : 2

Time Complexity : 

BFS - O(m*n)
DFS - O(m*n)

Space Complexity : 
BFS - O(m*n)
DFS - O(m*n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

BFS - 
Performing BFS from the start point through the entire matrix, changing the value of each cell that has been previously visited, to avoid
visiting again and where the ball stopped previously, if stopped at the cell whoch is not visited, checking if it matches the destination,
if yes, then returning true, else adding that cell in the queue to traverese its neighbors and marking it visited

"""

# The Maze

# Approach - 1
# BFS

class Solution(object):
    def __init__(self):
        self.direction=[[-1,0],[1,0],[0,-1],[0,1]]

    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        if not maze:
            return False
        
        m=len(maze)
        n=len(maze[0])

        q=collections.deque()
        maze[start[0]][start[1]]=2
        q.append(start)

        while q:
            curr=q.popleft()
            for dir in self.direction:
                i=curr[0]
                j=curr[1]
                while i<m and j<n and i>=0 and j>=0 and maze[i][j]!=1:
                    i+=dir[0]
                    j+=dir[1]
                i-=dir[0]
                j-=dir[1]
                if maze[i][j]!=2:
                    if i==destination[0] and j==destination[1]:
                        return True
                    q.append([i,j])
                    maze[i][j]=2

        return False
    
# Approach - 2
# DFS

class Solution(object):
    def __init__(self):
        self.direction=[[-1,0],[1,0],[0,-1],[0,1]]
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        if not maze:
            return False
        m=len(maze)
        n=len(maze[0])
        if start[0]==destination[0] and start[1]==destination[1]:
            return True
        maze[start[0]][start[1]]=2
        return self.dfs(maze,start[0],start[1],destination,m,n)
    def dfs(self,maze,i,j,destination,m,n):

        # base
        if i==destination[0] and j==destination[1]:
            return True
        # logic
        for dirs in self.direction:
            r=i
            c=j
            while r>=0 and r<m and c<n and c>=0 and maze[r][c]!=1:
                r+=dirs[0]
                c+=dirs[1]
            r-=dirs[0]
            c-=dirs[1]
            if maze[r][c]!=2:
                maze[r][c]=2
                if self.dfs(maze,r,c,destination,m,n):
                    return True
                
        return False