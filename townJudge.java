// Time Complexity : O(Math.max(n,E)) --> O(E+n) n-number of people in the town , E- edges in the trust array
// Space Complexity : O(n) 
// https://leetcode.com/problems/find-the-town-judge/
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust==null) return -1;
         int[] arr=new int[N+1];
        
         for(int[] i:trust)
         {
             arr[i[0]]--;
             arr[i[1]]++;
         }
        
         for(int i=1;i<N+1;i++)
         {
             if(arr[i]==N-1)
                 return i;
         }
        return -1;
        
    
    }
}