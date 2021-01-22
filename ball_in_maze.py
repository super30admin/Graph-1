class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        
        #bfs
        #O(mn) for both
        if not maze:
            return False
        q=deque()
        q.append(start)
        m=len(maze)
        n=len(maze[0])
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        #mark visited>state change
        maze[start[0]][start[1]]=2
        while q:
            cur=q.popleft()
            #if matches with destination>return answer
            if cur[0]==destination[0] and cur[1]==destination[1]:
                return True
            #for each dir, try to go till extreme wall
            for dir in dirs:
                i=cur[0]+dir[0]
                j=cur[1]+dir[1]
                while (i>=0 and i<m and j>=0 and j<n) and maze[i][j]!=2:
                    i=i+dir[0]
                    j=j+dir[1]
                i=i-dir[0]
                j=j-dir[1]
                if maze[i][j]!=2:
                    q.append((i,j))
                    maze[i][j]=2
        return False
            

            
        
        