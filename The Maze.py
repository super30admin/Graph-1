# Time Complexity :  O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        q = [start]
        dirs = [[-1,0], [0,-1], [0, 1], [1,0]]
        m = len(maze)
        n = len(maze[0])

        maze[start[0]][start[1]] = -1

        while len(q) > 0:
            pair = q.pop(0)
            for dirn in dirs:
                i, j = pair[0], pair[1]
                while i >= 0 and i < m and j >= 0 and j < n and maze[i][j] != 1:
                    i += dirn[0]
                    j += dirn[1]
                i -= dirn[0]
                j -= dirn[1]
                if i == destination[0] and j == destination[1]:
                    return True
                if maze[i][j] != -1:
                    q.append([i,j])
                    maze[i][j] = -1
                
        return False