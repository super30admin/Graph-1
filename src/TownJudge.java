//Time Complexity : O(N) 
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Calculate indegree and outdegree for each of the pairs in trust matrix. Then
 * iterate over these to see if any element got n-1 indegree and 0 outdegree.
 * the array could be of size n+1 since the numbers are in the range of 1 to n.
 *
 */
class Solution {
	public int findJudge(int n, int[][] trust) {
		if (trust.length < n - 1)
			return -1;
		int[] indegree = new int[n + 1];
		int[] outdegree = new int[n + 1];
		for (int[] t : trust) {
			indegree[t[1]]++;
			outdegree[t[0]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (outdegree[i] == 0 && indegree[i] == n - 1)
				return i;
		}
		return -1;
	}
}