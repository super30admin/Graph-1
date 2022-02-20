class Solution:
    
    # BFS
    # TC: O((m+n)*(m*n))
    # SC: O(m*n) --> size of the queue
    
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        # Null Case
        if (len(maze) == 0) or (len(maze[0]) == 0):
            return False
        
        # Size of row and cols
        n = len(maze)
        m = len(maze[0])
        
        # Declaring directions array
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        
        # Declaring Queue
        import queue
        q = queue.Queue()
        
        # Checking if start is destination
        if (start[0] == destination[0] and start[1] == destination[1]):
            return True
        
        # Adding start to queue
        maze[start[0]][start[1]] = 2
        q.put(start)
        
        while(not q.empty()):
            # Popping first element from queue
            curr = q.get()
            # Traversing all four direction from a given coordinate
            for dr in dirs:
                r = curr[0]
                c = curr[1]
                # Going till encounter 1 that is wall
                while(r >= 0 and r < n and c >= 0 and c < m and maze[r][c] != 1):
                    r = r + dr[0]
                    c = c + dr[1]
                # When we breakout from while loop our row and col will at border
                r = r - dr[0]
                c = c - dr[1]
                # Check if coordinate is destination
                if(r == destination[0] and c == destination[1]):
                    return True
                # Decinding wether to put coordinate in queue or not
                if(maze[r][c] != 2):
                    maze[r][c] = 2
                    q.put([r, c])
                    
        return False
                    
        
                
                