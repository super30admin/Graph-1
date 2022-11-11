// ## Problem2 The Maze (https://leetcode.com/problems/the-maze/)

// Time Complexity : O(k mn) k is max(m,n)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding base case in dfs


// Your code here along with comments explaining your approach

let m, n, dirs

var dfs = (start, destination, maze) => {
    // Base
    // Check if reached destination
    if (start[0] === destination[0] && start[1] === destination[1])
        return true;

    // Mark ball as visited
    maze[start[0]][start[1]] = -1;
    // Logic
    for (let i = 0; i < dirs.length; i++) {
        // Get the valid row and col
        let diri = start[0] + dirs[i][0];
        let dirj = start[1] + dirs[i][1];
        // travel in a direction till at valid cell
        while (diri >= 0 && dirj >= 0 && diri < m && dirj < n && maze[diri][dirj] !== 1) {
            diri += dirs[i][0];
            dirj += dirs[i][1];
        }
        diri -= dirs[i][0];
        dirj -= dirs[i][1];
        // Check if it is a valid cell i.e it is not -1
        if (maze[diri][dirj] !== -1 && dfs([diri, dirj], destination, maze)) {
            return true;
        }
    }
    return false;
}

/**
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {boolean}
 */
var hasPath = function (maze, start, destination) {
    if (maze === null || start === null || destination === null || maze.length === 0)
        return false;

    m = maze.length;
    n = maze[0].length;
    // All directions, the ball can travel
    dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]; // U D L R

    return dfs(start, destination, maze);
    // BFS
    // let queue = [];
    // queue.push(start);
    // maze[start[0]][start[1]] = -1;

    // while(queue.length > 0){
    //     let curr = queue.shift();
    //     // For each direction
    //     for(let i=0; i<dirs.length; i++){

    //         // Get the valid row and col
    //         let diri = curr[0]+dirs[i][0];
    //         let dirj = curr[1]+dirs[i][1];

    //         while(diri>=0 && dirj>=0 && diri<m && dirj<n && maze[diri][dirj] !== 1){
    //             diri += dirs[i][0];
    //             dirj += dirs[i][1];
    //         }
    //         diri -= dirs[i][0];
    //         dirj -= dirs[i][1];
    //         if(maze[diri][dirj] === 0){
    //             if(diri === destination[0] && dirj === destination[1]){
    //                 return true;
    //             }
    //             queue.push([diri, dirj]);
    //             maze[diri][dirj] = -1;
    //         }
    //     }
    // }

    // return false;

};