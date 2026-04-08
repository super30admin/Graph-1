# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We simulate a ball rolling in the maze until it hits a wall in all 4 directions using BFS.
# Once it stops, we check if that position is the destination; if not visited, we enqueue it.
# We mark visited positions in-place by setting them to -1 to avoid cycles.

class Solution:
    def hasPath(self, maze, start, destination):
        self.dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        self.m = len(maze)
        self.n = len(maze[0])

        q = collections.deque()
        q.append([start[0], start[1]])
        maze[start[0]][start[1]] = -1

        while q:
            curr = q.popleft()
            for dir in self.dirs:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]

                while r >= 0 and c >= 0 and r < self.m and c < self.n and maze[r][c] != 1:
                    r += dir[0]
                    c += dir[1]

                r -= dir[0]
                c -= dir[1]

                if r == destination[0] and c == destination[1]:
                    return True
                if maze[r][c] != -1:
                    q.append([r, c])
                    maze[r][c] = -1

        return False
