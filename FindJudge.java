// Time Complexity : O(v+e) //v no of vertices and e no of edges
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
 * 1. create an array of length n.
 * 2. when some one trusts some one else reduce trusting person score by 1 and trustee score increase by 1.
 * 3. whose score is equals to n-1 thats the answer. 
 */
public class FindJudge {
	public int findJudge(int n, int[][] trust) {
		int[] arr = new int[n];

		for (int i = 0; i < trust.length; i++) {
			arr[trust[i][0] - 1]--;
			arr[trust[i][1] - 1]++;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n - 1)
				return i + 1;
		}

		return -1;
	}
}
