#Time: O(mn)
#space: O(mn)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:

        if maze is None or len(maze)==0:
            return False
        q = collections.deque()
        q.append(start)
        m = len(maze)
        n = len(maze[0])
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        while q:
            cur = q.pop()
            if cur[0] == destination[0] and cur[1]==destination[1]:
                return True
            for d in dirs:
                i = cur[0]
                j = cur[1]
                while( i in range(m) and j in range(n) and maze[i][j]!=1):
                    i = i +d[0]
                    j = j+ d[1]
                i = i - d[0]
                j = j - d[1]
                if maze[i][j]!=2:
                    q.append([i,j])
                    maze[i][j]=2

        return False



        
