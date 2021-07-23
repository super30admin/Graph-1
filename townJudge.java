// Time: O(V+E) where v is n and e is trust relationship from one persont to another given in trust array
//Space: O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n];
        for(int[] t: trust){
            indegrees[t[1]-1]++;
            indegrees[t[0]-1]--;
        }
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i] == n-1){
                return i+1;
            }
        }
        return -1;
    }
}