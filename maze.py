class Solution(object):
    def hasPath(self, maze, start, destination):
        m,n = len(maze), len(maze[0])
        i0,j0 = start[0], start[1]
        i1,j1 = destination[0], destination[1]
        if maze[i0][j0]==1 or maze[i1][j1]==1:
            return False
        visited = set()
        def dfs(i,j):
            if i==i1 and j==j1:
                return True
            visited.add((i,j))
            for d in [1,-1]:
                k=i
                while k+d>=0 and k+d<m and maze[k+d][j]==0:
                    k+=d
            
                if k!=i and (k,j) not in visited:
                    if dfs(k,j):
                        return True
                l=j
                while l+d>=0 and l+d<n and maze[i][l+d]==0:
                    l+=d
                
                if l!=j and (i,l) not in visited:
                    if dfs(i,l):
                        return True
            return False
        return dfs(i0,j0)
#Time-complexity: O(m.n)
#spoace-complexity: O(m.n)