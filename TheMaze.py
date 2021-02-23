# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS Approach. Initialize a queue with the start position and mark it visited
# Until queue is not empty pop the queue and check if the row and col are destination if yes return True
# Else check the neighbors in each direction for i and j
# Since we cannot have immediate neighbors as we need to roll the ball until it hits a wall or a boundary
# We need to keep increasing i and j for each direction
# The position of i and j will be the wall or boundary we need to bring it back to previous cell and check if the cell is visited or not
# If not then add it to queue and mark it visited
# Return False if the ball cant stop at destination

from collections import deque


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int],
                destination: List[int]) -> bool:
        if not maze:
            return None

        queue = deque([])
        queue.append(start[0], start[1])
        maze[start[0], start[1]] = 2
        while queue:
            row, col = queue.popleft()
            if row == destination[0] and col == destination[1]:
                return True
            neighbors = [(0, 1), (1, 0), (-1, 0), (0, -1)]
            for neighbor in neighbors:
                i = row
                j = col
                while i >= 0 and i < len(maze) and j >= 0 and j < len(
                        maze[0]) and maze[i][j] != 1:
                    i += neighbor[0]
                    j += neighbor[1]
                # bring ball back by one step
                i -= neighbor[0]
                j -= neighbor[1]
                if maze[i][j] != 2:
                    queue.append(maze[i][j])
                    maze[i][j] = 2
        return False
