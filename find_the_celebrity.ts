function findCelibrity(n: number, knows: number[][]): number {
  let degrees: number[] = Array.from({ length: n + 1 }); // SC: O(n)
  degrees.fill(0);

  // O(m+n)
  for (let i = 0; i < knows.length; i++) {
    for (let j = 0; j < knows[i].length; j++) {
      if (i != j && knows[i][j] == 1) {
        degrees[i]--;
        degrees[j]++;
      }
    }
  }

  // O(n)
  for (let i = 1; i <= n; i++) {
    if (degrees[i] == n - 1) return i;
  }
  return -1;
}

describe("227. Find the celebrity", () => {
  it("Happy Path", () => {
    expect(
      findCelibrity(3, [
        [1, 1, 0],
        [0, 1, 0],
        [1, 1, 1],
      ])
    ).toStrictEqual(1);
  });
});
