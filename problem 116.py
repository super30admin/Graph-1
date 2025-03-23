# https://leetcode.com/problems/the-maze/


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) ->bool:

        if maze == None or len(maze) == 0:
            return False
        
        m = len(maze)
        n = len(maze[0])
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        q = deque()
        q.append(start)
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        while q:
            curr = q.popleft()
            for d in dirs:
                nr = curr[0] + d[0]
                nc = curr[1] + d[1]

                while nr >= 0 and nr < m and nc >= 0 and nc < n and maze[nr][nc] != 1:
                    nr += d[0]
                    nc += d[1]
                nr -= d[0]
                nc -= d[1]

                if nr == destination[0] and nc == destination[1]:
                    return True
                if maze[nr][nc] != 2:
                    q.append([nr, nc])
                    maze[nr][nc] = 2
        return False

# TC: O(m*n)
# SC: O(m*n)


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) ->bool:

        if maze == None or len(maze) == 0:
            return False
        
        self.m = len(maze)
        self.n = len(maze[0])
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        return self.dfs(maze,start,destination,self.m,self.n,self.dirs)
    
    def dfs(self, maze: List[List[int]], start: List[int], destination: List[int],m,n,dirs) -> bool: 
        # base
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        if maze[start[0]][start[1]] == 2:
            return False
        
        # marking visited
        maze[start[0]][start[1]] = 2
        # exploring all possible directions
        for d in self.dirs:
            nr = start[0] 
            nc = start[1] 

            while nr >= 0 and nr < m and nc >= 0 and nc < n and maze[nr][nc] != 1:
                nr += d[0]
                nc += d[1]
            # hitting wall and taking a step back
            nr-=d[0]
            nc+=d[1]

            # reached destination or not check ( a recursive call)
            if nr == destination[0] and nc == destination[1]:
                return True
            ne = [nr,nc]
            if self.dfs(maze,ne,destination,m,n,self.dirs):
                return True
        return False

# TC: O(m*n)
# SC: o(m*n) + recursive stack space