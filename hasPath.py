# TC:O(m+n)
# SC:O(mn)
#Ran successfully on leetcode:yes
#Approach:
#Use a queue. for every cur position, add new positions it can explore. 
#Create a visited array, if that loc is vosted mnipulate the value.
#When all the directions have been covered up, we remove a position value, ss, from the front of the queuequeue and again continue the same process with ss acting as the new startstart position.
#in order to choose the direction of travel, we make use of a dirdir array, which contains 4 entries. Each entry represents a one-dimensional direction of travel. 
#To travel in a particular direction, we keep on adding the particular entry of the dirsdirs array till we hit a wall or a boundary. For a particular start position, we do this process of dirdir addition for all all the four directions possible.
#If we hit the destination position at any moment, we return a True directly indicating that the destinationdestination position can be reached starting from the startstart position.

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        ROWS, COLS = len(maze), len(maze[0])
        visited = [[False for _ in range(COLS)] for _ in range(ROWS)]
        queue = deque()
        queue.append(start)
        visited[start[0]][start[1]] = True
        dirs = [(1,0), (-1,0), (0,1), (0,-1)]
        
        def is_valid(x,y):
            return x>=0 and x<ROWS and y>=0 and y<COLS and maze[x][y] != 1
        
        
        while queue:
            curr = queue.popleft()
            for d in dirs:
                x= curr[0]
                y= curr[1]
                if x==destination[0] and y == destination[1]:
                    return True
                #DFS part
                while(is_valid(x+d[0], y+d[1])):
                    x = x+d[0]
                    y = y+d[1]            
                if not visited[x][y]:
                    visited[x][y] = True
                    queue.append((x,y))
        return False

