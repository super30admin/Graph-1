/*************************************************Approach 1****************************************/
//Time Complexity : O(2n)
//Space Complexity : O(2n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : none

/** Given 2 criteria to determine a person as judge
 * 1)He should not follow anyone
 * 2)Everyone else should follow him
 * Will have 2 arrays to keep count of trusts and trusted
 * The town judge will be whose count of trusts will be zero and trustedby will be N-1
 * ***/
class Find_the_Town_Judge {
	public int findJudge(int N, int[][] trust) {
		if(trust == null)
			return -1;
		int[] trusts = new int[N];
		int[] trustedBy = new int[N];
		for(int i=0; i<trust.length; i++){ // O(n)
			trusts[trust[i][0] -1]++;
			trustedBy[trust[i][1] -1]++;
		}
		for(int i=0; i<N; i++){	//O(n)
			if(trusts[i] == 0 && trustedBy[i] == N-1)
				return i+1;
		}
		return -1;
	}
}

/*************************************************Approach 2****************************************/
//Time Complexity : O(m+n), n - Number of People, m - Number of edges
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : none

/**By calculating the indegrees for each node***/

class Solution {
	public int findJudge(int N, int[][] trust) {
		if(trust == null)
			return -1;
		int[] indegrees = new int[N];
		for(int t[] : trust){
			indegrees[t[0] -1]--;
			indegrees[t[1] -1]++;
		}
		for(int i=0; i<N; i++){
			if(indegrees[i] == N-1)
				return i+1;
		}
		return -1;
	}
}