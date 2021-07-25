class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        """
        BFS
        TC:O(m*n^(m+n))
        SC:O(m*n)
        """
        if not maze: return False
        
        q=collections.deque()
        # right, bottom, left, top
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        m=len(maze)
        n=len(maze[0])
        while q:
            cur=q.popleft()
            if cur[0]==destination[0] and cur[1]==destination[1]:
                return True
            for dirr in dirs:
                i=cur[0]
                j=cur[1]
                while i>=0 and i<m and j>=0 and j<n and maze[i][j]!=1:
                    i+=dirr[0]
                    j+=dirr[1]
                i-=dirr[0]
                j-=dirr[1]
                if maze[i][j]!=2:
                    q.append([i,j])
                    maze[i][j]=2
        return False
                
            
        