# Time Complexity :
# O(NM)  

# Space Complexity :
# O(NM)

# Did this code successfully run on Leetcode :
#Yes

#At each position, we check if it is visited (by storing a visited matrix), 
#if not mark that position as position as visited, the move from that position in all directions until the ball stops.
#We check if this stopped location is the target- if it is, we are done and we return True. 
#If not, then we try to see if we reach the goal from this new position
#If no path reaches the target, we return Fale

class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        n = len(maze)
        m = len(maze[0])
        self.dp_mat = [[-1] * m for i in range(n)]
        return self.helper(maze,start,n,m,destination)

    def helper(self,maze,position,n,m,target):
        if self.dp_mat[position[0]][position[1]] == 0 :
            return False
        if self.dp_mat[position[0]][position[1]] == 1 :
            return True

        self.dp_mat[position[0]][position[1]] = 0
        directions = [(-1,0),(1,0),(0,-1),(0,1)]
        for direction in directions : 
            curr_pos = position
            invalid = False
            while maze[curr_pos[0]][curr_pos[1]] == 0 :
                if self.is_valid(curr_pos[0] + direction[0],curr_pos[1]+direction[1],n,m) :
                    curr_pos = (curr_pos[0] + direction[0] , curr_pos[1] + direction[1] )
                else :
                    invalid = True
                    break
            if invalid == False:
                final_pos = (curr_pos[0] - direction[0],curr_pos[1]-direction[1] )
            else :
                final_pos = curr_pos

            if final_pos[0] == target[0] and final_pos[1] == target[1] :
                return True
            if self.helper(maze,final_pos,n,m,target) == True :
                return True
        return False    

    def is_valid(self,i,j,n,m):
        if i >= 0 and i < n and j >= 0 and j< m:
            return True
        return False 
