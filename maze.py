# STEPS:
# Breadth first search using queues
# begin by adding start location to the queue
# traverse to all the four directions one by one (up/left/right/down) until you find a wall.
# add the new node to the queue, if was not already visited.
# pop the nodes out of the queue, and check in all directions from that node.
# return True, if the end node is reachable. else, return False
# Time complexity - O(nm)
# Space complexity - O(nm) # all the nodes
# Did this code run on leetcode? - yes
# Did you encounter any issues while running this code? - no
from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # grid size
        m, n = len(maze), len(maze[0])
        
        # edge case 
        # check if destination is on the corner of the maze
        # check if the up / down / left/ right grid column of the maze is a wall.
        # r, c = destination
        # if not (r == 0 or r == m-1 or c == 0 or c == n-1 or maze[r+1][c] == 1 or maze[r-1][c] == 1 or maze[r][c+1] == 1 or maze[r][c-1] == 1):
        #     return False
            
        
        # add the start position in the queue
        mazequeue = deque()
        mazequeue.append(start)
        
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while mazequeue:
            # print(mazequeue)
            curr = mazequeue.popleft()
            if curr == destination:
                return True
          
            maze[curr[0]][curr[1]] = 2 # mark the node as visited
            
            for direction in directions:
                temp = curr
                # traverse in the directions (right, left, up, down)
                while 0<=temp[0]<m and 0<=temp[1]<n:
                    if maze[temp[0]][temp[1]] == 1:
                        break
                    temp = [temp[0]+direction[0], temp[1]+direction[1]]
                
                if maze[temp[0]-direction[0]][temp[1]-direction[1]] == 0:
                    mazequeue.append([temp[0]-direction[0], temp[1]-direction[1]])
                            
        return False
        
    
# STEPS:
# Depth first search
# begin by adding start location to the queue
# traverse to all the four directions one by one (up/left/right/down) until you find a wall.
# add the new node to the queue, if was not already visited.
# pop the nodes out of the queue, and check in all directions from that node.
# return True, if the end node is reachable. else, return False
# Time complexity - O(nm)
# Space complexity - O(nm) # all the nodes
# Did this code run on leetcode? - yes
# Did you encounter any issues while running this code? - no

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # grid size
        m, n = len(maze), len(maze[0])
        # directions array
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        
        def rec(node):
            # if the current node is the destination, return True
            if node == destination:
                return True
            # mark the node as visited
            maze[node[0]][node[1]] = 2 
            
            # traverse from that current node
            for direction in directions:
                temp = node
                
                while 0<=temp[0]<m and 0<=temp[1]<n:
                    if maze[temp[0]][temp[1]] == 1:
                        break
                    # traverse in the directions (up, down, left, right)
                    temp = [temp[0]+direction[0], temp[1]+direction[1]]
                
                # since the node is either on a wall or on the corner
                # we check one step back.
                temp = [temp[0]-direction[0], temp[1]-direction[1]]
                if maze[temp[0]][temp[1]] == 0:
                    if rec(temp):
                        return True
        
           
        return rec(start)
        