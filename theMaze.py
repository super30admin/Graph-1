# Time:O(m*n) traversal
# Space:O(m*n) every item goes in queue
# Leetcode: yes
# Issues:No need for dp matrix


from collections import deque
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        dirs = [(-1,0),(1,0),(0,1),(0,-1)]

        q = deque()                                 # we will use bfs 
        q.append((start[0],start[1]))
        maze[start[0]][start[1]] = -1               # we set -1 to all visited locations

        while q:
            curr = q.popleft()

            for di in dirs:
                r = di[0] + curr[0]                 
                c = di[1] + curr[1]

                while r>=0 and c >=0 and r<m and c<n and maze[r][c] != 1:
                    r += di[0]
                    c += di[1]
                r -= di[0]                                        # go back 1 step
                c -= di[1]                                        # go back 1 step

                if r == destination[0] and c == destination[1]:     # is this out output?
                    return True
                if maze[r][c] != -1:                                # was it already visited?
                    q.append((r,c))                                 # add to queue
                    maze[r][c] = -1                                 # mark as visited

        return False