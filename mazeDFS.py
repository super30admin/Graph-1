# Time Complexity: O(n^2) where n is the number of elements in the maze
# Space Complexity: O(n^2) where n is the number of elements in the maze
# Approach: Perform DFS from start point until stack is empty. If element is found while traversing return True. If Stack is empty return False.
			In DFS the neighbors will be top, bottom, left and right extremes of elements in the maze where the 1st 1 or boundary is reached.
class Solution:
    
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        visited = set()
        stack = [tuple(start)]
        while len(stack) != 0:
            #print("stack:{}".format(stack))
            element = stack.pop()
            if list(element) == destination:
                return True
            #print("curr element: {}".format(element))
           
            #getleft neighbor
            left_counter = element[1]
            while left_counter - 1 >= 0 and maze[element[0]][left_counter-1] != 1:
                left_counter -= 1
            if left_counter != element[1] and (element[0],left_counter) not in visited:
                #print("left neighbor: {}".format([element[0],left_counter]))
                visited.add((element[0], left_counter))
                stack.append((element[0],left_counter))
            
                
            #get right neighbor
            right_counter = element[1]
            while right_counter + 1 < len(maze[0]) and maze[element[0]][right_counter+1] != 1:
                right_counter += 1
            if right_counter != element[1] and (element[0],right_counter) not in visited:
                #print("right neighbor: {}".format([element[0],right_counter]))
                visited.add((element[0],right_counter))
                stack.append((element[0],right_counter))
                
            
            #get top neighbor
            top_counter = element[0]
            while top_counter - 1 >= 0 and maze[top_counter - 1][element[1]] != 1:
                top_counter -= 1
            if top_counter != element[0] and (top_counter,element[1]) not in visited:
                #print("top neighbor: {}".format([top_counter,element[1]]))
                visited.add((top_counter,element[1]))
                stack.append((top_counter,element[1]))
                
            #get right neighbor
            bottom_counter = element[0]
            while bottom_counter + 1 < len(maze) and maze[bottom_counter + 1][element[1]] != 1:
                bottom_counter += 1
            if bottom_counter != element[0] and (bottom_counter,element[1]) not in visited:
                #print("bottom neighbor: {}".format([bottom_counter,element[1]]))
                visited.add((bottom_counter, element[1]))
                stack.append((bottom_counter, element[1]))
                                               
        return False