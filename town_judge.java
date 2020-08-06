//TC - O(Max(M,N))
//SC - O(N)
class Solution {
	public int findJudge(int N, int[][] trust) {
		if (trust == null)
			return -1;
		int[] indegrees = new int[N];
		for (int[] t : trust) {
			indegrees[t[0] - 1]--;
			indegrees[t[1] - 1]++;
		}
		for (int i = 0; i < indegrees.length; i++) {
			if (indegrees[i] == N - 1)
				return i + 1;
		}
		return -1;
	}
}