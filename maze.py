'''
TC:O(m*n)
SC: O(m*n)
'''

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:

        directions =[[0,1],[0,-1],[-1,0],[1,0]]

        queue = deque()

        queue.append(start)

        rows =len(maze)
        cols = len(maze[0])

        maze[start[0]][start[1]]=-1


        while(queue):

            print(queue)

            curr_row, curr_col = queue.popleft()

            print(f"current_row{curr_row}, current_col{curr_col}")


            for row, col in directions:

                moving_row, moving_col = row+curr_row, col+curr_col


                while moving_row in range(rows) and moving_col in range(cols) and maze[moving_row][moving_col]!=1:

                    moving_row+=row
                    moving_col+=col

                moving_row-=row
                moving_col-=col



                if(moving_row== destination[0] and moving_col == destination[1]):
                    return True

                if  maze[moving_row][moving_col]!=-1:
                    queue.append([moving_row, moving_col])
                    maze[moving_row][moving_col]=-1


        return False









