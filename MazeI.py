#490. The Maze
"""
Time Compelxity : O(mn)
Sapce Complexity : O(mn)
"""
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        visited = [[False for _ in range(len(maze))] for __ in range(len(maze[0]))]
        #print(visited)
        
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        
        q = deque()
        q.append(start)
        #print(q)
        
        visited[start[0]][start[1]] == True
        
        while len(q) != 0:
            curr = q.popleft()
            
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            
            for d in dirs:
                x = curr[0] #+ d[0]
                y = curr[1] #+ d[1]
                
                while (x >= 0 and y >= 0 and x < len(maze) and y < len(maze[0]) and maze[x][y] == 0):
                    x = x + d[0]
                    y = y + d[1]
                   
                #making borders true i.e. visited to avoid infinite loop            
                x -= d[0];
                y -= d[1];
                #print(x - d[0], y - d[1])
                if visited[x][y] == False:
                    q.append([x, y])
                    visited[x][y] = True
                    
        return False
