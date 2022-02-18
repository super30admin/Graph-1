# Bfs Approach
# Time Complexity o(m+n)


import collections


def haspath(maze,start,dest):
    if maze == None or len(maze) == 0:
        return False
    
    dirs = [[-1,0],[1,0],[0,-1],[0,1]]

    m = len(maze)

    n = len(maze[0])
    
    qu = collections.deque()

    qu.append(start)

    if start[0] == dest[0] and start[0] == dest[0]:
        return 
    
    while(len(qu)>0):

        curr = qu.popleft()

        for a in dirs:
            r = curr[0]
            c = curr[1]
            # Loop in a direction untill you hit a hurdle
            while (r >= 0  and r <m and c >=0 and c <n and maze[r][c] !=1):
                r += a[0]
                c +=a[1]
            # Once you hit a hurdle and break the loop. decrease one step because you would be at the hurdle
            r -= a[0]
            c -=a[1]
          
            if r == dest[0] and c == dest[1]:
                return True
            if maze[r][c] != 2:
                maze[r][c] = 2
                qu.append([r,c])
    return False


maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]

start = [0,4]
dest = [4,4]
print(haspath(maze,start,dest))




