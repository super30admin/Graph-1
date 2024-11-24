#Time Complexity: O(m⋅n), where m is the number of rows and n is the number of columns. Each cell is processed once
#Space Complexity: O(m⋅n), for the queue in the worst case.
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #Base Case
        if(start[0]==destination[0] and start[1]==destination[1]):
            return True
        #Length of row and column of maze
        m = len(maze)
        n = len(maze[0])
        #Direction array to check if the ball can move in each direction from the curr positon
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        #Queue to store visited position
        q = deque()
        #Initially add the starting position as it is already visisted
        q.append([start[0],start[1]])
        #Mark the visisted as 2 in the maze
        maze[start[0]][start[1]] = 2
        #Process the queue until all positions are processed until the goal is reached
        while(len(q)>0):
            #Pop the element to be processed from the queue
            curr = q.popleft()
            for dir in dirs:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]
                #Check if the direction from current position is a wall(1) or not 
                while(r>=0 and c>=0 and r<m and c<n and maze[r][c]!=1): 
                    #If not we can further move in that direction until we hit a wall
                    r+=dir[0] 
                    c+=dir[1]
                #If we hit a wall then we want to start looking for other directions in previous position so return back to that
                r-=dir[0]
                c-=dir[1]
                #Check if the current position is the destination
                if(destination[0]==r and destination[1]==c):
                    return True
                #If not, then check if it is already visisted, If not add to the queue
                if(maze[r][c]!=2):
                    q.append([r,c])
                    maze[r][c]=2
        return False