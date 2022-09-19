# ######## BFS Solution ###########
# ### Time Complexity: O(m*n) + O(k*(m+n)) where k is a finite constant number so that part can be ignored asymptotically
# ### Space Complexity: O(m*n) for the queue
# class Solution:
#     def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
#         if start[0] == destination[0] and start[1] == destination[1]:
#             return True
#         dirs = [(0,-1),(-1,0),(0,1),(1,0)]
#         m = len(maze)
#         n = len(maze[0])
#         q = collections.deque()
#         q.append(start)
#         maze[start[0]][start[1]] = 2
        
#         while q:
#             curr = q.popleft()
            
#             # if curr[0] == destination[0] and curr[1] == destination[1]:
#             #     return True
            
#             for d in dirs:
#                 r = curr[0] + d[0]
#                 c = curr[1] + d[1]
                
#                 while r>=0 and r < m and c>=0 and c<n and maze[r][c] !=1:
#                     r += d[0]
#                     c += d[1]
                
#                 r -= d[0]
#                 c -= d[1]
                
#                 if maze[r][c] != 2:
#                     if r == destination[0] and c == destination[1]:
#                         return True
#                     q.append([r,c])
#                     maze[r][c] = 2
                    
#         return False

######## DFS Solution ###########
### Time Complexity: O(m*n) + O(k*(m+n)) where k is a finite constant number so that part can be ignored asymptotically
### Space Complexity: O(h) for the recursive stack
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        dirs = [(0,-1),(-1,0),(0,1),(1,0)]
        m = len(maze)
        n = len(maze[0])
        
        def dfs(maze,curr,end):
            # Base
            
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            
            if maze[curr[0]][curr[1]] == 2:
                return False
            
            # Logic
            maze[curr[0]][curr[1]] = 2
            
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                
                while r>=0 and r < m and c>=0 and c<n and maze[r][c] !=1:
                    r += d[0]
                    c += d[1]
                
                r -= d[0]
                c -= d[1]
                
                if(dfs(maze,[r,c],destination)):
                    return True
            return False
        
        
        return dfs(maze,start,destination)
                    