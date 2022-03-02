"""
time: O(N-1!)
space:O(M*N)
"""
class Solution:
    """

    @param maze: the maze
    @param start: the start
    @param destination: the destination
    @return: whether the ball could stop at the destination
    """

    def has_path(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        # write your code here
        maxRow, maxCol, hasBeen = len(maze), len(maze[0]), set()

        def dfs(x,y):
            if (x,y) not in hasBeen:
                hasBeen.add((x,y))
            else:
                return False
            if [x,y] == destination:
                return True

            #for loop, with left,right, up, down sets
            for l,m in (0,-1),(0,1),(-1,0),(1,0):
                newX, newY = x, y

                while 0 <= newX + l< maxRow and 0 <= newY + m < maxCol and maze[newX + l][newY + m] != 1:
                    newX += l
                    newY += m
                    if dfs(newX,newY):
                        return True
            return False
        return dfs(*start)