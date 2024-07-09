// Time Complexity : O(V+E) where V is the number of people(n) and E is the length of the trust array
// Space Complexity :O(V) where V is the number of people(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

public class TownJudge {
    public int findJudge(int n, int[][] trust) {
        if(trust == null){
            return -1;
        }
        int[] inAndOutDegree = new int[n];
        for(int[] trustRelationship: trust){
            int trusting = trustRelationship[0];
            int trusted = trustRelationship[1];
            inAndOutDegree[trusting-1]--;
            inAndOutDegree[trusted-1]++;
        }
        for(int i=0; i<n; i++){
            if(inAndOutDegree[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}
