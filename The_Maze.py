# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS Approach. Initialize a queue with the start position and mark it visited
# Until queue is not empty pop the queue and check if the row and col are destination if yes return True
# Else check the neighbors in each direction for row and col
# Since we cannot have immediate neighbors as we need to roll the ball until it hits a wall or a boundary
# We need to keep increasing r and c for that same dir r = r + dir[0] and c = c + dir[1]
# The position of r and c will be the wall or boundary we need to bring it back to previous cell and check if the cell is visited or not
# If not then add it to queue and mark it visited
# Return False if the ball cant stop at destination


from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int],
                destination: List[int]) -> bool:
        if not maze:
            return None
        dirs = {(0,1), (1,0), (0,-1), (-1,0)}
        queue = deque([(start)])
        maze[start[0]][start[1]] = 2
        m = len(maze)
        n = len(maze[0])
        while queue:
            row, col = queue.popleft()
            if (row,col) == (destination[0],destination[1]):
                return True
            for dir in dirs:
                r = dir[0] + row
                c = dir[1] + col
                while r >= 0 and r < m and c >= 0 and c < n and maze[r][c] != 1:
                    r = r + dir[0]
                    c = c + dir[1]
                # bring ball back by one step
                r = r - dir[0]
                c = c - dir[1]
                if maze[r][c] != 2:
                    queue.append((r,c))
                    maze[r][c] = 2
            
        return False
#Time - O(MN)
#Space - O(MN)

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int],
                destination: List[int]) -> bool:
        if not maze:
            return None
        self.m = len(maze)
        self.n = len(maze[0])
        return self.helper(maze, destination, start[0], start[1])

    def helper(self, maze, destination, row, col): 
        if row < 0 or row >= self.m or col < 0 or col >= self.n:
            return
        if (row,col) == (destination[0], destination[1]):
            return True
        maze[row][col] = 2
        dirs = {(0,1), (1,0), (0,-1), (-1,0)}
        for dir in dirs:
            r = row + dir[0]
            c = col + dir[1]
            while r >= 0 and r < self.m and c >= 0 and c < self.n and maze[r][c] != 1:
                r = r + dir[0]
                c = c + dir[1]
            r = r - dir[0]
            c = c - dir[1]
            if maze[r][c] != 2:
                if self.helper(maze, destination, r, c):
                    return True
        return False
