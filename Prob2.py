class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:     

        # Method 1 - BFS - 
        # TC - m*n from outer while loop, but the inner for loop gives aditional m+n as in   worst case we can move either in m direction or n direction.  
        # However, asymptotically, it is m*n. 
        m=len(maze)
        n=len(maze[0])

        if not maze: return False
        if start[0]==destination[0] and start[1]==destination[1]: return True

        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        q=deque()
        q.append(start)
        maze[start[0]][start[1]]=2

        while q:
            curr=q.popleft()
            for d in dirs:
                r=curr[0]
                c=curr[1]

                while 0<=r<m and 0<=c<n and maze[r][c]!=1: #check if r,c is in bound and if not at wall.
                    r+=d[0]
                    c+=d[1]
                #we need to go back, as we'll get to know it's a wall and out of bounds only when we are already at the wall and already out of bounds.
                r-=d[0] 
                c-=d[1]

                if r==destination[0] and c==destination[1]: return True
            
                if maze[r][c]!=2: #if not visited
                    q.append((r,c)) #add to q
                    maze[r][c]=2 #mark as visited
        return False





                




