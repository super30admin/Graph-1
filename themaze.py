"""
https://leetcode.com/problems/the-maze/
TC: O(mn) * max(m,n) which is a constant so tc os O(mn)the number of nodes going inside the queue in worst case can be total number of entries in the matrix
SC- O(mn)
"""


class Solution:
    """TC O(mn)
    SC O(mn) queue can grow to size mn
    """

    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        if maze == None:
            return False
        m = len(maze)
        n = len(maze[0])
        q = collections.deque()
        q.append(start)
        maze[start[0]][start[1]] = 2
        ##put 2 at the position where we want to start our search
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while q:
            current = q.popleft()
            for direc in dirs:
                i = current[0]
                j = current[1]
                # negibour=maze[current[0]+dir[0]][current[1]+dir[1]]
                # if neighbour
                while i < m and j < n and i >= 0 and j >= 0 and maze[i][j] != 1:
                    i += direc[0]
                    j += direc[1]
                ###come back one step
                i -= direc[0]
                j -= direc[1]
                ###when it stops
                if maze[i][j] == 0:
                    ###we will only put it in queue when its not visisted
                    ###check if this is our destination

                    if i == destination[0] and j == destination[1]:
                        return True
                        ##if not destination then mark visistd and apped in q
                    maze[i][j] = 2
                    q.append([i, j])
        return False





