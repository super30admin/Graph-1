// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1. Initialize an array to track trust degrees, where degrees[i] is increased for being trusted and decreased for trusting others.
//2. Iterate through the trust pairs, updating the degrees array accordingly.
//3. Check for the person whose degree equals n-1m (trusted by everyone else but trusts no one), and return their index (1-based); if no such person exists, return -1.

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0){
            return -1;
        }
        int []degrees = new int[n];
        for(int []t:trust){
            degrees[t[0] - 1]--; // Outdegree in graph
            degrees[t[1] - 1]++; // Indegree in graph
        }

        for(int i =0; i< n; i++){
            if(degrees[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}