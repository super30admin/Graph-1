// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] arr = new int[n+1];
        
        for(int i=0;i < trust.length;i++) {
            arr[trust[i][0]]--;
            arr[trust[i][1]]++;
        }
        
        for(int i=1;i<arr.length;i++) {
            if(arr[i] == n-1) {
                return i;
            }
        }
        
        return -1;
    }
}