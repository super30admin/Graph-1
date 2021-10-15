#Time Complexity : O(mn^2)
#Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze) == 0:
            return False
        m = len(maze)
        n = len(maze[0])
        q = deque()
        q.append(start)
        maze[start[0]][start[1]] = 2
        dirs = [(0,1), (0, -1), (-1, 0), (1,0)]
        while q:
            curr = q.popleft()
            for d in dirs:
                i = curr[0]
                j = curr[1]
                while (i<m and j<n and i>= 0 and j>= 0 and maze[i][j] != 1):
                    i += d[0]
                    j += d[1]
                i -= d[0]
                j -= d[1]
                if maze[i][j] == 0:
                    if i == destination[0] and j == destination[1]:
                        return True
                    maze[i][j] = 2
                    q.append([i, j])
        return False
                