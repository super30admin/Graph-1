# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

# BFS.
from collections import deque


class Solution:
    def hasPath(self, maze, start, destination):
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        m = len(maze)
        n = len(maze[0])
        queue = deque()
        queue.append(start)
        while queue:
            pop = queue.popleft()
            maze[pop[0]][pop[1]] = -1
            for x in dirs:
                x_i = pop[0] + x[0]
                x_j = pop[1] + x[1]
                while (0 <= x_i < m and 0 <= x_j < n) and maze[x_i][x_j] != 1:
                    x_i += x[0]
                    x_j += x[1]
                x_i -= x[0]
                x_j -= x[1]
                if x_i == destination[0] and x_j == destination[1]:
                    return True
                if maze[x_i][x_j] != -1:
                    queue.append([x_i, x_j])
        return False


print(Solution().hasPath([[0, 0, 1, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 1, 0], [1, 1, 0, 1, 1], [0, 0, 0, 0, 0]], [0, 4],
                         [3, 0]))


# DFS.
# class Solution:
#     def helper(self, maze, start, destination, m, n):
#         # base
#         if start == destination:
#             self.flag = True
#             return
#         maze[start[0]][start[1]] = -1
#         # logic
#         for x in self.dirs:
#             x_i = x[0] + start[0]
#             x_j = x[1] + start[1]
#             if 0 <= x_i < m and 0 <= x_j < n:
#                 while (0 <= x_i < m and 0 <= x_j < n) and maze[x_i][x_j] != 1:
#                     x_i += x[0]
#                     x_j += x[1]
#                 x_i -= x[0]
#                 x_j -= x[1]
#                 if maze[x_i][x_j] != -1:
#                     self.helper(maze, [x_i, x_j], destination, m, n)
#
#     def hasPath(self, maze, start, destination):
#         self.dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
#         m = len(maze)
#         n = len(maze[0])
#         self.flag = False
#         self.helper(maze, start, destination, m, n)
#         return self.flag
#
#
# print(Solution().hasPath([[0, 0, 1, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 1, 0], [1, 1, 0, 1, 1], [0, 0, 0, 0, 0]], [0, 4],
#                          [3, 0]))
