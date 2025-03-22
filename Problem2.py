# Problem 2 : The Maze
# Time Complexity : 
'''
BFS - O(m*n) where m is the number of rows in the matrix and n is the number of the column in matrix
DFS - O(m*n) where m is the number of rows in the matrix and n is the number of the column in matrix
'''
# Space Complexity : 
'''
BFS - O(m*n) where m is the number of rows in the matrix and n is the number of the column in matrix
DFS - O(m*n) where m is the number of rows in the matrix and n is the number of the column in matrix
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# BFS
from collections import deque 
from typing import List

class Solution:
    def hasPath(
        self, maze: List[List[int]], start: List[int], destination: List[int]
    ) -> bool:
        # edge case if the maze is None or length is 0 then return False
        if maze is None or len(maze) == 0:
            return False
        # get the length of the row of the matrix and length of the column of the matrix
        m = len(maze)
        n = len(maze[0])
        # define direction array for four direction
        directions = [[-1,0], [1,0], [0,-1], [0,1]]
        # define a deque
        q = deque()
        # check if the start position is equal to destination position and if it is then return True
        if start[0] == destination[0] and start[1] == destination[1]: return True
        # add the satrt position to the queue
        q.add([start])
        # mark the start position as visited by marking the cell as 2
        maze[start[0]][start[1]] = 2
        # loop through the queue is empty
        while (len(q) != 0):
            # get the first row and column from the queue
            currow, currcol = q.popleft()
            
            # loop through four direction
            for row, col in directions:
                # save the current row and column in new row and column variable
                newrow = currow
                newcol = currcol
                # loop till the newrow and new column is in limit and the cell position is not obstacle or it is not visited
                while 0 <= newrow < m and 0 <= newcol < n and (maze[newrow][newcol] == 0 or maze[newrow][newcol] == 2):
                    # increment the row and column
                    newrow += row
                    newcol += col
                # if we hit the boundary of the matrix or obstacle then go back one step
                newrow -= row
                newcol -= col
                # if the new row and column position is destination row and column then return True
                if(newrow == destination[0] and newcol == destination[1]):
                    return True
                # if the cell is not visited then added the position to the queue and mark the cell as visited by setting the value as 2
                if maze[newrow][newcol] != 2:
                    q.add((newrow, newcol))
                    maze[newrow][newcol] = 2
        # else return False
        return False

# DFS

class Solution:
    def hasPath(
        self, maze: List[List[int]], start: List[int], destination: List[int]
    ) -> bool:
        # edge case if the maze is None or length is 0 then return False
        if maze is None or len(maze) == 0:
            return False
        # get the length of the row of the matrix and length of the column of the matrix
        m = len(maze)
        n = len(maze[0])
        # define direction array for four direction
        directions = [[-1,0], [1,0], [0,-1], [0,1]]
        
        # dfs function for traversing the graph in dfs manner
        def dfs(maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
            # direction, m and n is global variable
            nonlocal directions, m, n
            # check if the start position is equal to destination position and if it is then return True
            if start[0] == destination[0] and start[1] == destination[1]:
                return True
            # check if the value of the start position is 2 then return False since the cell is already visited
            if maze[start[0]][start[1]] == 2:
                return False
            # mark the start position as visited by marking the cell as 2
            maze[start[0]][start[1]] = 2
            # loop through four direction
            for dir in directions:
                # save the start row and start column in new row and column variable
                newrow = start[0]
                newcol = start[1]
                
                # loop till the newrow and new column is in limit and the cell position is not obstacle or it is not visited
                while 0 <= newrow < m and 0 <= newcol < n and (maze[newrow][newcol] == 0 or maze[newrow][newcol] == 2):
                    # increment the row and column
                    newrow += dir[0]
                    newcol += dir[1]
                # if we hit the boundary of the matrix or obstacle then go back one step
                newrow -= dir[0]
                newcol -= dir[1]

                # if the cell in the matriz is not visited and and dfs function for that cell in the matrix return true then return true
                if maze[newrow][newcol] != 2 and dfs(maze, [newrow, newcol], destination):
                    return True
            # else return false
            return False
          