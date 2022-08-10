# TC: O(m*n)
# SC : O(m*n)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # init q, m, n
        q = deque()
        m, n = len(maze), len(maze[0])
        # define dirs
        dirs = ((0,1), (1,0), (-1,0), (0,-1))
        # add start point to maze and mark it visited
        q.append(start)
        maze[start[0]][start[1]] = 2
        
        while q:
            i, j = q.popleft()
            for dr, dc in dirs:
                nr = i + dr
                nc = j + dc
                while nr >= 0 and nr < m and nc >=0 and nc < n and maze[nr][nc] != 1:
                    nr += dr
                    nc += dc
                # take 1 step back
                nr -= dr
                nc -= dc
                if maze[nr][nc] != 2:
                    if [nr,nc] == destination:
                        return True
                    maze[nr][nc] = 2
                    q.append((nr,nc))
        return False