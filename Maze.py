'''
Solution:
1.  Perform a BFS with only one extra condition that the ball needs to keep rolling until hit by a wall.
2.  Put the next possible cell in the queue (from all 4 directions) and check whether you are reached
    the destination cell.
3.  If reached, return True; else return False

Time Complexity:    O(rows x cols)  |   Space Complexity:   O(1)
'''

from collections import deque

class Solution:

    def __isValid(self, maze, row, col):

        #   function to check whether the cell is in bounds and not 0 or 2
        rows = len(maze)
        cols = len(maze[0])

        if (row >= 0 and row < rows and col >= 0 and col < cols and
                (maze[row][col] == 0 or maze[row][col] == 2)):
            return True

        return False

    def hasPath(self, maze, start, destination):

        #   edge case check
        if (maze == None or len(maze) == 0):
            return False

        #   initializations
        rows = len(maze)
        cols = len(maze[0])

        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        queue = deque([start])

        maze[start[0]][start[1]] = 2

        #   iterate until the queue is empty
        while(len(queue) > 0):

            top = queue.popleft()

            row = top[0]
            col = top[1]

            #   if destination cell found => return True
            if (row == destination[0] and col == destination[1]):
                return True

            #   in all 4 directions
            for i in range(len(dirs)):

                newRow = row
                newCol = col

                #   the ball needs to be moving until hit by a wall
                while (self.__isValid(maze, newRow, newCol)):
                    newRow += dirs[i][0]
                    newCol += dirs[i][1]

                newRow -= dirs[i][0]
                newCol -= dirs[i][1]

                #   push it to the queue and mark the cell visited
                if (maze[newRow][newCol] != 2):
                    queue.append([newRow, newCol])
                    maze[newRow][newCol] = 2

        #   return False if queue is empty
        return False
