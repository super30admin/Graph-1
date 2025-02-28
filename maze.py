class Solution:
    def hasPath(
        self, maze: List[List[int]], start: List[int], destination: List[int]
    ) -> bool:
        # T: O(m * n * max(m, n), S: (m * n))
        m, n = len(maze), len(maze[0])
        start_row, start_col = start
        dest_row, dest_col = destination

        # Four possible directions: up, right, down, left
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        # Queue for BFS
        queue = deque([(start_row, start_col)])

        # Set to keep track of visited stopping points
        visited = set([(start_row, start_col)])

        while queue:
            curr_row, curr_col = queue.popleft()

            # Check if we've reached the destination
            if curr_row == dest_row and curr_col == dest_col:
                return True

            # Try rolling the ball in all four directions
            for d_row, d_col in directions:
                next_row, next_col = curr_row, curr_col

                # Roll the ball until hitting a wall
                while (
                    0 <= next_row + d_row < m
                    and 0 <= next_col + d_col < n
                    and maze[next_row + d_row][next_col + d_col] == 0
                ):
                    next_row += d_row
                    next_col += d_col

                # If this stopping point hasn't been visited yet
                if (next_row, next_col) not in visited:
                    visited.add((next_row, next_col))
                    queue.append((next_row, next_col))

        # If we've exhausted all possibilities without finding the destination
        return False
