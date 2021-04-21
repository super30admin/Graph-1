// TC - O(n), SC - O(n)

// LC - 997

class Solution {
    public int findJudge(int N, int[][] trust) {
        // creating two matrices inbound and outbound. For eg [[1,3], [2,3]] -> 1 trusts 3 and 2 trusts 3. If we draw a graph 1 ---> 3  <--- 2. inbound of 3 is 2 and outbound of 1 and 2 is 1  
        int[] inbound = new int[N+1];
        int[] outbound = new int[N+1];
        
        for(int i=0; i<trust.length; i++){
            inbound[trust[i][1]]++;
            outbound[trust[i][0]]++;
        }
        // To become a town judge, the person needs to be trusted by N-1 and that person should not trust anyone.	
        for(int i=1; i<inbound.length; i++){
            if(inbound[i] == N-1 && outbound[i] == 0){
                return i;
            }
        }
        return -1;
    }
}