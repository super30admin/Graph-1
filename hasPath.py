# TimeComplexity:O(m xn)
# Space Complexity O(1) max len 4
# Appproach :this DFS for connected components ,you try to go in all directions untill you reach destination also every time update the visted



def hasPath(source,destiantion, maze):
    dir=[(1,0),(0,1),(0,-1),(-1,0)]
    q=deque()
    q.append((source))
    m,n=len(maze),len(maze[0])
    while(len(q)):
        cord=q.popleft()
        #make it visted
        maze[cord[0]][cord[1]]=2
        
        for d in dir:
            i,j=cord[0],cord[1]
            while(-1<i<m and -1<j<n and maze[i][j]!=1):
                i+=d[0]
                j+=d[1]
            i-=d[0] #move back
            j-=d[1]
            if maze[i][j]!=2:
                if i==destiantion[0] and j==destiantion[1]:
                    return True
                q.append((i,j))
    return False
            
