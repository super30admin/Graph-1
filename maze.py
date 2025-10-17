import collections
class Solution:
    def hasPath(self, maze, start, destination):
        self.dirs=[[0,-1],[0,1],[-1,0],[1,0]]
        m=len(maze)
        n=len(maze[0])
        
        q=collections.deque()
        q.append([start[0],start[1]])
        maze[start[0]][start[1]]=-1
        
        while q:
            curr=q.popleft()
            for dir in self.dirs:
                r=curr[0]+dir[0]
                c=curr[1]+dir[1]
                
                while r>=0 and c>=0 and r<=m-1 and c<=n-1 and maze[r][c]!=1:
                    r+=dir[0]
                    c+=dir[1]
                r-=dir[0]
                c-=dir[1]
                
                if r==destination[0] and c==destination[1]:
                    return True
                
                if maze[r][c]!=-1:
                    q.append([r,c])
                    maze[r][c]=-1
        return False
    
    
maze = [
    [0,0,1,0,0],
    [0,0,0,0,0],
    [0,0,0,1,0],
    [1,1,0,1,1],
    [0,0,0,0,0]
]
start = [0,4]
destination = [3,2]

s = Solution()
result = s.hasPath(maze, start, destination)
print(result)
