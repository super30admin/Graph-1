#Time complexity: O(k*m*n) where k times is the while loop that runs to determine when to stop the ball. m*n is the amount of times row,col added inside the queue. 
#Space complexity: O(m*n) for queue data structure
#The intuition is to move the ball and once it stops do a BFS from that location by adding it to the while. If at any instance the row,col is equal to the destination return True otherwise False

class Solution:
    """
    @param maze: the maze
    @param start: the start
    @param destination: the destination
    @return: whether the ball could stop at the destination
    """
    def has_path(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # write your code here
        if start[0] == destination[0] and start[1] == destination[1]:
            return True
        
        m = len(maze)

        n = len(maze[0])

        directions = [[0,1],[1,0],[-1,0],[0,-1]]
        
        queue = deque()
        queue.append(start)
        maze[start[0]][start[1]] = 2

        while queue:
            row, col = queue.popLeft()
            for dr, dc in directions:
                while (row >= 0 and r < m and col>=0 and c < n and maze[row][col] != 1):
                    row += dr
                    col += dc
                row -= dr
                col -= dc
                if row == destination[0] and col == destination[1]: return True

                if maze[row][col] != 2:
                    maze[row][col] = 2
                    queue.append([row,col])

        return False
