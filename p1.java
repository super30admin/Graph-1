// Time Complexity :O(v+e)
// Space Complexity :O(v)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int n, int[][] trust) {
        //calculate indergrees and outdegrees
        int[] in = new int[n];

        for(int[] arr: trust){
            //a trusts b
            int a = arr[0];
            int b = arr[1];
            in[a-1]--;
            in[b-1]++;
        }

        //Judge will be the one who has 0 outdegrees and n-1 indegrees
        for(int i=0; i<n;i++){
            if(in[i] == n-1) return i+1;
        }

        return -1;
    }
}