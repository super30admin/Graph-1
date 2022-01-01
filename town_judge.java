//Approach: Maintain a count array. We know that town judge does not trust anyone and 
//is trusted by everyone. trust[0] is trust giver and trust reciever is trust[1], so dec the index(here, person) if trust is given, inc the index if trust is recieved.
//TC: O(E)
//SC: O(N)
class Solution {
    
    public int findJudge(int N, int[][] trust) {
        int[] trustTaken = new int[N+1];
        
        for (int[] t: trust) {
            trustTaken[t[0]]--;//As trust is given, it is dec.
            trustTaken[t[1]]++;
        }
        for (int i = 1; i <= N; i++) 
            if (trustTaken[i] == N - 1) return i;
        
        return -1;
    }
}