# Time Complexity (BFS Approach) :
# O(m*n*(m+n))

# Space Complexity (BFS Approach):  
# O(m*n) 


class Solution(object):
    def __init__(self):
        m = 0
        n = 0
        dirs = []
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        if not maze or len(maze)==0:
            return False
        self.m = len(maze)
        self.n = len(maze[0])
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        # ===================> Approach 2: BFS , TC = O(m*n*(m+n)), SC = O(m*n) Queue elements ===================== #
        queue = []
        queue.append([start[0],start[1]])
        maze[start[0]][start[1]] = 2     # mark as visited

        # while queue is not empty
        while(queue):
            curr = queue.pop(0)

            # Base condition
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True


            # Logic for BFS(Queue)
            for dir in self.dirs:
                nr = curr[0]
                nc = curr[1]

                # while nr and nc within bounds and not equal to 1's
                while(nr>=0 and nr<self.m and nc>=0 and nc<self.n and maze[nr][nc] != 1):
                    nr = nr + dir[0]
                    nc = nc + dir[1]
                
                # take one step back if above condition in while is violated
                nr = nr - dir[0]
                nc = nc - dir[1]

                # now, at this cell, check if it was not visited before
                if maze[nr][nc] != 2:
                    queue.append([nr,nc])
                    maze[nr][nc] = 2
        

        return False