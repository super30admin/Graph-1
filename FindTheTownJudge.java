package graph1;

public class FindTheTownJudge {
	//Time Complexity : O(n)
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        
        for(int[] t: trust) {
            trustCount[t[0]]--;
            trustCount[t[1]]++;
        }
        
        for(int i=1; i<trustCount.length; i++) {
            if(trustCount[i] == n - 1)
                return i;
        }
        
        return -1;
    }
}
