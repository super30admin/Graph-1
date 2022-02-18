// Time Complexity : O(V+E) -V : Trustee, E - No. of ppl trusting
// Space Complexity : O(n) - For storing indegree array
// Did this code successfully run on Leetcode : Yes

public class FindTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n+1];

        //Ex: [1,2] -> 1 is trusting 2
        for(int[] t : trust){
            indeg[t[1]]++; // indeg(2) increases
            indeg[t[0]]--; // indeg(1) decreases
        }

        for(int i = 1;i < indeg.length; i++){
            if(indeg[i] == n-1) return i;
        }
        return -1;
    }
}
