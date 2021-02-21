# Time Complexity: O(mxn)
# Space Complexity: O(mxn)
class Solution:
    
    
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if(maze == None or len(maze)==0):
            return False
        
        dirs = [(0,1),(-1,0),(1,0),(0,-1)]
        m = len(maze)
        n = len(maze[0])
        
        q = deque()
        
        # add starting point in q
        q.append((start[0],start[1]))
        maze[start[0]][start[1]] = 2
        # while q has elements, process them
        while(len(q) > 0):
            curr = q.popleft()
            # check if you have reached the destination
            if(curr[0] == destination[0] and curr[1]==destination[1]):
                return True
            # for each node, traverse each direction 
            # and add the end node as child into the q
            for dir in dirs:
                i = curr[0]
                j = curr[1]
                # traverse till the end in the current direction
                while(i>=0 and j>=0 and i<m and j<n and maze[i][j] != 1):
                    i += dir[0]
                    j += dir[1]
                
                # condition has breached so reset i,j to the cell before a boundary or wall
                i -= dir[0]
                j -= dir[1]
                
                # add child to q only if it is not visited
                if(maze[i][j] != 2):
                    q.append((i,j))
                    maze[i][j] = 2
        return False
        