'''
In place (NO visited array):
Time Complexity : O(m*n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Add start position to the queue. Keep moving the cursor until we reach a wall. Once we reach the wall we
mark the new position as 2 to indicate that we have visited the cell and add it to queue if not visited
and use this new position to discover more cells, keep doing this until we reach the destination.

Using Visited Array Space O(m*n) (hasPathVisited function):
Time Complexity : O(m*n)
Space Complexity : O(m*n)
Did this code successfully run on Leetcode : Yes
Explanation: Add start position to the queue. Create a visited list to keep track of visited cells, keep moving the cursor
until we reach a wall. Once we reach the wall we mark the new position as visited and add it to queue if not visited
use this new position to discover more cells, keep doing this until we reach the destination.
'''


class Solution:
    def isValid(self, x: int, y: int, maze: List[List[int]]):
        return x >= 0 and x < len(maze) and y >= 0 and y < len(maze[0])

    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]

        queue = []
        queue = [(start[0], start[1])]
        maze[start[0]][start[1]] = 2

        while len(queue) != 0:
            current = queue[0]
            queue = queue[1:]

            if current[0] == destination[0] and current[1] == destination[1]:
                return True

            for i in range(0, 4):

                x = current[0] + dx[i]
                y = current[1] + dy[i]

                while self.isValid(x, y, maze) and maze[x][y] != 1:
                    x += dx[i]
                    y += dy[i]

                x -= dx[i]
                y -= dy[i]

                if maze[x][y] != 2:
                    maze[x][y] = 2
                    queue.append((x, y))

        return False

    def hasPathVisited(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        visited = [[False for i in range(len(maze[0]))] for j in range(len(maze))]
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]

        queue = []
        queue = [(start[0], start[1])]
        visited[start[0]][start[1]] = True

        while len(queue) != 0:
            current = queue[0]
            queue = queue[1:]

            if current[0] == destination[0] and current[1] == destination[1]:
                return True

            for i in range(0, 4):
                x = current[0] + dx[i]
                y = current[1] + dy[i]

                while self.isValid(x, y, maze) and maze[x][y] != 1:
                    x += dx[i]
                    y += dy[i]

                x -= dx[i]
                y -= dy[i]

                if not visited[x][y]:
                    visited[x][y] = True
                    queue.append((x, y))

        return False



