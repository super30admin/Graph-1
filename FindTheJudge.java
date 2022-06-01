// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] following = new int[n + 1];
        int[] outDegree = new int[n + 1];
        
        for(int[] persons: trust) {
            following[persons[1]]++;
            following[persons[0]]--;
        }
        
        for(int i = 1; i <= n; i++) {
            if(following[i] == n-1) {
                return i;
            }
        }
        
        return -1;
    }
}