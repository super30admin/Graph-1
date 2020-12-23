//Time Complexity : O(V+E)
//Space Complexity : O(N) // N : Number of people in the town
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class Find_the_Town_Judge_997 {
    public int findJudge(int N, int[][] trust) {
    	int[] inDegrees = new int[N];
    	for(int[] arr : trust)
    	{
    		inDegrees[arr[0] - 1]--;
    		inDegrees[arr[1] - 1]++;
    	}
    	for(int i = 0; i < N; i++)
    	{
    		if(inDegrees[i] == N - 1)
    			return i+1;
    	}
    	return -1;
    }
    public static void main(String[] args)
    {
    	int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
    	Find_the_Town_Judge_997 judge = new Find_the_Town_Judge_997();
    	System.out.println(judge.findJudge(4, trust));
    }
}
