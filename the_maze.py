#BFS SOLUTION

#Time Complexity: O(m*n)
#Space Complexity: O(min(m,n))
'''
Simple BFS, but this time the node we visit (add to the queue) is only
when we reach a wall or borders of the maze. for each direction we iterate
until we reach a wall or border, then we add it to the stack if it's never 
been visited before. We transform the 0 to 2 each time we visit a node.
In this case visiting really means stopping there. Each time we visit a node
we check if it's the value we're looking for.If after BFS we haven't found it
we return False
'''

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or start==destination:
            return True
        n,m=len(maze),len(maze[0])
        q=collections.deque()
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        q.append((start[0],start[1]))
        maze[start[0]][start[1]]=2
        while q:
            i,j=q.pop()
            for d in dirs:
                r,c=i,j
                while 0<=r<n and 0<=c<m and maze[r][c]!=1:
                    r,c=r+d[0],c+d[1]   
                #went one more
                r,c=r-d[0],c-d[1]
                if r==destination[0] and c==destination[1]:
                    return True
                if maze[r][c]!=2:
                    q.append((r,c))
                maze[r][c]=2
        return False
        
        
#DFS SOLUTION

#Time Complexity: O(m*n)
#Space Complexity: O(m*n)
'''
Same as BFS solution, we iterate until we reach a wall or border. Then 
we recall DFS on the node that we stoped at, for each direction. We keep 
a global found variable to indicate if we've found the destination or not.

'''
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze or start==destination:
            return True
        n,m=len(maze),len(maze[0])
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        found=False
        def dfs(i,j):
            nonlocal n,m,destination,found
            if found or maze[i][j]==2:
                return
            if i==destination[0] and j==destination[1]: 
                found=True
            maze[i][j]=2
            
            for d in dirs:
                r,c=i,j
                while 0<=r<n and 0<=c<m and maze[r][c]!=1:
                    r,c=r+d[0],c+d[1]
                r,c=r-d[0],c-d[1]
                dfs(r,c)
        dfs(start[0],start[1])
        return found
