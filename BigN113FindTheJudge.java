//Time complexity is O(n)
//Space complexity is O(n)
//This solution is submitted on leetcode

public class BigN113FindTheJudge {
	class Solution {
		public int findJudge(int N, int[][] trust) {
			int[] indegree = new int[N];
			for (int[] temp : trust) {
				indegree[temp[0] - 1]--;
				indegree[temp[1] - 1]++;
			}
			for (int i = 0; i < indegree.length; i++) {
				if (indegree[i] == N - 1) {
					return i + 1;
				}
			}
			return -1;
		}
	}
}