//TC : O(E) , where E is the number of judges
//SC : O(N) , where N is the length of trust array
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust.length == 0 || trust == null)
            return N;
        
        int[] edge = new int[N];
        for(int[] t : trust){
            int person = t[0];
            int potentialJudge = t[1];
            
            edge[person-1]--;
            edge[potentialJudge-1]++;
        }
        
        for(int i=0;i<edge.length;i++){
            if(edge[i] == N-1)
                return i+1;
        }
        return -1;
    }
}