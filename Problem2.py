# Time Complexity : O(m*n*(min(m,n)))
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# using dfs to reach the boundary and then at every step checking the if
#that boundary is destination or not
class Solution:

    def hasPath(self,maze,start,destination):
        return self.dfs(maze,start,destination)

    def dfs(self,maze,pos,des):
        m = len(maze)
        n = len(maze[0])
        if maze[pos[0]][pos[1]] == 2:
            return False
        if pos[0] == des[0] and pos[1] == des[1]:
            return True

        maze[pos[0]][pos[1]] = 2

        dirs = [[0,1],[0,-1],[-1,0],[1,0]]

        for i in dirs:
            x = pos[0]
            y = pos[1]

            while x >= 0 and y >= 0 and x < m and y < n and maze[x][y] == 0:
                x += i[0]
                y += i[1]
            
            if self.dfs(maze,[x-i[0],y-i[1]],des):
                return True
        

        return False