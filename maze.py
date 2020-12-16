#Time Complexity : O(mn) where m and n are the number of rows and columns in the maze
#Space Complexity : O(mn)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze:
            return False
        directions = [[0,1], [1,0], [-1, 0], [0,-1]]
        q = deque()
        q.append(start)
        #make starting position as visited
        maze[start[0]][start[1]] = 2
        while q:
            x, y = q.popleft()
            #if the ball has stopped at the destination return True
            if x == destination[0] and y == destination[1]:
                return True
            for i, j in directions:
                newX = x
                newY = y
                #keep rolling the ball till it reaches the walls of the maze or some obstacle
                while newX >= 0 and newX < len(maze) and newY >= 0 and newY < len(maze[0]) and maze[newX][newY] != 1:
                    newX += i
                    newY += j
                #bring ball to it's correct position
                newX -= i
                newY -= j
                #if ball hasn't visited the current location then add it to the queue and mark it visited
                if maze[newX][newY] != 2:
                    q.append([newX, newY])
                    maze[newX][newY] = 2

          return False
