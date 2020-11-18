// Time Complexity : O(N) - as we iterate through the whole array
// Space Complexity : O(N) - As we use an additional counter array to determine the town judge
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        for(int i = 1;i <= N;i++){
            if(count[i] == N - 1) return i;
        }
        return -1;
    }
}
// Your code here along with comments explaining your approach