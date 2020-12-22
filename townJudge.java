// Time Complexity : o(V+E)
// Space Complexity : o(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 997

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N];
        int[] trustee = new int[N];
        for(int[] ind : trust){
           count[ind[1]-1]+=1;
        }
        for(int[] ind : trust){
           trustee[ind[0]-1]+=1;
        }
        for(int i = 0 ; i < N ; i++){
            if(count[i] == N-1 && trustee[i] == 0) return i+1;
        }
        
        return -1;
    }
}