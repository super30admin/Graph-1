// Time Complexity : O(n) n - number of people
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] arr = new int[N+1];
        for(int[] i:trust){
            arr[i[0]]--;
            arr[i[1]]++;
        }
        for(int i=1;i<=N;i++){
            if(arr[i] == N-1)
                return i;
        }
        return -1;
    }
}
