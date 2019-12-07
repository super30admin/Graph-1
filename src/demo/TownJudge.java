package demo;

class Solution1 {
	
	//Time Complexity: O (n) - rows
	//Space Complexity: O(n) - extra arrays
	//Leetcode: yes
	public int findJudge(int N, int[][] trust) {

		if(trust.length == 0){
			return N==1 ? 1: -1;
		}
		//two arrays,
		boolean[] trusts = new boolean[N];
		int[] trusted = new int[N];
		//initialize as per the directed graph
		for(int i=0 ; i < trust.length; i++){
			int a = trust[i][0];
			int b = trust[i][1];
			trusts[a-1] = true;
			trusted[b-1] += 1;
		}

		//check if any false in trusts array and 
		//largest element in trusted is N-1
		for(int i=0 ; i < N; i++){
			if( trusts[i] == false && trusted[i] == N-1) return i+1;
		}
		return -1;
	}
}