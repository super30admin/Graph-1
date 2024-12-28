function findJudge(n: number, trust: number[][]): number {
  let degrees: number[] = Array.from({ length: n + 1 }); // SC: O(n)
  degrees.fill(0);

  for (const tr of trust) { // O(n)
    degrees[tr[0]]--;
    degrees[tr[1]]++;
  }

  for (let i = 1; i <= n; i++) { // O(n)
    if (degrees[i] == n - 1) return i;
  }
  return -1;
}

describe("997. Find the Town Judge", () => {
  it("Happy Path", () => {
    expect(
      findJudge(3, [
        [1, 3],
        [2, 3],
      ])
    ).toStrictEqual(3);
  });
});
