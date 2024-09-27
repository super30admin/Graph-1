"""
Time: O(mn)
Space: O(mn)
Leet: Accepted
Problems: None
"""

class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        def findNeighbors(node):
            #returns four neigbours of the node
            n = []
            dirs = [[1,0],[-1,0],[0,1],[0,-1]] #directions
            for d in dirs:
                x = node[0] + d[0] #initialize with a move into the direction
                y = node[1] + d[1]
                while 0<=x<len(maze) and 0<=y<len(maze[0]) and maze[x][y]==0: #move till wall is hit
                    x += d[0]
                    y += d[1]
                x -= d[0] #decrement to give a valid position
                y -= d[1]
                n.append([x,y])
            return n

        queue = []
        visited = []
        queue.append(start) #bfs search
        while len(queue) > 0:
            curr = queue.pop(0)
            if curr[0] == destination[0] and curr[1] == destination[1]:
                return True
            visited.append([curr[0],curr[1]])
            neighbors = findNeighbors(curr)
            for n in neighbors:
                if n not in visited and n not in queue :
                    queue.append(n)
        return False
