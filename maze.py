#Time Complexity: O(k*mn)
#Space Complexity: O(mn)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        if start == destination:
            return True
        q = deque()
        q.append(start[0])
        q.append(start[1])
        maze[start[0]][start[1]] = 2
        
        while q:
            cr = q.popleft()
            cc = q.popleft()
            
            for dirn in dirs:
                i = cr
                j = cc
                while i>=0 and i<m and j>=0 and j<n and maze[i][j]!=1:
                    i += dirn[0]
                    j += dirn[1]
                
                i -= dirn[0]
                j -= dirn[1]
                if i == destination[0] and j == destination[1]:
                    return True
                if maze[i][j] != 2:
                    q.append(i)
                    q.append(j)
                    maze[i][j] = 2
        return False