//Approach - 1: Graphs, vertex and edge, dec-- edge[0] is trusting the edge[1] inc++, return a[i] == n-1
//Time Complexity : O(V+E)
//Space Complexity : O(V) ==> O(n)


//TC = O(v+E)
//Space = ??
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int [] indegrees = new int[n]; // array n size
        
        for(int [] edge : trust){
            indegrees[edge[0]-1]--; // edge[0] is trusting the edge[1]
            indegrees[edge[1]-1]++;
        }
        for(int i=0; i<n;i++){
            if(indegrees[i] == n-1) return i+1; //return  index
        }
        return -1;
    }
}
