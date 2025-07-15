# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = len(maze)
        n = len(maze[0])
        q = deque()
        q.append(start)
        maze[start[0]][start[1]] = 2
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        while q:
            curr = q.popleft()
            for dr, dc in dirs:
                # Stopage Point
                r ,c = curr
                # move in one direction until hitting a wall
                while 0 <= r + dr < m and 0 <= c + dc < n and maze[r + dr][c + dc] != 1:
                    r += dr
                    c += dc

                # r -= nr
                # c -= nc
                if r==destination[0] and c == destination[1]:
                    return True

                if maze[r][c] != 2:
                    q.append([r,c])
                    maze[r][c] = 2
        return False
