//https://leetcode.com/submissions/detail/621081325/
//Time: O(length of trust array)
//Space: O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] list = new boolean[n];
        
        for(int i = 0; i < trust.length; i++) {
            list[trust[i][0] - 1] = true;
        }
        
        boolean conditionOne = false;
        int judge = -1;
        
        for(int i = 0; i < list.length; i++){
            if(list[i] == false) {
                judge = i+1;
                conditionOne = true;
            }
        }
        
        if(conditionOne == false){
            return -1;    
        }
    
        int count = 0;
        for(int i = 0; i < trust.length; i++){
           if(trust[i][1] == judge) {
               count++;
           }
        }
        if(count >= n-1 ) {
            return judge;
        } else {
            return -1;
        }
    }
}