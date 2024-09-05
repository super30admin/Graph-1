# Graph-1

## Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        inorder = [0] * (n + 1)
        for i,j in trust:
            inorder[i] -= 1
            inorder[j] += 1

        for i in range(1,len(inorder)):
            if inorder[i] == n - 1:
                return i

        return -1
# TC = O(V+E), SC = O(V)

## Problem2 The Maze (https://leetcode.com/problems/the-maze/) - Premium Leetcode

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        dr = [1,-1,0,0]
        dc = [0,0,1,-1]
        flag = False
        def helper(r,c):
            nonlocal flag
            if maze[r][c] == 2:
                return
            if r == destination[0] and c == destination[1]:
                flag = True
                return
            maze[r][c] = 2
            for i in range(4):
                nr = r
                nc = c
                while nr >= 0 and nc >= 0 and nr < len(maze) and nc < len(maze[0]) and maze[nr][nc] != 1:
                    nr += dr[i]
                    nc += dc[i]

                nr -= dr[i]
                nc -= dc[i]
                helper(nr,nc)


        helper(start[0],start[1])
        return flag
# TC = O(m * n), SC = O(m * n)

        #BFS
        # dr = [1,-1,0,0]
        # dc = [0,0,1,-1]
        # queue = deque()
        # queue.append(start)
        # maze[start[0]][start[1]] = 2
        # while queue:
        #     curr = queue.popleft()
        #     maze[curr[0]][curr[1]] = 2
        #     for i in range(4):
        #         nr = curr[0]
        #         nc = curr[1]
        #         while nr >= 0 and nc >= 0 and nr < len(maze) and nc < len(maze[0]) and maze[nr][nc] != 1:
        #             nr += dr[i]
        #             nc += dc[i]

        #         nr -= dr[i]
        #         nc -= dc[i]
        #         if nr == destination[0] and nc == destination[1]:
        #             return True

        #         if maze[nr][nc] != 2:
        #             queue.append([nr,nc])


        # return False
