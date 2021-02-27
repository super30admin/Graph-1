#Time Complexity:O(mn)
#Space Complexity:O(mn)
#BFS approach: starting from the start position given , explore all four directions from the current position using a queue through the maze
#if during the parsing, destination is encountered, return true else false. 
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if len(maze)==0:
            return False
        dirs=[[1,0],[0,1],[-1,0],[0,-1]]
        m=len(maze)
        n=len(maze[0])
        d=deque()
        d.append(start)
        maze[start[0]][start[1]]=2
        while d:
            curr=d.popleft()
            if curr==destination:
                return True
            for di in dirs:
                i=curr[0]
                j=curr[1]
                while m>i>=0 and n>j>=0 and maze[i][j]!=1:
                    i+=di[0]
                    j+=di[1]
                i-=di[0]
                j-=di[1]
                if maze[i][j]!=2:
                    d.append([i,j])
                    maze[i][j]=2
        return False  