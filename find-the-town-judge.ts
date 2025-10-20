// Time complexity- O(n)
// Space complecity - O(n)
// to find the judge, we have to check if everyone person in town trusts judge and judge trusts no one
// we can iterate through the trust for each person and reduce count when person trust other persion
// once we have the trust count ready for each person in town, check if any persion is qualified to be judge by checking if trust value is equal to number of people in town
function findJudge(n: number, trust: number[][]): number {
	const result = new Array(n + 1).fill(0);

	for (let [truster, trusted] of trust) {
		// decrement score for truster (out-degree)
		result[truster] -= 1;
		// increase score for trusted (indegree)
		result[trusted] += 1;
	}

	// check is any member is trust of all the person in town
	for (let i = 1; i < result.length; i++) {
		// check for n-1, to exclude judge
		if (result[i] == n - 1) return i;
	}
	return -1;
}
