# TC: O(M X N)
# SC: O(M X N)

class Solution:
    m=0
    n=0
    dir1=[[0,-1],[1,0],[0,1],[-1,0]]
    start1=[]
    flag=False
    destination1=[]
    def dfs(self,maze,r,c):
        if r==self.destination1[0] and c==self.destination1[1]:
            self.flag=True
            return True
        print(str(r)+" "+str(c))
        tempr=r
        tempc=c
        for d in self.dir1:
            r=tempr+d[0]
            c=tempc+d[1]

            while r>=0 and r<self.m and c>=0 and c<self.n and maze[r][c]!=1:
                r+=d[0]
                c+=d[1]
            
            r-=d[0]
            c-=d[1]

            if maze[r][c]!=2:
                maze[r][c]=2
                self.dfs(maze,r,c)
        

    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if start[0]==destination[0] and start[1]==destination[1]:
            return True
        self.start1=start
        self.destination1=destination
        self.m=len(maze)
        self.n=len(maze[0])

        self.dfs(maze,start[0],start[1])
        return self.flag
        



        # m=len(maze)
        # n=len(maze[0])
        # dir1=[[0,-1],[1,0],[0,1],[-1,0]]
        # if start[0]==destination[0] and start[1]==destination[1]:
        #     return True
        
        # q=deque()
        # q.append(start)
        # maze[start[0]][start[1]]=2
        # while q:
        #     cur=q.popleft()
        #     for d in dir1:
        #         r=cur[0]+d[0]
        #         c=cur[1]+d[1]

        #         while r>=0 and r<m and c>=0 and c<n and maze[r][c]!=1:
        #             r+=d[0]
        #             c+=d[1]
                
        #         r-=d[0]
        #         c-=d[1]

        #         if r==destination[0] and c==destination[1]:
        #             return True
        #         if maze[r][c]!=2:
        #             q.append([r,c])
        #             maze[r][c]=2
        
        # return False


        