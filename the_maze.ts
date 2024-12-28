function hasPath(
  maze: number[][],
  start: number[],
  destination: number[]
): boolean {
  let directions: number[][] = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];

  let queue: number[][] = [];
  queue.push(start);

  const VISITED: number = -1;
  const WALL: number = 1;
  while (queue.length > 0) {
    let size = queue.length;
    for (let index = 0; index < size; index++) {
      let position = queue.shift()!;
      let row = position[0];
      let col = position[1];

      for (const direction of directions) {
        let newRow = row + direction[0];
        let newCol = col + direction[1];

        while (
          newRow >= 0 &&
          newRow < maze.length &&
          newCol >= 0 &&
          newCol < maze[newRow].length &&
          maze[newRow][newCol] != WALL
        ) {
          newRow += direction[0];
          newCol += direction[1];
        }

        newRow -= direction[0];
        newCol -= direction[1];

        if (newRow == destination[0] && newCol == destination[1]) return true;
        if (maze[newRow][newCol] != VISITED) {
          maze[newRow][newCol] = VISITED;
          queue.push([newRow, newCol]);
        }
      }
    }
  }

  return false;
}

describe("The Maze - Premium", () => {
  it("Happy Path", () => {
    expect(
      hasPath(
        [
          [0, 0, 1, 0, 0],
          [0, 0, 0, 0, 0],
          [0, 0, 0, 1, 0],
          [1, 1, 0, 1, 1],
          [0, 0, 0, 0, 0],
        ],
        [0, 4],
        [4, 4]
      )
    ).toStrictEqual(true);
  });

  it("Negative Path", () => {
    expect(
      hasPath(
        [
          [0, 0, 1, 0, 0],
          [0, 0, 0, 0, 0],
          [0, 0, 0, 1, 0],
          [1, 1, 0, 1, 1],
          [0, 0, 0, 0, 0],
        ],
        [0, 4],
        [3, 2]
      )
    ).toStrictEqual(false);
  });
});
