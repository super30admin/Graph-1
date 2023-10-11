//TC:O(n) 
//SC:O(n)

class Solution {
   public int findJudge(int N, int[][] trust) {
       if(trust.length==0){
           return N==1?1:-1;
       }
       int[] t=new int[N];
       int[] trusted=new int[N];
       for(int i=0;i<trust.length;i++){
           int a=trust[i][0];
           int b=trust[i][1];
           t[a-1]++;
           trusted[b-1]++;
       }
       for(int i=0;i<N;i++){
           if(t[i]==0&&trusted[i]==N-1){
               return i+1;
           }
       }
       return -1;
   }
}