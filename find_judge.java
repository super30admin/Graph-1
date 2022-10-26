// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n];

        for(int [] t : trust){
            int r = t[0];
            int c = t[1];

            in[r-1]--;
            in[c-1]++;
        }

        for(int i=0;i<n;i++){
            if(in[i]==n-1) return i+1;
        }

        return -1;
    }
}