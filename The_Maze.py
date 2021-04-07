'''
Time Complexity:
O(m.n) since we have to visit all the nodes in the worst case

Space Complexity:
O(mn) for the VISITED array.
'''

class Solution(object):

    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """



        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        bfs = deque()

        bfs.append(start)

        VISITED = [[False for idx in range(len(maze[0]))] for idxx in range(len(maze))]

        VISITED[start[0]][start[1]] = True # always set the VISITED value to True when a node is appended to the BFS queue

        while len(bfs) > 0:

            curr = bfs[0]
            row, col = curr[0], curr[1]


            if row == destination[0] and col == destination[1]:
                return True


            # Go in a direction until a wall is reached
            for dir in dirs:

                neighbor_row = row + dir[0]
                neighbor_col = col + dir[1]

                # stop right before a wall
                while neighbor_row >= 0 and neighbor_row <= len(maze)-1 and neighbor_col >= 0 and neighbor_col <= len(maze[0])-1 and maze[neighbor_row][neighbor_col] == 0:

                    neighbor_row += dir[0]
                    neighbor_col += dir[1]

                # reached one step into the wall, need to undo down below


                if not VISITED[neighbor_row - dir[0]][neighbor_col-dir[1]]:

                    bfs.append([neighbor_row-dir[0],neighbor_col-dir[1]])
                    VISITED[neighbor_row-dir[0]][neighbor_col-dir[1]] = True # always set the VISITED value to True when a node is appended to the BFS queue



            bfs.popleft()

        return False

