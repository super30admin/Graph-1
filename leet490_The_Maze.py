# Solution

# // Time Complexity : O(m*n)
# // Space Complexity : O(m+n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Reason behind using BFS/DFS is because we are trying to find point to point

# First Approach is to use BFS to perform level order traversal. From the starting point move in all directions till you
# reach a cell with "1" since "1" represents Wall and ball can only stop there. Add that to queue, keep doing this till
# you find the destination or all the cells are processed. Remember to mark each cell added to queue as visited by putting
# "2" to that cell in matrix.

# Second Approach is using DFS, only difference between BFS and DFS is, in BFS we keep points in queue, cover all directions
# for a point and then go to the next point but in DFS we just keep processing the points we get instead of putting them in
# queue

import collections

# DFS Solution
def dfs(m,n,curr,destination,maze):
    dirs = [[0,1],[0,-1],[1,0],[-1,0]]
    
    for dir in dirs:
        r = curr[0]
        c = curr[1]
        
        while r<m and r>=0 and c<n and c>=0 and maze[r][c] != 1:
            r += dir[0]
            c += dir[1]
        
        r -= dir[0]
        c -= dir[1]
        
        if r == destination[0] and c == destination[1]:
            return True
        
        if maze[r][c] != 2:
            maze[r][c] = 2
            result = dfs(m,n,[r,c],destination,maze)
            if result == True:
                return True

def hasPath(maze, start, destination):

    # DFS Approach
    if start[0] == destination[0] and start[1] == destination[1]:
        return True

    
    maze[start[0]][start[1]] = 2

    m = len(maze)
    n = len(maze[0])

    result = dfs(m,n,start,destination,maze)
    
    if result == True:
        return True

    return False

# BFS Solution
# def hasPath(maze, start, destination):

#     if start[0] == destination[0] and start[1] == destination[1]:
#         return True

#     queue = collections.deque()
#     queue.append(start)
#     dirs = [[0,1],[0,-1],[1,0],[-1,0]]
#     maze[start[0]][start[1]] = 2

#     m = len(maze)
#     n = len(maze[0])

#     while queue:
#         curr = queue.popleft()

#         for dir in dirs:
#             r = curr[0]
#             c = curr[1]
#             while r<m and r>=0 and c<n and c>=0 and maze[r][c] != 1:
#                 r += dir[0]
#                 c += dir[1]
            
#             r -= dir[0]
#             c -= dir[1]

#             if r == destination[0] and c == destination[1]:
#                 return True
            
#             if maze[r][c] != 2:
#                 queue.append([r,c])
#                 maze[r][c] = 2
    
#     return False

if __name__ == "__main__":
    maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
    start = [0,4]
    destination = [4,4]        
    print(hasPath(maze, start, destination))