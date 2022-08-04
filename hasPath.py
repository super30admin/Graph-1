# Time Complexity : O(m+n)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        visited = []
        dirs = [(-1,0), (1,0), (0,-1), (0,1)]
        dest = (destination[0],destination[1])

        def rollFrom(pos):
            newStops = []
            for d in dirs:
                newX = pos[0]
                newY = pos[1]
                while(True): #rolling
                    possibleNewX = newX + d[0]
                    possibleNewY = newY + d[1]
                    if (possibleNewX >= 0 and possibleNewX < len(maze) ) and (possibleNewY >= 0 and possibleNewY < len(maze[0])) and (maze[possibleNewX][possibleNewY] != 1):
                        newX = possibleNewX
                        newY = possibleNewY
                        continue
                    else:
                        break
                newStop = (newX, newY)
                if newStop == dest:
                    return True
                newStops.append(newStop)

            visited.append(pos)

            for newStop in newStops:
                if newStop not in visited:
                    if rollFrom(newStop):
                        return True
            return False

        startPos = (start[0], start[1])
        return rollFrom(startPos)
