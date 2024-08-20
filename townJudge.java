/*
TC --> O(n)
SC --> O(n)
*/
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outgoing = new int[n+1];
        int[] incoming = new int[n+1];
        for(int i=0;i<trust.length;i++){
            outgoing[trust[i][0]]++;
            incoming[trust[i][1]]++;
        }//for

        for(int i=1;i<n+1;i++){
            if(outgoing[i]==0 && incoming[i]==n-1){
                return i;
            }

            
        }
        return -1;


    }//method
}//class