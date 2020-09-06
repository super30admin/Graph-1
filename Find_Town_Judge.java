
public class Find_Town_Judge {
	//Approach: constrcut indegrees array for O(n) solution
	//1. we match the two conditions stated in the problem and constgruct indegrees array accordingly.
	//2. if for any element the indegree array value is equal to N-1, we return it.
    public int findJudge(int N, int[][] trust) {
        if(trust == null )
            return -1;
        int[] indegrees = new int[N];
        for(int[] trusts : trust)
        {
            indegrees[trusts[0]-1]--;
            indegrees[trusts[1]-1]++;
        }
        for(int i=0;i<indegrees.length;i++)
        {
            if(indegrees[i] == N-1)
                return i+1;
        }
        return -1;
    }
}
//Time Complexity : O(n) 
//Space Complexity : O(n) for the indegrees array 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
