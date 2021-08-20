// Time Complexity : O(t + n), t -> Number of trust relationships = trust.length,  -> Number of people
// Space Complexity : O(n), n -> Number of people
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class TownJudge {
	/********************* Using two arrays *********************/
	public int findJudgeTwoArrays(int n, int[][] trust) {
		if (trust == null || n == 0 || trust.length < n - 1) {
			return -1;
		}

		int[] indegrees = new int[n + 1];
		int[] outdegrees = new int[n + 1];

		for (int[] currTrust : trust) {
			outdegrees[currTrust[0]]++;
			indegrees[currTrust[1]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (indegrees[i] == n - 1 && outdegrees[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	/********************* Using two arrays *********************/
	public int findJudge(int n, int[][] trust) {
		if (trust == null || n == 0 || trust.length < n - 1) {
			return -1;
		}

		int[] degrees = new int[n + 1];

		for (int[] currTrust : trust) {
			degrees[currTrust[0]]--;
			degrees[currTrust[1]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (degrees[i] == n - 1) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		TownJudge obj = new TownJudge();
		int n = 4;
		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };

		System.out.println("Judge of the given town: " + obj.findJudge(n, trust));
	}

}
