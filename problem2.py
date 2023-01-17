#time complexity: O(m*n)
#space complexity: O(m*n)
#ran on leetcode: Yes
#start the BFS from start position. From every coordinate, the neighbors would be the coordinates which can be reached by rolling the ball in all 4 directions till it hits the boundary. Keep traversing by exploring the neighbor nodes until queue becomes empty. At any point in time, if the destination is reached, then return True
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        Q=[(start[0],start[1])]
        dirs=[(0,1),(0,-1),(-1,0),(1,0)]
        while(Q):
            curr=Q[0]
            del(Q[0])
            maze[curr[0]][curr[1]]=-1
            if(curr[0]==destination[0] and curr[1]==destination[1]):
                return True
            for d in dirs:
                x=curr[0]
                y=curr[1]
                while(x>=0 and x<len(maze) and y>=0 and y<len(maze[0]) and maze[x][y]!=1):
                    x+=d[0]
                    y+=d[1]
                x-=d[0]
                y-=d[1]
                if(maze[x][y]!=-1):
                    Q.append((x,y))
        return False
            

                    

