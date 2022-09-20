//TC : O(N)
//SC : O(2N)

class Solution {
   public int findJudge(int N, int[][] trust) {
       if(trust.length==0){
           return N==1?1:-1;
       }
       int[] trusts=new int[N];
       int[] trustedBy=new int[N];
       for(int i=0;i<trust.length;i++){
           int a=trust[i][0];
           int b=trust[i][1];
           trusts[a-1]++;
           trustedBy[b-1]++;
       }
       for(int i=0;i<N;i++){
           if(trusts[i]==0&&trustedBy[i]==N-1){
               return i+1;
           }
       }
       return -1;
   }
}
