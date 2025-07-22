# Time complexity - o(m+n)
# Space complexity - o(m*n)

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        m = len(maze)
        n = len(maze[0])

        q = deque()
        q.append(start)
        maze[start[0]][start[1]] = 2
        directions = [(-1,0),(0,1),(1,0),(0,-1)]

        while q:
            nr,nc = q.popleft()

            for dr,dc in directions:
                r,c = nr,nc
                while r>=0 and r<m and c>=0 and c<n and maze[r][c]!=1:
                    r+=dr
                    c+=dc
                r-=dr
                c-=dc

                if r==destination[0] and c==destination[1]:
                    return True
                
                if maze[r][c] != 2:
                    maze[r][c] = 2
                    q.append([r,c])

        return False
