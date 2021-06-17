// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class TownJudge {

    public int findJudge(int n, int[][] trust) {
        
        if (trust.length < n - 1) return -1;
        int[] trusted = new int[n];
        
        // Iterate over the edges array and compute In degree and Out Degree for each vertex.
        for(int[] singleTrust: trust){
            trusted[singleTrust[0]-1]--;
            trusted[singleTrust[1]-1]++;
        }
        
        // Vertex whose In Degree value is equal to n-1 is the judge.
        for(int i = 0; i < trusted.length; i++){
            if(trusted[i] == n-1) return ++i;
        }
        return -1;
    }
    
}
