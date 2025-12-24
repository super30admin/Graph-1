class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        q = deque()
        ROWS, COLS = len(maze), len(maze[0])
        
        def isValidCell(curi, curj):
            if not 0 <= curi < ROWS or not 0 <= curj < COLS:
                return False
            return True

        seen = set()
        q.append(start)
        
        while q:
            curi, curj = q.popleft()
            
            
            if not isValidCell(curi, curj) or maze[curi][curj] == 1 or (curi, curj) in seen:
                continue

            seen.add((curi, curj))
            #print(curi, curj)
            
            #4 directions while loop right?
            #left 0, -1
            newi, newj = curi, curj
            while isValidCell(newi, newj) and maze[newi][newj] != 1:
                newj -= 1
            newj+=1
            if [newi, newj] == destination:return True
            if (newi, newj) not in seen: q.append((newi, newj))

            #right 0, 1
            newi, newj = curi, curj
            while isValidCell(newi, newj) and maze[newi][newj] != 1:
                newj += 1
            newj-=1
            if [newi, newj] == destination:return True
            if (newi, newj) not in seen: q.append((newi, newj))

            #top -1, 0
            newi, newj = curi, curj 
            while isValidCell(newi, newj) and maze[newi][newj] != 1:
                newi -= 1
            newi+=1
            if [newi, newj] == destination:return True
            if (newi, newj) not in seen: q.append((newi, newj))

            #bottom 1, 0
            newi, newj = curi, curj
            while isValidCell(newi, newj) and maze[newi][newj] != 1:
                newi += 1
            newi-=1
            if [newi, newj] == destination:return True
            if (newi, newj) not in seen: q.append((newi, newj))

        return False
