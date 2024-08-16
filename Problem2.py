# Time Complexity : O(n) where n is number of elements in  maze
# Space Complexity :  O(n) where n is number of elements in  maze
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:

    def hasPath(self, maze, start, destination):

    # write your code here

    start = set(start)
    destination = set(destination)
    if start == destination:
        return True
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    rows = len(maze)
    cols = len(maze[0])
    stack = [start]
    visited = set()

    while stack:
        current = stack.pop(0)
        if current == destination:
            return True
        if not any[current + dir for dir in directions]:
            return False
        for direction in directions:
            if (current[0] + direction[0], current[0] + direction[0]) in visited:
                continue
            nextPosition = current
            while (nextPosition[0] + direction[0], nextPosition[1] + direction[1]) not in visited:
                visited.add((nextPosition[0] + direction[0], nextPosition[1] + direction[1]))
                prev = nextPosition
                nextPosition = (nextPosition[0] + direction[0], nextPosition[1] + direction[1])
                if not (nextPosition[0] >= 0 and nextPosition[0] < rows and nextPosition[1] >= 0 and nextPosition[
                    0] < cols and maze[nextPosition[0]][nextPosition[1]] == 0):
                    if prev == destination:
                        return True
                    stack.append(prev)
                    break
    return False