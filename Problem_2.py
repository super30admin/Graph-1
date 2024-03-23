'''
Time Comlexity - O((m*n)+(m+n))
Space Complexity - O(max(m,n)) for BFS as at worst we may have all the elements of the row in the queue

Works on LeetCode
'''
def solveMaze(start, destination, maze):
    if start[0] == destination[0] and start[1]==destination[1]:#check if the start position is the destionation
        return True
    m, n = len(maze), len(maze[0])
    dirs = [[-1,0],[1,0],[0,-1],[0,1]] #create directions array
    return dfs(start, destination, maze, dirs) #DFS approach
    # BFS Approach
    # queue = deque()
    # queue.append(start) #put start position in queue
    # maze[start[0]][start[1]] = 2 #mark it visited
    # dirs = [[-1,0],[1,0],[0,-1],[0,1]] 
    # while queue:
    #     currPos = queue.popleft() #take first position in the maze in queue
    #     for dir in dirs:
    #         r = currPos[0]
    #         c = currPos[1]
    #         while(r>=0 and r<m and c>=0 and c<n and maze[r][c]!=1): #traverse till we don't find a wall
    #             r+=dir[0] 
    #             c+=dir[1]
    #         r -= dir[0] #right now we actually in a wall, we need to be back in the maze which is one step previous hence -dir[0]. -dir[1]
    #         c -= dir[1] 
    #         if r == destination[0] and c==destination[1]: #chec if the position is the destionation
    #             return True
    #         if maze[r][c] != 2: #check if position has been visited before
    #             queue.append([r,c]) #if not then add the position to the queue
    #             maze[r][c] = 2 #mark it visited
    # return False #return False if we do not reach destination
    
#DFS Approach
def dfs(start, destination, maze, dirs):
    if start[0] == destination[0] and start[1] == destination[1]:       #check if current position is destination 
        return True
    if maze[start[0]][start[1]] == 2: #check if position has been visited before and do not move ahead if yes
        return False
    maze[start[0]][start[1]] = 2 #mark position as visited
    for dir in dirs:
        #loop logic is same as dfs except at the end we recurse instead of iteration
        r = start[0]
        c = start[1]
        while r>=0 and r < len(maze) and c >= 0 and c<len(maze[0]) and maze[r][c]!= 1:
            r+=dir[0]
            c+=dir[1]
        r -= dir[0]
        c -= dir[1]
        if dfs([r,c], destination, maze, dirs) :
            return True
    return False
                 
    

maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
print(solveMaze([0,4],[4,4], maze))
                
            