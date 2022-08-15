// Time Complexity : O(km*n) where k is constant and m*n is maze size
// Space Complexity : O(m*n)

/**
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {boolean}
 */

//DFS Solution
let dirs;
let m, n;
var hasPath = function (maze, start, destination) {
  dirs = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  m = maze.length;
  n = maze[0].length;
  return dfs(maze, start, destination);
};

var dfs = function (maze, curr, destination) {
  // base case
  if (maze[curr[0]][curr[1]] === 2) return false;
  if (curr[0] === destination[0] && curr[1] === destination[1]) return true;

  // logic
  maze[curr[0]][curr[1]] = 2;
  for (dir of dirs) {
    let i = curr[0];
    let j = curr[1];
    while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] !== 1) {
      i += dir[0];
      j += dir[1];
    }
    i -= dir[0];
    j -= dir[1];
    if (dfs(maze, [i, j], destination)) return true;
  }
  return false;
};

//BFS Solution
// var hasPath = function(maze, start, destination) {
//     let m = maze.length;
//     let n = maze[0].length;
//     dirs = [[0,1],[0,-1],[1,0],[-1,0]];
//     let queue = [];
//     queue.push(start);
//     maze[start[0]][start[1]] = 2;
//     while(queue.length !== 0) {
//         let curr = queue.shift();
//         for(let dir of dirs) {
//             let i = curr[0];
//             let j = curr[1];
//             while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] !== 1) {
//                 i += dir[0];
//                 j += dir[1];
//             }
//             i -= dir[0];
//             j -= dir[1];
//             if(maze[i][j] !== 2) {
//                 if(i === destination[0] && j === destination[1]) return true;
//                 queue.push([i,j]);
//                 maze[i][j] = 2;
//             }
//         }
//     }
//     return false;
// };
