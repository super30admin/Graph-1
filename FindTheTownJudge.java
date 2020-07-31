// Time Complexity : O(N*Trust_array)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 Bruteforce :
 1. For every possible member from 1 to N check the two conditions in trust array.
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        int flag =0; int count=0;
        for(int k=1;k<N+1;k++){
            flag =0; count =0;
            for(int i=0; i<trust.length; i++){
                if(trust[i][1]==k){
                    count++;
                }
                else{
                    if(trust[i][0]!=k){
                        flag = 0;
                    }
                    else{
                        flag = 1;
                        break;
                    }
                }
            }
            if(count == (N-1) && flag==0){
                return k;
            }
        }
        return -1;
        
    }
}



// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 Graph :
 1.Use indegree array to store the no. of trusts. 
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null) return -1;
        if(N == 1) return 1;
        int[] indegrees = new int[N+1];
        for(int i=0; i<trust.length;i++){
            indegrees[trust[i][1]]++;   //no. of trusts a person gets
            indegrees[trust[i][0]]--;   //no. of trusts a person gives
        }
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==N-1)      //if everyone except the himself trusts (N-1) = townjudge
                return i;
        }
        return -1;
        
    }
}