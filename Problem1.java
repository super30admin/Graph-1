//time complexity: O(V+E), vertices and edges
//space complexity: O(N); 

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegrees = new int[N];
        // O(E)
        for(int[] t: trust){
            indegrees[t[0]-1]--;
            indegrees[t[1]-1]++;
        }
        // O(V)
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == (N-1)) return i+1;
        }
        return -1;
        
    }
}