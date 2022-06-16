
// Time Complexity : On(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public int FindJudge(int n, int[][] trust) {
        
    int[] indegrees = new int[n + 1];
    foreach(int[] t in trust)
    {
        //For every indreee , add +1
        //For every outdegree element, subtract -1
        indegrees[t[0]]--;
        indegrees[t[1]]++;
    }
    
    //There will be one index equals to n-1, that will be our answer
    for(int i = 1; i <= n; i++)
    {
        if(indegrees[i] == n-1)
            return i;
    }
    return -1;
}