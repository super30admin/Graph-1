"""
Rasika Sasturkar
Time complexity: O(n*m*k), where k is some constant.
Space complexity: O(n*m)
"""

from collections import deque


def hasPath(maze, start, destination) -> bool:
    dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    m = len(maze)
    n = len(maze[0])

    # null case
    if maze is None:
        return False

    # USING BFS
    # queue = deque([start])
    # maze[start[0]][start[1]] = 2  # mark as visited
    #
    # while queue:
    #     curr = queue.popleft()
    #     for dirn in dirs:
    #         i = curr[0]
    #         j = curr[1]
    #
    #         while i >= 0 and j >= 0 and i < m and j < n and maze[i][j] != 1:
    #             i += dirn[0]
    #             j += dirn[1]
    #         i -= dirn[0]
    #         j -= dirn[1]
    #         if maze[i][j] != 2:
    #             queue.append([i, j])
    #             if i == destination[0] and j == destination[1]:
    #                 return True
    #             maze[i][j] = 2
    # return False

    # USING DFS
    def dfs(maze, curr, desn):
        # base case
        if curr[0] == desn[0] and curr[1] == desn[1]:
            return True
        if maze[curr[0]][curr[1]] == 2:
            return False

        # logic
        maze[curr[0]][curr[1]] = 2  # mark as visited
        for dirn in dirs:
            i = curr[0]
            j = curr[1]

            while i >= 0 and j >= 0 and i < m and j < n and maze[i][j] != 1:
                i += dirn[0]
                j += dirn[1]
            i -= dirn[0]
            j -= dirn[1]
            if dfs(maze, [i, j], desn):
                return True
        return False

    return dfs(maze, start, destination)


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(hasPath(maze=[[0, 0, 1, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 1, 0], [1, 1, 0, 1, 1],
                        [0, 0, 0, 0, 0]], start=[0, 4], destination=[4, 4]))  # returns True
    print(hasPath(maze=[[0, 0, 1, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 1, 0], [1, 1, 0, 1, 1],
                        [0, 0, 0, 0, 0]], start=[0, 4], destination=[3, 2]))  # returns False
    print(hasPath(maze=[[0, 0, 0, 0, 0], [1, 1, 0, 0, 1], [0, 0, 0, 0, 0], [0, 1, 0, 0, 1],
                        [0, 1, 0, 0, 0]], start=[4, 3], destination=[0, 1]))  # returns False


if __name__ == "__main__":
    main()
