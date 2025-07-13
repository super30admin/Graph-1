from typing import List
import collections
# class Solution:
#     def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
#         m = len(maze)
#         n = len(maze[0])
#         q = collections.deque([start])
#         maze[start[0]][start[1]] = 2
#         dirs = [[0,1],[1,0],[-1,0],[0,-1]]
#         while q:
#             curr = q.popleft()
#             for d in dirs:
#                 r, c = curr[0], curr[1]
#                 while r>=0 and r<m and c<n and c>=0 and maze[r][c]!=1:
#                     r+=d[0]
#                     c+=d[1]
#                 # step back
#                 r-=d[0]
#                 c-=d[1]
#                 if r == destination[0] and c == destination[1]:
#                     return True
#                 elif maze[r][c]!=2:
#                     q.append([r,c])
#                     maze[r][c] = 2
#         return False


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        def helper(maze, start , destination,m , n):
            # base
            if start[0] == destination[0] and start[1]== destination[1]: return True
            if maze[start[0]][start[1]] == 2: return False

            maze[start[0]][start[1]] = 2
            # logic
            for d in dirs:
                r, c = start[0], start[1]
                while r>=0 and r<m and c<n and c>=0 and maze[r][c]!=1:
                    r+=d[0]
                    c+=d[1]
                # step back
                r-=d[0]
                c-=d[1]
                if helper(maze, [r,c], destination,m,n):
                    return True
            return False
        return helper(maze,start, destination,m,n)

        

        