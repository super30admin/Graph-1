// Time Complexity :O(E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];
        for(int[] t:trust){
            System.out.println("p"+t[0]+t[1]);
            count[t[0]]--;
            System.out.println(count[t[0]]);
            count[t[1]]++;
            System.out.println(count[t[1]]);
        }
        
        for(int i=1;i<=n;i++){
            if(count[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}