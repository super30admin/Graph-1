# Time Complexity : O(M*N)
# Space Complexity : O(M*N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def hasPath(self, maze, start, destination):
        # write your code here
        Q = [start]
        n = len(maze)
        m = len(maze[0])
        dirs = ((0, 1), (0, -1), (1, 0), (-1, 0))
        while Q:
            i, j = Q.pop(0)
            maze[i][j] = 2
            if i == destination[0] and j == destination[1]:
                return True
            for x, y in dirs:
                row = i + x
                col = j + y
                while 0 <= row < n and 0 <= col < m and maze[row][col] != 1:
                    row += x
                    col += y
                row -= x
                col -= y
                if maze[row][col] == 0:
                    Q.append([row, col])
        
        return False