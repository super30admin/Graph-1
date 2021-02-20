'''
Solution:
1.  Perform a BFS with only one extra condition that the ball needs to keep rolling until hit by a wall.
2.  Put the next possible cell in the queue (from all 4 directions) and check whether you are reached
    the destination cell.
3.  If reached, return True; else return False

Time Complexity:    O(rows x cols)  |   Space Complexity:   O(1)
'''

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if not maze:
            return False
        
        m = len(maze)
        n = len(maze[0])
        queue = deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2
        
        directions = [(0,-1), (-1,0), (0,1), (1,0)]
        
        while queue:
            curr = queue.popleft()
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            # iterate on 4 dirs and put the babies
            for dirs in directions:
                # row and col index of my current element
                i = curr[0]
                j = curr[1]
                #maze[i][j] != 1 represents wall
                # buttom/ top/ left / right and wall 
                while i >= 0 and j >= 0 and i< m and j < n and maze[i][j] != 1: 
                    i += dirs[0]
                    j += dirs[1]
                    
                # bring the ball back to stop point
                i -= dirs[0]
                j -= dirs[1]  
                # if not 2 (not vistied) then put into the queue
                if maze[i][j] != 2:
                    queue.append([i,j])
                    # then mark as true
                    maze[i][j] = 2
                    
        return False
