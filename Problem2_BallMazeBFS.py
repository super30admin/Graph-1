'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 490. The Maze


# https://leetcode.com/problems/the-maze/

#-----------------
# Time Complexity: 
#-----------------
# O(M * N * (max(M, N))): Go to atmost M*N nodes, search atmost 2M + 2N comparisons
#                         at each node
#------------------
# Space Complexity: 
#------------------
# O(M * N) - Recursive Stack holds M*N cells

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

import collections
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        m = len(maze)
        n = len(maze[0])
        if maze is None:
            return False
        
        #BFS SOLUTION
        queue = collections.deque()
        queue.append([start[0], start[1]])
        
        # 2 is used to stored visited status
        maze[start[0]][start[1]] = 2
        
        while len(queue) > 0 :
            curr = queue.popleft()
            for direction in dirs:
                i = curr[0]
                j = curr[1]
                while(i < m and i >= 0 and j >= 0 and j < n and maze[i][j] != 1):
                    i += direction[0]
                    j += direction[1]
                
                #bring back one step because we are at the cell with the obstacle
                i -= direction[0]
                j -= direction[1]
                
                if maze[i][j] != 2:
                    if i == destination[0] and j == destination[1]:
                        return True
                    else:
                        queue.append([i, j])
                        maze[i][j] = 2
        
        return False