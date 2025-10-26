'''
Solution: BFS 
Time complexity: O(m*n)
Space Complexity: O(m*n)
'''
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        rows = len(maze)
        cols = len(maze[0])

        bfs_queue = deque() 

        bfs_queue.append(start)
        maze[start[0]][start[1]] = 2 # mark visited

        while bfs_queue:
            parent_row, parent_col = bfs_queue.popleft()

            # Try rolling ball to right:
            row = parent_row
            col = parent_col

            while col<cols and maze[row][col]!=1:
                col+=1
            col=col-1 # where ball stopped
            
            if [row,col]==destination: # ball stoped at target
                return True
            
            if maze[row][col]!=2:
                bfs_queue.append([row,col])
                maze[row][col]=2
            
            # Try rolling ball down:
            row = parent_row
            col = parent_col

            while row<rows and maze[row][col]!=1:
                row+=1
            row=row-1 # where ball stopped
            
            if [row,col]==destination: # ball stoped at target
                return True
            
            if maze[row][col]!=2:
                bfs_queue.append([row,col])
                maze[row][col]=2

            # Try rolling ball to left:
            row = parent_row
            col = parent_col

            while col>=0 and maze[row][col]!=1:
                col-=1
            col=col+1 # where ball stopped
            
            if [row,col]==destination: # ball stoped at target
                return True
            
            if maze[row][col]!=2:
                bfs_queue.append([row,col])
                maze[row][col]=2
            
            # Try rolling ball upwards:
            row = parent_row
            col = parent_col

            while row>=0 and maze[row][col]!=1:
                row-=1
            row=row+1 # where ball stopped
            
            if [row,col]==destination: # ball stoped at target
                return True
            
            if maze[row][col]!=2:
                bfs_queue.append([row,col])
                maze[row][col]=2
        
        return False