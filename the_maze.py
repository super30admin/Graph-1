# https://leetcode.com/problems/the-maze/
# Time Complexity- O(m*n) Space Complexity- O(m*n)

from collections import deque
class Solution:
    def hasPath(self, maze, start, destination):
        # initialising the direction array
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        # finding the rows of the maze
        self.m = len(maze)
        # finding the columns of the maze
        self.n = len(maze[0])

        # intialise the queue
        q = deque()
        # append the queue with the starting position
        q.append([start[0], start[1]])
        # mark the visited position as -1 to prevent it visiting again
        maze[start[0]][start[1]] = -1

        while q:
            # pop the element from the queue which is the current cell([r,c])
            curr = q.popleft()
            # check all 4 directions of the ball
            for dir in self.dirs:
                # start moving one step in the current direction from the current cell
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]
                # check the condition of out of bounce and obstacles
                while r >= 0 and c >= 0 and r < self.m and c < self.n and maze[r][c] != 1:
                    #keep moving thte ball in that direction until it hits the wall
                    r += dir[0]
                    c += dir[1]
                # step back by one cell because ball hits the wall
                r -= dir[0]
                c -= dir[1]
                # check if the stopping point is the given destination
                if r == destination[0] and c == destination[1]:
                    return True
                #  check the stopping point is not visited before
                if maze[r][c] != -1:
                    # append the queue with new position
                    q.append([r,c])
                    # mark it as visited
                    maze[r][c] = -1

        return False
    
solution = Solution()
print(solution.hasPath([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]],[0,4],[3,2]))