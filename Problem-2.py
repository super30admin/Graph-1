#Time Complexity :o(mn)
#Space Complexity :o(mn)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

#O(MN)
#O(MN)
class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        if(len(maze)==0 or maze == None):
            return False
        
        m=len(maze)
        n=len(maze[0])
        queue=collections.deque()
        maze[start[0]][start[1]]=2
        queue.append([start[0],start[1]])
        
        dirs=[[1,0],[-1,0],[0,-1],[0,1]]
        while queue:
            curr=queue.popleft()
            if(curr[0]==destination[0] and curr[1]==destination[1]):
                return True
                
            for dir in dirs:
                i=curr[0]+dir[0]
                j=curr[1]+dir[1]
                #itertate all the way tillwe hit a wall
                while(i>=0 and j>=0 and i<m and j<n and maze[i][j]!=1):
                    i+=dir[0]
                    j+=dir[1]
                    
                i-=dir[0]
                j-=dir[1]
                #check if already visited
                if(maze[i][j]!=2):
                    queue.append([i,j])
                    maze[i][j]=2
                    
        return False
                
        