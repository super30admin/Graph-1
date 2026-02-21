/**
Intuition:
Use BFS to explore the maze from the start position, treating each stopping point (where the ball hits a wall) as a node.
From each cell, roll in all four directions until hitting a wall, then step back to the last valid position.
If we ever stop exactly at the destination, return true; otherwise continue until all reachable positions are visited.
T.C: O(m*n)
S.C: O(m*n)
 */
var hasPath = function (maze, start, destination) {
    let queue = [start];
    let rowLength = maze.length;
    let colLength = maze[0].length;
    // four directions
    const directions = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    while (queue.length) {
        const [r, c] = queue.shift();
        maze[r][c] = 2;
        for (let [i, j] of directions) {
            let newR = r + i;
            let newC = c + j;
            while (newR >= 0 && newC >= 0 && newR < rowLength && newC < colLength && maze[newR][newC] != 1) {
                newR = newR + i;
                newC = newC + j;
            }
            // decrement to retrieve the last location before the wall or out of bounce.
            newR -= i;
            newC -= j;
            //dest check
            if (newR === destination[0] && newC === destination[1]) return true;
            if (maze[newR][newC] !== 2) {
                queue.push([newR, newC]);
            }
        }
    }
    return false;
};