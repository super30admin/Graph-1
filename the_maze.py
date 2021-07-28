# Time Complexity:O(mn)
# Space Complexity: O(mn)

from collections import deque


class Solution:
    def hasPath(self, maze, start, destination):
        # Checking if the destination is 1 if then we will never be able to reach there
        if maze[start[0]][start[1]] == 1 or maze[destination[0]][destination[1]] == 1:
            return False

        m = len(maze)
        n = len(maze[0])
        # We will define queue and will start with start location
        q = deque()
        visited = set()

        q.append((start[0], start[1]))

        dirc = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        # We will iterate until queue is empty and will check if the current popped values are
        # equal to the destination if then return true
        # Else we will iterate over its immediate children and and will stop only when 1 is there
        #  and we will check if that location is present in visited matrix and if not then only we will be adding
        #  to queue as well as visited matrix
        while q:

            row, col = q.popleft()
            if row == destination[0] and col == destination[1]:
                return True

            for d in dirc:

                r = row + d[0]
                c = col + d[1]

                while 0 <= r < m and 0 <= c < n and maze[r][c] == 0:
                    r += d[0]
                    c += d[1]

                if not (r - d[0], c - d[1]) in visited:
                    visited.add((r - d[0], c - d[1]))
                    q.append((r - d[0], c - d[1]))

        return False
