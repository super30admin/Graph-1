// Problem1 Find Judge (https://leetcode.com/problems/find-the-town-judge/)

// Time Complexity : O(v+e)
// Space Complexity : O(e)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, maintain a indegrees array of size n+1 and for all the values at 0th of trust array decrease indegree by 1 and for 1st position increase 
 * indegree by 1. If at any index in indegrees array indegree is n-1 then return that position. In other cases return -1.
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        int []indegrees = new int[n+1];
        for(int []trus: trust){
            indegrees[trus[0]]--;
            indegrees[trus[1]]++;
        }
        for(int i = 1; i <= n; i++){
            if(indegrees[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}