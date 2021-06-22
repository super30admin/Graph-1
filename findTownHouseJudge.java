//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int findJudge(int n, int[][] trust) {
     
        
        int[] inorder = new int[n+1];
        
        for(int i = 0; i < trust.length; i ++){
            
            inorder[trust[i][0]] =  inorder[trust[i][0]] - 1 ; 
            inorder[trust[i][1]] =  inorder[trust[i][1]] + 1  ; 
        }
        
        for(int i = 1; i < inorder.length; i ++){
            
            if(inorder[i] == n-1){
                
                return i ;
            }
        }
        
        return -1;
    }
}