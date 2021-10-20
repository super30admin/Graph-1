// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// increase the count of the one who is trusted and decrease for the one who is trusting
// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] result = new int[n];
        for(int i = 0; i<trust.length; i++){
            result[trust[i][0]-1]--;
            result[trust[i][1]-1]++;
        }
        System.out.println(Arrays.toString(result));
        for(int i = 0; i < n; i++){
            if( result[i] == n-1) return i+1;
        }
        return -1;
    }
}