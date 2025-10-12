from collections import deque
def hasPath(source,destiantion, maze):
    Dir=[(1,0),(0,1),(0,-1),(-1,0)]
    q=deque()
    q.append((source))
    m,n=len(maze),len(maze[0])
    while(len(q)):
        cord=q.popleft()
        maze[cord[0]][cord[1]]=2

        for d in Dir:
            i,j=cord[0],cord[1]
            while(-1<i<m and -1<j<n and maze[i][j]!=1):
                i+=d[0]
                j+=d[1]
            i-=d[0]
            j-=d[1]
            if maze[i][j]!=2:
                if i==destiantion[0] and j==destiantion[1]:
                    return True
                q.append((i,j))
    return False