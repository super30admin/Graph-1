# TC: O(m*n)
# SC: O(m*n)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        maze[start[0]][start[1]]=2
        dirs=[[0,-1], [-1,0], [0,1], [1,0]]
        q=deque([start])

        while q:
            curr=q.popleft()
            cr=curr[0]
            cc=curr[1]
            for d in dirs:
                nr=cr+d[0]
                nc=cc+d[1]
                while nr >=0 and nr<len(maze) and nc>=0 and nc<len(maze[0]) and maze[nr][nc]!=1:
                    nr+=d[0]
                    nc+=d[1]
                # one step back
                nr-=d[0]
                nc-=d[1]
                if maze[nr][nc]==2:
                    continue
                if nr==destination[0] and nc==destination[1]:
                    return True
                else:
                    maze[nr][nc]=2
                    q.append([nr,nc])
        
        return False


