// Time Complexity : O(V+E)
// Space Complexity : O(V);
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int N, int[][] trust) {
        //array to hold incoming arrows
        int [] comingDegrees = new int[N];
        //start a loop through the trust array
        for(int [] t : trust){
            //increment and decrement comingarrows
            comingDegrees[t[0] - 1]--;
            comingDegrees[t[1] - 1]++;            
        }
        //find the one with positive and n-1 number that is the judge
        for(int i = 0; i < N; i++){
            if(comingDegrees[i] == N -1){
                return i+1;
            }
        }
        //if nothing return -1
        return -1;
    }
}