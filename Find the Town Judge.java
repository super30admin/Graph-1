// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will create an indegrees array, of size n. If a number and index 0 trusts a number and index 1, then we will increment the value of the value at index 1 by 1 
// and decrement the value at index 0 by 1. 
// In the end we will return the index where the value is equal to n-1, as that is the town judge who is trusted by everyone
class Solution {
    public int findJudge(int n, int[][] trust) {

        int[]indegrees=new int[n];
        for(int[]tr:trust)
        {
            indegrees[tr[1]-1]++;
            indegrees[tr[0]-1]--;
        }
        //iterate through the indegrees array
        for(int i=0;i<n;i++)
        {
            if(indegrees[i]==n-1)
            {
                return i+1;
            }
        }
        return -1;
    }
}