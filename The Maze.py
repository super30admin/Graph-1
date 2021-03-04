'''
T = O(mn)
S = O(mn)

Approach:
Starting from the start index perform bfs on all the possible directions such that its eaither a block or 
the end of the maze and there by the queue is a list of the all the possible places the ball can move and stop
when we encounter at a cell equal to the dst then return True.
Maintain a visted logic so that BFS will not consider the cells that are already visitied and it is not considered
again for a new cell.
'''
class Solution:
    def hasPath(self,maze,start,dst):
        if not maze:
            return False
        m = len(maze)
        n = len(maze[0])
        
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        Q = deque()
        Q.append(start)
        maze[start[0]][start[1]] = 2
        
        while len(Q) != 0:
            CurrNode = Q.popleft()
            if CurrNode == dst:
                return True
            
            for di in dirs:
                i,j = CurrNode[0],CurrNode[1]
                while m > i >= 0 and n > j >= 0 and maze[i][j] != 1:
                    i += di[0]
                    j += di[1]
                
                i -= di[0]
                j -= di[1]
                
                if maze[i][j] != 2:
                    Q.append([i,j])
                    maze[i][j] = 2
        return False
        
O =Solution()
print(O.hasPath([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]],[0,4],[4,4]))


'''
T = O(mn)
S = O(mn)

Approach:
DFS the maze such that at very cell we reach the extremes and makes sure that its not an already visitied cell
if the the current start cell is same as the destination then we have reached the destination.
'''

class Solution:
    def hasPath(self,maze,start,dst):
        if not maze:
            return False
        m = len(maze)
        n = len(maze[0])
        return self.dfs(maze,start,dst,m,n)
        
    def dfs(self,maze,start,dst,m,n):
        if start == dst:
            return True
        if maze[start[0]][start[1]] == 2:
            return False
        
    # logic
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        maze[start[0]][start[1]] = 2
        for di in dirs:
            i = start[0]
            j = start[1]
            while m > i >= 0 and n > j >= 0 and maze[i][j] != 1:
                i += di[0]
                j += di[1]
            i -= di[0]
            j -= di[1]
            if self.dfs(maze,[i,j],dst,m,n):
                return True
        return False
            
         
        
        
O =Solution()
print(O.hasPath([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]],[0,4],[4,4]))