#Time Complexity O(m *n)
#Space Complexity O(m *n)

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze ==None or len(maze)==0:
            return False
        dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        m=len(maze)
        n=len(maze[0])
        if start[0] ==destination[0] and  start[1] == destination[1]:
            return True
        q = []
        q.append(start)
        while len(q)!=0:
            curr = q.pop(0)
            for x in dirs:
                row = curr[0]
                col = curr[1]
                while row>=0 and row <m and col >=0 and col<n and maze[row][col] != 1:
                    row+=x[0]
                    col+=x[1]
                
                row-= x[0]
                col-= x[1]
                if row == destination[0] and col == destination[1]:
                    return True
            if maze[row][col] !=2:
                maze[row][col] = 2
                q.append([row,col])
                
        return False
