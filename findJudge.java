// Time Complexity : O(N^2) where N is the number of people. Links in worst case can be N^2
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n+1];
        for(int[] link:trust){
            degree[link[0]]--;
            degree[link[1]]++;
        }
        for(int i = 1 ; i < n+1 ; i++)
            if(degree[i] == n-1)
                return i;
        return -1;
        
    }
}
