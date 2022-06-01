#The Maze
# // Time Complexity :  O(N*M)
# // Space Complexity : O(N*M)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



#BFS Solution
def has_path( maze, start, destination) -> bool:
    if start==[] or destination==[]: return False
    m = len(maze)
    n = len(maze[0])
    directions=[[1,0],[0,1],[-1,0],[0,-1]]
    queue=[(start[0], start[1])]                                        #add the start point to the queue
    maze[start[0]][start[1]]=2
    while(queue):
        location = queue.pop(0)
        for i in directions:
            row = location[0]
            col = location[1]
            while(row>=0 and row<m and col>=0 and col<n and maze[row][col]!=1):             #for every point in the queue, you go to 4 directions and keep going until you cant go any further
                row = row+i[0]
                col = col+i[1]
            row = row - i[0]                                                                #get back to the point you were at
            col= col - i[1]
            if maze[row][col]!=2:                                                       # if the point is not visited, check if its the destination, if not, mark it as visited and add it to the queue to explorte later
                if(destination[0]==row and destination[1]==col):
                    return True
                maze[row][col]=2
                queue.append((row, col))
    return False