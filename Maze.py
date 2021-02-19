'''
    Time Complexity:
        O(mn) (where m = number of rows and n = number of columns in the maze)

    Space Complexity:
        O(mn) (where m = number of rows and n = number of columns in the maze)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        BFS.
        Roll the ball in all 4 directions until you find the wall.
        Keep a track of visited cells.
        If the cell is not already visited, put it in a Queue for processing.
'''

class Solution:
    EMPTY = 0
    DIRECTIONS = [
        [1, 0], [0, 1], [-1, 0], [0, -1]
    ]

    def __init__(self):
        self.maze = []

    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        self.maze = maze
        visited = set()

        q = collections.deque()
        q.append(tuple(start))
        visited.add(tuple(start))


        while q:
            coordinate = q.popleft()

            if coordinate == tuple(destination):
                return True

            for direction in Solution.DIRECTIONS:
                neighbor = self.get_neighbor(coordinate, direction)

                if neighbor not in visited:
                    q.append(neighbor)
                    visited.add(neighbor)

        return False

    def get_neighbor(self, coordinate, direction):
        x = coordinate[0] + direction[0]
        y = coordinate[1] + direction[1]

        while True:
            if x < 0 or x >= len(self.maze):
                break

            if y < 0 or y >= len(self.maze[x]):
                break

            if self.maze[x][y] != Solution.EMPTY:
                break

            x += direction[0]
            y += direction[1]

        x -= direction[0]
        y -= direction[1]
        return (x, y)
