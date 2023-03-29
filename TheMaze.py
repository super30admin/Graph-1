
#All leetcode TC could not be tested as it is premium problem.

import collections
class Solution:
    

    def has_path(self, maze, start, destination):

        #Here we use BFS approach. We begin by adding start row and col to queue. Each element poped from queue is check for all 4 direction neighbours till the wall is reached. All visited cells are marked as 2 to avoid revisit.
        #Time complexity - O(m.n)
        #Space complexity -O(m.n) - queue size can go uptill all elements of maze
        m = len(maze)
        n = len(maze[0])
        directions = [[1,0],[-1,0], [0,-1], [0,1]]

        q = collections.deque()
        q.append((start[0], start[1]))
        maze[start[0]][start[1]] = 2

        while q:
            r, c = q.popleft()
            for dr, dc in directions:
                nr = r
                nc = c
                while nr>=0 and nc>=0 and nr<m and nc<n and maze[nr][nc]!=1:
                    nr = nr + dr
                    nc = nc + dc
                nr = nr - dr
                nc = nc - dc

                if maze[nr][nc]!=2:
                    q.append((nr,nc))
                    maze[nr][nc]=2
                    if nr==destination[0] and nc==destination[1]:
                        return True
        return False




s = Solution()
res = s.has_path([[0,0,1,0,0],
 [0,0,0,0,0],
 [0,0,0,1,0],
 [1,1,0,1,1],
 [0,0,0,0,0]
], [0,4], [4,4])

print(res)