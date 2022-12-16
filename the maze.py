class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:

        directions=[(-1,0),(1,0),(0,-1),(0,1)]

        rows=len(maze)
        cols=len(maze[0])

        stack=[]
        stack.append((start[0],start[1]))

        seen=set()
        seen.add((start[0],start[1]))

        while stack:
            cur_i,cur_j=stack.pop()

            for d in directions:
                ni=cur_i
                nj=cur_j

                while 0<=ni<rows and 0<=nj<cols and maze[ni][nj]==0:
                    ni+=d[0]
                    nj+=d[1]

                ni-=d[0]
                nj-=d[1]

                if ni==destination[0] and nj==destination[1]:
                    return True

                
                if (ni,nj) not in seen:
                    stack.append((ni,nj))
                    seen.add((ni,nj))

        return False


    #https://www.youtube.com/watch?v=e_75Z90j0IM