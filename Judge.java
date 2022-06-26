//time - O(n)
//space - O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outorder = new int[n+1];
        for(int i =0; i<trust.length ; i++ ){
            outorder[trust[i][1]]+=1;
            outorder[trust[i][0]]-=1;
            
        }
        
        for(int i =1; i< outorder.length; i++){
            System.out.println(outorder[i]);
            if(outorder[i] == n-1){
                return i; 
            }
        }
        return -1;
    }
}