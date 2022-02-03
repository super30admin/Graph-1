#Time Complexity = O(n)
#Space Complexity = O(n)

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if(maze == None or len(maze)==0 or start == destination):
             return True
        m = len(maze[0])
        n = len(maze)
        queue = [start]
        matrix = maze
        matrix[start[0]][start[1]] = 2
        dire = [[-1,0],[1,0],[0,-1],[0,1]]
        while(len(queue)!=0):
            val = queue.pop(0)

            for i,j in dire:
                x1 = val[0]
                x2 = val[1]
                while(x1>=0 and x2>=0 and x1<n and x2<m and matrix[x1][x2]!=1):
                    x1 +=i
                    x2 +=j
                x1 -=i
                x2-=j
                if(x1==destination[0] and x2 == destination[1]):
                    return True
                
                if(matrix[x1][x2]==0):
                    matrix[x1][x2] = 2
                    queue.append([x1,x2])
        return False
           
                
                
           
        