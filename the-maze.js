// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {boolean}
 */
var hasPath = function(maze, start, destination) {
    if (!maze || !start || !destination) return false;
    
    const q = [];
    const dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    const visited = new Array(maze.length);
    for (const [index, slot] of visited.entries()) {
        visited[index] = new Array(maze[0].length).fill(false);
    };
    visited[start[0]][start[1]] = true;
    q.push(start);
    while (q.length > 0) {
        let currPos = q.pop();
        if (currPos[0] == destination[0] && currPos[1] == destination[1]) return true;
        for (const dir of dirs) {
            let dX = currPos[0] + dir[0];
            let dY = currPos[1] + dir[1];
            while (dX >= 0 && dX < maze.length && dY >= 0 && dY < maze[0].length && maze[dX][dY] == 0) {
                dX += dir[0];
                dY += dir[1];
            }
            if (!visited[dX - dir[0]][dY - dir[1]]) {
                q.push([dX - dir[0], dY - dir[1]]);
                visited[dX - dir[0]][dY - dir[1]] = true;
            }
        }
    }
    return false;
};
