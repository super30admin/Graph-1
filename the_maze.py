# Time Complexity: O(mn)
# Space Complexity: O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We perform a simple DFS search to find the destination. We keep track of the visited nodes so that we don't visit the same node again.
"""

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None or len(maze) == 0: return False
        self.maze = maze; self.destination = destination
        self.isFound = False
        self.visited = [[False for _ in range(len(maze[0]))] for _ in range(len(maze))]

        self.dfs(start)
        return self.isFound



    def dfs(self, start):
        if self.isFound == True: return
        if start == self.destination: self.isFound = True; return
        if self.visited[start[0]][start[1]] == True: return
        self.visited[start[0]][start[1]] = True

        #go up
        up = start[0] - 1
        while up >= 0 and self.maze[up][start[1]] == 0:
            up -= 1
        self.dfs([up + 1, start[1]])

        # go down
        down = start[0] + 1
        while down < len(self.maze) and self.maze[down][start[1]] == 0:
            down += 1
        self.dfs([down - 1, start[1]])

        # go right
        right = start[1] + 1
        while right < len(self.maze[0]) and self.maze[start[0]][right] == 0:
            right += 1
        self.dfs([start[0], right - 1])

        # go left
        left = start[1] - 1
        while left >= 0 and self.maze[start[0]][left] == 0:
            left -= 1
        self.dfs([start[0], left + 1])