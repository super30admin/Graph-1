// Time complexity- O(m*n), m= number of rows, n = number of columns
// Space complecity - O(m*n)
function hasPath(
	maze: number[][],
	start: number[],
	destination: number[]
): boolean {
	// return early if start and destination
	if (start[0] == destination[0] && start[1] == destination[1]) return true;
	const dirs = [
		[0, 1],
		[0, -1],
		[1, 0],
		[-1, 0],
	];

	// put the "start" in queue to process
	const q = [start];
	// mark start as visited (using 2)
	maze[start[0]][start[1]] = 2;

	while (q.length > 0) {
		let [r, c] = q.shift();

		// travel in all four direction untill we hit a wall
		for (let [x, y] of dirs) {
			let nr = r;
			let nc = c;

			// roll the ball in direction [x, y] until it hits a wall (1) or a boundary
			while (
				nr >= 0 &&
				nc >= 0 &&
				nr < maze.length &&
				nc < maze[0].length &&
				maze[nr][nc] != 1
			) {
				nr += x;
				nc += y;
			}
			// backtrack one step to the valid stopping position (before the wall)
			nr -= x;
			nc -= y;

			// return early if we reached destination
			if (nr == destination[0] && nc == destination[1]) return true;

			// if cell is not visited already, mark visited and push to queue to process
			if (maze[nr][nc] != 2) {
				q.push([nr, nc]);
				maze[nr][nc] = 2;
			}
		}
	}
	return false;
}
