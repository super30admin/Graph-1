class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #         if len(maze)==0:
        #             return False
        #         from collections import deque
        #         q=deque()
        #         q.append(start)

        #         m=len(maze)
        #         n=len(maze[0])
        #         while q:
        #             pop=q.popleft()
        #             maze[pop[0]][pop[1]]=2
        #             if pop[0]==destination[0] and pop[1]==destination[1]:
        #                 return True
        #             dirs=[(0,1),(-1,0),(1,0),(0,-1)]
        #             for dir in dirs:
        #                 i=pop[0]
        #                 j=pop[1]
        #                 while i>=0 and j>=0 and i<m and j<n and maze[i][j]!=1:
        #                     i=i+dir[0]
        #                     j=j+dir[1]
        #                 i=i-dir[0]
        #                 j=j-dir[1]
        #                 if maze[i][j]!=2:
        #                     q.append([i,j])
        #         return False
        # o(mn)-t,s

        if len(maze) == 0:
            return False

        def dfs(maze, start):
            if maze[start[0]][start[1]] == 2:
                return False
            maze[start[0]][start[1]] = 2
            if start[0] == destination[0] and start[1] == destination[1]:
                return True
            dirs = [(0, 1), (-1, 0), (1, 0), (0, -1)]
            for dir in dirs:
                i = start[0]
                j = start[1]
                while i >= 0 and j >= 0 and i < m and j < n and maze[i][j] != 1:
                    i = i + dir[0]
                    j = j + dir[1]
                    # print(i)
                i = i - dir[0]
                j = j - dir[1]
                # if maze[i][j]!=2:
                if dfs(maze, [i, j]):
                    return True
            return False

        m = len(maze)
        n = len(maze[0])
        return dfs(maze, start)