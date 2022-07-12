SC - O(m*n)
TC - O(m*n)

/**
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {boolean}
 */
var hasPath = function (maze, start, destination) {
  let m = maze.length;
  let n = maze[0].length;
  let result = false;
  let directions = [
    [-1, 0], //up
    [0, 1], //right
    [1, 0], //down
    [0, -1], //left
  ];
  let visited = new Array(m).fill(0).map(() => new Array(n).fill(false));
  function dfs(node, dirFrom) {
    visited[node[0]][node[1]] = true;
    for (let i = 0; i < directions.length; i += 1) {
      if (result) {
        return;
      }
     
      if (Math.abs(dirFrom - i) === 2 || i === dirFrom) {
        continue;
      }
      
      let dir = directions[i];
      let newI = node[0] + dir[0];
      let newJ = node[1] + dir[1];
      while (
        newI >= 0 &&
        newI < m &&
        newJ >= 0 &&
        newJ < n &&
        maze[newI][newJ] === 0
      ) {
        newI = newI + dir[0];
        newJ = newJ + dir[1];
      }
    
      newI = newI - dir[0];
      newJ = newJ - dir[1];
      if (newI === destination[0] && newJ === destination[1]) {
        result = true;
        return;
      }
     
      if (newI === node[0] && newJ === node[1]) {
        continue;
      }
     
      if (!visited[newI][newJ]) {
        dfs([newI, newJ], i);
      }
    }
    
  }
  dfs(start, Infinity);
  return result;
};