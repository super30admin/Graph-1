//Problem 114 : Find the Town Judge
//TC:O(V+E)
//SC:O(V) or O(N)

/*
Steps: Find a person who is not trusting anyone but get trust from everyone
       Use the concept of indegrees
*/
class Solution114 {
    public int findJudge(int N, int[][] trust) {
        
        //TC:O(V+E) ||SC:O(V) or O(N)
        int[] inDegrees = new int[N];
        
        for(int[] t:trust){
            inDegrees[t[1]-1]++;
            inDegrees[t[0]-1]--;//reduce indegree if a person supports any other person
        }
        
        int i=0;
        for(int inDegree:inDegrees){
            if(inDegree==N-1) return i+1;
            
            i++;
        }
        
        return -1;
    }
}