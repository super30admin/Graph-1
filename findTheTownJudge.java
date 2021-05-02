//TC: O(n)
//SC: O(n) 

class Solution {
    public int findJudge(int N, int[][] trust) {

        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];
        
        for(int i = 0;i < trust.length; i++){
            inDegree[trust[i][1]]+=1;
            outDegree[trust[i][0]]+=1;
        }
        
        //check the conditions for becoming town judge:
        //1. trusted by N-1 people
        //2. not having back edge
        
        for(int i =1;i<inDegree.length;i++){
            if(inDegree[i] == (N-1) && outDegree[i] == 0){
                return i;
            }
        }
        
        return -1;
    }
}