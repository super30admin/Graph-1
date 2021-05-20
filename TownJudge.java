
/*
 *  Time Complexity: O(N+M) Where N is the number of persons and M is the the number of trusts. 
 *  Space Complexity: O(N) Since we are creating a dp array with N length
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Cretate an indegree array of length N+1, where N represent the number of person in the town. Now we iterate over teh trust array and for each person being trusted we increment the degree in the indegree array, and we decrement the degree for each person who is trusting. So now we can iterate over the indegree array and if any index starting from 1 has the degree equal to N-1 we return the index. 
 */

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==0) return -1;
        int dp[] = new int[n+1];
        for(int[] curr : trust){
            dp[curr[1]]++;
            dp[curr[0]]--;
        }
        for(int i=1;i<dp.length;i++){
            if(dp[i]==n-1) return i;
        }
        return -1;
    }
}
